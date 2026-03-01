shader_type canvas_item;

uniform sampler2D SCREEN_TEXTURE : hint_screen_texture, filter_linear_mipmap;
uniform float distortion_strength : hint_range(0.0, 0.1) = 0.02;
uniform float wave_speed : hint_range(0.0, 5.0) = 3.0;
uniform float blur_amount : hint_range(0.0, 5.0) = 1.0;

void fragment() {
    // Calcul de la déformation (vague)
    vec2 uv = SCREEN_UV;
    uv.x += sin(TIME * wave_speed + uv.y * 10.0) * distortion_strength;
    uv.y += cos(TIME * wave_speed + uv.x * 10.0) * distortion_strength;
    
    // Récupération de la texture avec un flou léger
    vec4 color = textureLod(SCREEN_TEXTURE, uv, blur_amount);
    
    // Optionnel : ajouter une légère teinte rosée/rouge
    color.r += 0.05; 
    
    COLOR = color;
}