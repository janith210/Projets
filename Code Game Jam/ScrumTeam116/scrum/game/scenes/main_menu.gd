extends Control

func _ready():
	pass
	
func _process(delta):
	pass
@onready var cible_zoom =$positionZoom
func _on_start_pressed():
	# On désactive le bouton pour éviter le double-clic
	# Si vous avez renommé le bouton, adaptez le nom ci-dessous (ex: $VBoxContainer/StartButton)
	$VBoxContainer/Start.disabled = true
	
	# --- CALCUL DU PIVOT ---
	if cible_zoom:
		# On récupère la position exacte de votre Node2D sur l'écran
		pivot_offset = cible_zoom.global_position
	else:
		# Sécurité : si vous avez oublié de mettre le Node2D, on zoom au centre
		pivot_offset = size / 2
		print("Attention : Pas de cible_zoom assignée dans l'inspecteur !")
	
	# --- ANIMATION ---
	var tween = create_tween()
	tween.set_parallel(true)
	tween.set_trans(Tween.TRANS_EXPO)
	tween.set_ease(Tween.EASE_IN)
	
	# Zoom x20 (très fort) en 1 seconde
	tween.tween_property(self, "scale", Vector2(20.0, 20.0), 1.0)
	tween.tween_property(self, "modulate:a", 0.0, 1.0)
	
	await tween.finished
	# On change "game.tscn" par "intro.tscn"
	get_tree().change_scene_to_file("res://game/scenes/intro.tscn")


func _on_exit_pressed():
	get_tree().quit()
