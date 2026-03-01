extends Area2D

# TRÈS IMPORTANT : Donne le bon nom ici pour chaque objet (balai, sceau ou marteau)
@export var nom_objet : String = "sceau" 

func _on_body_entered(body: Node2D) -> void:
	if body.name == "player" or body.has_method("move_and_slide"):
		body.objet_au_sol = self 
		print("Prêt à ramasser : ", nom_objet)

func _on_body_exited(body: Node2D) -> void:
	if body.name == "player" or body.has_method("move_and_slide"):
		# On ne vide que si c'est BIEN cet objet qui était enregistré
		if body.objet_au_sol == self:
			body.objet_au_sol = null
