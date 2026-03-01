extends Sprite2D

func _ready():
	lancer_animation_discrete()

func lancer_animation_discrete():
	var tween = create_tween().set_loops()
	

	tween.tween_property(self, "scale", Vector2(0.53, 0.53), 1.0).set_trans(Tween.TRANS_SINE)
	
	tween.tween_property(self, "scale", Vector2(0.43, 0.43), 1.0).set_trans(Tween.TRANS_SINE)
