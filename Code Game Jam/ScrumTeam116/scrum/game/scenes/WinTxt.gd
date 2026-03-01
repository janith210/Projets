extends Label

# On pointe vers les enfants avec des chemins relatifs au CanvasLayer
@onready var label_roast = $"."
@onready var bouton_rejouer = $"../Button"

# Configuration
@export_file("res://game/scenes/main_menu.tscn") var scene_a_charger : String
@export var duree_apparition : float = 1.5
@export var temps_attente : float = 2.0
@export var duree_disparition : float = 1.0

func _ready():	
	# 1. Préparation du texte aléatoire
	var ma_liste = [
		"Tu as été assez rapide, tes parents sont fiers de toi",
		"T'es trop fast, go refaire la fête",
		"Tips: essaye de speedrun"
	]
	
	label_roast.text = ma_liste.pick_random()
	
	# 2. Initialisation (Invisible et désactivé)
	label_roast.modulate.a = 0
	label_roast.scale = Vector2(0.8, 0.8)
	
	bouton_rejouer.modulate.a = 0
	bouton_rejouer.disabled = true
	
	# Fix du pivot pour que le zoom du texte parte du centre
	await get_tree().process_frame
	label_roast.pivot_offset = label_roast.size / 2
	
	lancer_sequence()

func lancer_sequence():
	var tween = create_tween()
	
	# --- PHASE 1 : APPARITION DU TEXTE ---
	tween.tween_property(label_roast, "modulate:a", 1.0, duree_apparition).set_trans(Tween.TRANS_QUINT).set_ease(Tween.EASE_OUT)
	tween.parallel().tween_property(label_roast, "scale", Vector2(1.0, 1.0), duree_apparition).set_trans(Tween.TRANS_QUINT).set_ease(Tween.EASE_OUT)
	
	# --- PHASE 2 : ATTENTE ---
	tween.tween_interval(temps_attente)
	
	# --- PHASE 3 : DISPARITION DU TEXTE ---
	tween.tween_property(label_roast, "modulate:a", 0.0, duree_disparition).set_trans(Tween.TRANS_LINEAR)
	
	# --- PHASE 4 : APPARITION DU BOUTON ---
	# On attend un petit délai après la disparition du texte
	tween.tween_interval(0.5)
	# On rend le bouton cliquable et on le montre
	tween.tween_callback(func(): bouton_rejouer.disabled = false)
	tween.tween_property(bouton_rejouer, "modulate:a", 1.0, 0.8)


func _on_button_pressed() -> void:
	pass # Replace with function body.
