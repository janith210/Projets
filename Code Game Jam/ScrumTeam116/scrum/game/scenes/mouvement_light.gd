extends PointLight2D

var noise = FastNoiseLite.new()
var temps = 0.0

@export var vitesse_flicker = 10.0
@export var intensite_min = 0.5
@export var intensite_max = 2.0

func _ready():
	# Configuration du bruit pour qu'il soit "nerveux" comme une TV
	noise.seed = randi()
	noise.frequency = 0.5 # Plus c'est haut, plus ça clignote vite

func _process(delta):
	temps += delta * vitesse_flicker
	# get_noise_1d renvoie une valeur entre -1 et 1
	var valeur_bruit = noise.get_noise_1d(temps)
	
	# On transforme cette valeur pour qu'elle reste entre nos bornes min et max
	energy = remap(valeur_bruit, -1, 1, intensite_min, intensite_max)
