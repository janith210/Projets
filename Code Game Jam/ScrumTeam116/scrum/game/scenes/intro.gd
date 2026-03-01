extends Node2D

@onready var anim = $AnimationPlayer # Ton animation de texte "apparition"

func _ready():
	# 1. On lance l'animation de la machine à écrire
	if anim:
		anim.play("apparition")
		
	await get_tree().create_timer(4.0).timeout
		
	if anim:
		anim.play("animation2")
	
	await get_tree().create_timer(6.0).timeout
	# 3. Une fois les 5s passées, on lance le vrai jeu !
	lancer_le_jeu()

func _input(event):
	# OPTIONNEL : Si le joueur clique, il peut passer l'histoire plus vite
	if event.is_action_pressed("left_click") or event.is_action_pressed("ui_accept"):
		lancer_le_jeu()

func lancer_le_jeu():
	get_tree().change_scene_to_file("res://game/scenes/game.tscn")
