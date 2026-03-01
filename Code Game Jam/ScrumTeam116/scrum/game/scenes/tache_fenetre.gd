extends Node2D 

@onready var tache = $tache
@onready var time = $Timer
@onready var player= $"/root/Game/player"
# 1. Variable pour stocker la fenêtre qui a lancé ce jeu
var fenetre_source = null 
signal minijeu_reussi
var compteur = 0
const TAILLEX_MAX = 1100
const TAILLEY_MAX = 700
const TAILLEX_MIN = 450
const TAILLEY_MIN = 225

func _ready():
	process_mode = Node.PROCESS_MODE_ALWAYS
	tache.visible = false

func _on_timer_timeout() -> void:
	var randomx = randf_range(TAILLEX_MIN, TAILLEX_MAX)
	var randomy = randf_range(TAILLEY_MIN, TAILLEY_MAX)
	var tachetemp = tache.duplicate()
	tachetemp.position = Vector2(randomx, randomy)
	tachetemp.visible = true
	tachetemp.add_to_group("les_taches") 
	add_child(tachetemp)

func ajouter_point():
	compteur += 1
	print("Taches essuyées : ", compteur)
	
	if compteur >= 10:
		
		print("VICTOIRE ! Retour au jeu.")
		time.stop()
		
		# 2. IMPORTANT : On dit à la fenêtre de se désactiver
		if fenetre_source != null and fenetre_source.has_method("devenir_propre"):
			fenetre_source.devenir_propre()
		
		get_tree().call_group("les_taches", "queue_free")
		get_tree().paused = false		
		minijeu_reussi.connect(player.tache_accomplie)
		minijeu_reussi.emit()
		get_parent().queue_free()
