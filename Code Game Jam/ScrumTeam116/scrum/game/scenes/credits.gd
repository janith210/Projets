extends Label

@export var vitesse_defilement : float = 60.0 # Vitesse en pixels par seconde
@export var pause_debut : float = 1.0        # Temps d'attente avant de démarrer

var en_mouvement : bool = false

func _ready():
	# 1. On centre le texte horizontalement
	horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	
	# 2. On place le label tout en bas de l'écran pour commencer
	# (On utilise la taille de l'écran via le Viewport)
	position.y = get_viewport_rect().size.y
	
	# 3. On attend un peu avant de lancer le défilement
	await get_tree().create_timer(pause_debut).timeout
	en_mouvement = true

func _process(delta):
	if en_mouvement:
		# On fait monter le label
		position.y -= vitesse_defilement * delta
		
		# On vérifie si tout le texte est sorti par le haut de l'écran
		if position.y + size.y < 0:
			fin_des_credits()

func fin_des_credits():
	en_mouvement = false
	print("Crédits terminés !")
