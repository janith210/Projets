extends ProgressBar

@onready var player= $"/root/Game/player"
var random = 1.0
var objet_cible = null # Variable pour stocker l'objet qu'on est en train de casser
signal minijeu_reussi
@onready var sfx = $AudioStreamPlayer
func _ready() -> void:
	# On cache la barre au début du jeu
	visible = false
	value = 0.0

func _input(event):
	# Si le mini-jeu n'est pas affiché, on ignore les clics
	if not visible:
		return

	if event.is_action_pressed("left_click"): 
		# On augmente la valeur (code original )
		value += 5.0 * random
		sfx.play()

func _process(delta: float) -> void:
	# Si la barre est cachée, on ne calcule rien
	if not visible:
		return
	
	# Condition de victoire
	if value >= 100:
		print("Victoire mini-jeu marteau") 
		terminer_minijeu()
		
	# Difficulté : la barre descend toute seule
	if value > 0:
		value -= 0.1 # Tu peux augmenter ce chiffre pour rendre le jeu plus dur 

# --- FONCTIONS PERSONNALISÉES ---

# Cette fonction est appelée par le Player lors du Clic Droit
func lancer_minijeu(objet_a_detruire):
	position=player.position+Vector2(-30,15)
	player.process_mode = Node.PROCESS_MODE_DISABLED
	objet_cible = objet_a_detruire
	value = 0.0
	visible = true
	
	# On génère un facteur aléatoire pour varier la difficulté 
	random = 1 + randf() 
	print("Mini-jeu lancé ! Force du marteau : ", random)

# Cette fonction gère la fin du jeu (victoire)
func terminer_minijeu():
	# Si on a bien une cible enregistrée, on la détruit
	if objet_cible != null:
		minijeu_reussi.connect(player.tache_accomplie)
		minijeu_reussi.emit()
		objet_cible.queue_free() # Supprime l'objet de la scène
		objet_cible = null
		player.process_mode = Node.PROCESS_MODE_INHERIT
	
	# On cache la barre et on remet à zéro
	visible = false
	value = 0.0
