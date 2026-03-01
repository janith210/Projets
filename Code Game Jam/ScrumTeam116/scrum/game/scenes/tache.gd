extends Area2D
@onready var sound = $"../AudioStreamPlayer"

func _input_event(viewport, event, shape_idx):
	if event is InputEventMouseButton and event.button_index == MOUSE_BUTTON_LEFT and event.pressed:
		var fenetre = get_parent()
		print("Parent trouvé : ", fenetre.name)
		
		# On vérifie que le parent sait bien "ajouter des points" avant de l'appeler
		if fenetre.has_method("ajouter_point"):
			sound.play()
			fenetre.ajouter_point()
			print("Point ajouté !")
		else:
			print("ERREUR : Le parent n'a pas de fonction ajouter_point()")
			
		queue_free()
