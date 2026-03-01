extends Area2D

var minijeu_scene = preload("res://game/scenes/tache_fenetre.tscn")
@export var nom_objet : String = "fenetre"

var joueur_actuel = null
var est_propre = false # Variable pour bloquer l'interaction

func _on_body_entered(body: Node2D) -> void:
	if body.name == "Player" or body.name == "player":
		joueur_actuel = body
		# On permet l'interaction SEULEMENT si ce n'est pas propre
		if not est_propre:
			body.vue_fenetre = self
			print("Une fenêtre sale. Utilise le sceau !")

func _on_body_exited(body: Node2D) -> void:
	if body.name == "Player" or body.name == "player":
		joueur_actuel = null
		if  body.vue_fenetre == self:
			body.vue_fenetre = null

func interagir():
	# 1. Si c'est propre, on refuse de lancer le jeu
	if est_propre:
		print("C'est déjà propre !")
		return

	lancer_minijeu()

func lancer_minijeu():
	var minijeu = minijeu_scene.instantiate()
	
	# 2. On se donne en référence au mini-jeu
	minijeu.fenetre_source = self 
	
	var interface_layer = CanvasLayer.new()
	interface_layer.add_child(minijeu)
	get_tree().current_scene.add_child(interface_layer)
	get_tree().paused = true

# 3. La fonction qui active le "disable"
func devenir_propre():
	est_propre = true # On verrouille la fenêtre
	
	# On retire la fenêtre de la "main" du joueur pour qu'il ne puisse plus appuyer sur E/A
	if joueur_actuel:
		joueur_actuel.vue_fenetre = null
	
	# Optionnel : Changer la couleur pour montrer que c'est fini (ex: un peu transparent)
	modulate.a = 0.5
