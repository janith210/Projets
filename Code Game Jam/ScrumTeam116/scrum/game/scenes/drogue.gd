extends Area2D

@onready var health_bar = $"/root/Game/health_bar/ProgressBar"
@onready var smoke = $"../AudioStreamPlayer"
@onready var player= $"/root/Game/player"

signal minijeu_reussi
func _on_body_entered(body: Node2D) -> void:
	# On vérifie si l'objet qui entre est bien le joueur
	if body.name == "Player" or body.has_method("move_and_slide"): 
		print("Le joueur a pris un boost !")
		smoke.play()
		# 1. On applique le bonus
		body.speed *= 1.5
		
		health_bar.value += 3
		
		# 2. On rend l'objet invisible et on désactive ses collisions
		# Pour éviter que le joueur ne le reprenne pendant l'attente
		visible = false
		minijeu_reussi.connect(player.tache_accomplie)
		minijeu_reussi.emit()
		set_deferred("monitoring", false) # Désactive la détection de zone
		set_deferred("monitorable", false)
		
		# 3. On attend 5 secondes
		await get_tree().create_timer(4.0).timeout
		
		# 4. On remet la vitesse d'origine (on divise par le même multiplicateur)
		if is_instance_valid(body): # On vérifie que le joueur existe toujours
			body.speed /= 1.5
			
			
		queue_free()
