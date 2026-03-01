extends Area2D

# On définit un type d'objet spécial ou un nom
@export var nom_objet : String = "fenetre"

func _on_body_entered(body: Node2D) -> void:
	if body.name == "player" or body.has_method("move_and_slide"):
		body.objet_au_sol = self # On utilise la même variable que pour les objets
		print("Près de la fenêtre. Appuyez sur E pour regarder.")

func _on_body_exited(body: Node2D) -> void:
	if body.name == "player" or body.has_method("move_and_slide"):
		if body.objet_au_sol == self:
			body.objet_au_sol = null

# On ajoute une fonction que le joueur pourra appeler
func interagir():
	print("L'air est frais ! Tu regardes par la fenêtre.")
	# Ici tu pourras plus tard ouvrir des rideaux, changer l'image, etc.
