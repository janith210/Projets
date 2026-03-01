extends ProgressBar
@onready var body = $"../../player"
@onready var mon_label = $"../Label"
@onready var mon_label2 = $"../Label2"
@onready var mon_font = $"../ColorRect"
@onready var mon_font2 = $"../ColorRect2"
@onready var effet_alcool = $"../ColorRect3"

var speed_base

func _ready() -> void:
	value = 1
	speed_base = body.speed
	
	mon_label.visible = false
	mon_font.visible = false
	mon_label2.visible = false
	mon_font2.visible = false

func _process(delta: float) -> void:
	if(value == max_value):
		mon_label.visible = true
		mon_font.visible =true
		body.speed = 0
		effet_alcool.visible = true
		await get_tree().create_timer(5.0).timeout
		value = 0
		body.speed = speed_base
		mon_label.visible = false
		mon_font.visible = false
		effet_alcool.visible = false
		await get_tree().create_timer(1.0).timeout
		mon_label2.visible = true
		mon_font2.visible = true
		
		await get_tree().create_timer(4.0).timeout
		mon_label2.visible = false
		mon_font2.visible = false
		
