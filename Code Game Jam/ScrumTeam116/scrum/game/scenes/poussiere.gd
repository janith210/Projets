extends TextureRect

# Ce signal est indispensable pour que le MiniJeu compte les points !
signal nettoyee

func _on_mouse_entered():
	# 1. On prévient le compteur qu'on a gagné 1 point
	emit_signal("nettoyee")
	
	# 2. On supprime la poussière
	queue_free()
