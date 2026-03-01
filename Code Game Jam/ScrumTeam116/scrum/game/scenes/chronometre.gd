extends Label

@export var starting_time : float = 180.0 
var time_left : float
var is_active : bool = true

func _ready() -> void:
	time_left = starting_time

func _process(delta: float) -> void:
	if is_active:
		time_left -= delta
		
		if time_left <= 0:
			time_left = 0
			is_active = false
			timer_finished()
		
		text = format_time(time_left)

func format_time(time: float) -> String:
	var minutes := int(time / 60)
	var seconds := int(time) % 60
	return "%02d:%02d" % [minutes, seconds]

func timer_finished():
	get_tree().change_scene_to_file("res://game/scenes/perdu.tscn")
	# Tu peux ajouter ici un changement de scène ou un Game Over
