extends Area2D
@onready var mini_jeu = $"/root/Game/mini_jeu_marteau"
@onready var mon_label = $"/root/Game/tuto_porte_cassee/LabelTutoPorte"

@export var objet_requis : String = "marteau" 

func _ready() -> void:
	mon_label.visible = false
	

func _on_body_entered(body: Node2D) -> void:
	# On vérifie si l'objet qui entre est bien le joueu
	if body.name == "player" or body.has_method("move_and_slide"): 
		if body.objet_equipe == objet_requis:
			mini_jeu.lancer_minijeu(self.get_parent())
		else :
			mon_label.visible = true
			await get_tree().create_timer(4.0).timeout
			mon_label.visible = false
			
			
			
			
