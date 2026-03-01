extends CanvasLayer

@onready var player= $"/root/Game/player"
# On charge la petite tache de poussière créée à l'étape 1
var scene_poussiere = preload("res://game/scenes/poussiere.tscn")
var cible = null
var total_poussieres = 50
var poussiere_restante = 0
signal minijeu_reussi

func _ready():
	# 1. On met le jeu principal en pause
	get_tree().paused = true
	
	# 2. On fait apparaître plein de taches
	spawn_poussieres()
	
	# 3. On lance le timer
	$Timer.start()

func spawn_poussieres():
	poussiere_restante = total_poussieres
	
	var ecran = get_viewport().get_visible_rect().size
	for i in range(total_poussieres):
		var tache = scene_poussiere.instantiate()
		
		var largeur_tache = tache.size.x
		var hauteur_tache = tache.size.y
		
		var x_max = ecran.x - 8*largeur_tache
		var y_max = ecran.y - 6*hauteur_tache
		
		var random_x = randf_range(50, x_max)
		var random_y = randf_range(150, y_max)
		
		tache.position = Vector2(random_x, random_y)
		tache.nettoyee.connect(_on_poussiere_nettoyee)
		add_child(tache)

func _on_poussiere_nettoyee():
	poussiere_restante -= 1
	if poussiere_restante <= 0:
		gagner()

func _process(delta):
	$Label.text = str(ceil($Timer.time_left))

func _on_timer_timeout():
	perdre()

func gagner():
	print("C'est propre !")
	quitter_minijeu()
	

func perdre():
	print("Raté ! Il reste de la poussière.")
	quitter_minijeu()

func quitter_minijeu():
	minijeu_reussi.emit()
	get_tree().paused = false 
	cible.queue_free()
	queue_free() 
