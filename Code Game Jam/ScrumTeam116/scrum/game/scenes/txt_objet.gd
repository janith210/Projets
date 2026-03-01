extends Label

func _ready():
	var player = get_tree().root.find_child("player", true, false)
	
	if player:
		print("DEBUG : Joueur trouvé ! Connexion en cours...")
		player.score_changed.connect(_on_player_score_changed)
	else:
		print("DEBUG : ERREUR ! Le Label n'a pas trouvé le nœud nommé 'Player'")

func _on_player_score_changed(new_value):
	print("DEBUG : Signal reçu ! Nouvelle valeur : ", new_value)
	self.text = "Equipée: " + str(new_value)
