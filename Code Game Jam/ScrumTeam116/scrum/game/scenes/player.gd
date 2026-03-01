extends CharacterBody2D

signal score_changed(new_value) # Ton signal pour le score

@onready var anim_sprite = $AnimatedSprite2D
var speed = 125 
var mousePos = null 
var objet_equipe = "" 
var est_en_animation = false
@onready var sfx = $AudioStreamPlayer
# L'objet qui est actuellement au sol sous le joueur
var objet_au_sol = null 
var vue_fenetre = null
var score = 0
var nb_objet_sol = 15 + 6 # alcool et canabis
const SCENE_VICTOIRE = "res://game/scenes/EcranVictoire.tscn"

const SCENES = {
	"balai": preload("res://game/scenes/balai.tscn"),
	"sceau": preload("res://game/scenes/sceau.tscn"),
	"marteau": preload("res://game/scenes/marteau.tscn")
}

func _input(event):
	# --- 1. GESTION DU CLIC GAUCHE (Déplacement + Nettoyage) ---
	if event.is_action_pressed("left_click"):
		
		# A. On scanne ce qu'il y a sous la souris
		var space_state = get_world_2d().direct_space_state
		var query = PhysicsPointQueryParameters2D.new()
		query.position = get_global_mouse_position()
		query.collide_with_areas = true # Indispensable pour détecter les Area2D
		
		var resultats = space_state.intersect_point(query)
		var a_clique_sur_tache = false

		# B. On vérifie si on a cliqué sur un truc spécial
		if resultats.size() > 0:
			var objet_touche = resultats[0].collider
			
			# Si c'est une tache et qu'on a le balai
			if objet_touche.is_in_group("a_balayer") and get_global_mouse_position().distance_to(position)<30:
				print("Objet sale détecté : ", objet_touche.name)
				a_clique_sur_tache = true
				
				if objet_equipe == "balai":
					lancer_minijeu(objet_touche.get_parent())
					return # STOP : On ne bouge pas, on lance le jeu
				else:
					print("Il faut le balai pour nettoyer ça !")

		# C. Si on n'a pas lancé de mini-jeu, on se déplace
		mousePos = get_global_mouse_position()
		look_at(mousePos)

	# --- 2. GESTION DE LA TOUCHE E (Ramasser / Lâcher + Score) ---
	if event is InputEventKey and event.pressed and event.keycode == KEY_E and !event.is_echo():
		
		# Cas A : Il y a un objet au sol à ramasser
		if objet_au_sol != null:
			if global_position.distance_to(objet_au_sol.global_position) < 50:
				var nom_a_prendre = objet_au_sol.nom_objet
				objet_au_sol.queue_free()
				objet_au_sol = null
				
				ramasser_nouvel_objet(nom_a_prendre)
				score_changed.emit(nom_a_prendre) # Mise à jour du score (HUD)
				sfx.play()
			else:
				# Trop loin ou bug -> on nettoie la mémoire
				objet_au_sol = null
				# Si on a un truc en main, on le lâche quand même
				if objet_equipe != "":
					score_changed.emit("rien")
					sfx.play()
					lacher_objet_actuel()
		
		# Cas B : Pas d'objet au sol, on lâche ce qu'on a en main
		elif objet_equipe != "":
			score_changed.emit("rien") # On a plus rien en main
			sfx.play()
			lacher_objet_actuel()
			
			
	if event is InputEventKey and event.pressed and event.keycode == KEY_A and !event.is_echo():
		# On vérifie si l'objet devant nous est interactif (comme la fenêtre)
		if objet_equipe=="sceau" and vue_fenetre!=null:
			vue_fenetre.interagir() # Lance le mini-jeu via fenetre.gd

func lacher_objet_actuel():
	if objet_equipe == "" or !SCENES.has(objet_equipe):
		return

	var scene_a_creer = SCENES[objet_equipe]
	var instance = scene_a_creer.instantiate()
	
	# On décale l'objet pour ne pas le ramasser instantanément
	instance.global_position = global_position + Vector2(0, 0)
	
	get_parent().add_child(instance)
	
	objet_equipe = ""
	print("Objet lâché au sol")

func ramasser_nouvel_objet(nom_objet):
	if objet_equipe != "":
		lacher_objet_actuel()
	
	objet_equipe = nom_objet
	print("Objet équipé : ", nom_objet)
	Ramasse()

func _physics_process(_delta):
	if est_en_animation: return
	
	if mousePos:
		# On calcule la direction vers la cible
		velocity = position.direction_to(mousePos) * speed
		
		# Si on arrive à destination, on s'arrête
		if position.distance_to(mousePos) < 5: # Seuil un peu plus large pour éviter les tremblements
			velocity = Vector2.ZERO
			mousePos = null 
	else:
		velocity = Vector2.ZERO
			
	move_and_slide()
	
	# --- LA CORRECTION EST ICI ---
	# On regarde la vitesse RÉELLE après collision au lieu de la vitesse théorique
	var vitesse_reelle = get_real_velocity().length()
	
	if vitesse_reelle > 10: # Si le perso bouge vraiment de plus de 10 pixels/sec
		anim_sprite.play("marcher")
	else:
		anim_sprite.play("idle")
		
		# SÉCURITÉ : Si on fonce dans un mur et qu'on n'avance plus, 
		# on annule la destination pour arrêter de forcer
		if mousePos != null and is_on_wall():
			mousePos = null
			velocity = Vector2.ZERO

func Ramasse():
	est_en_animation = true
	velocity = Vector2.ZERO
	mousePos = null
	anim_sprite.play("ramasser")
	await anim_sprite.animation_finished
	est_en_animation = false
	anim_sprite.play("idle")


func tache_accomplie():
	score += 1
	print("Tâches accomplies : ", score, " / ", nb_objet_sol)

	if score >= nb_objet_sol:
		call_deferred("changer_scene_victoire")

func changer_scene_victoire():
	print("Bravo ! Tous les objets sont traités.")
	get_tree().change_scene_to_file(SCENE_VICTOIRE)

func lancer_minijeu(objet_cible):
	print("Lancement du nettoyage...")
	velocity = Vector2.ZERO
	mousePos = null 
	
	var minijeu_scene = load("res://game/scenes/mini_Jeu_balai.tscn")
	var minijeu = minijeu_scene.instantiate()
	minijeu.cible = objet_cible
	if minijeu.has_signal("minijeu_reussi"):
		minijeu.minijeu_reussi.connect(tache_accomplie)
	
	get_tree().root.add_child(minijeu)
