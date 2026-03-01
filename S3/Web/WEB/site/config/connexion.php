<?php
class Connexion {
    // 1. Tes identifiants XAMPP
    static private $hostname = 'localhost'; 
    static private $database = 'saes3-rstinus'; // <--- ⚠️ METS ICI LE VRAI NOM DE TA BASE DE DONNÉES
    static private $login = 'saes3-rstinus'; 
    static private $password = 'oQEgrzbFxrRmpTYE'; 

    // 2. Options d'encodage (pour les accents)
    static private $tabUTF8 = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");

    // 3. La variable qui gardera la connexion ouverte
    static private $pdo = null;

    // Fonction appelée par le Modèle pour faire des requêtes
    public static function pdo() {
        // Si la connexion n'existe pas encore, on la crée
        if (self::$pdo === null) {
            self::connect();
        }
        return self::$pdo;
    }

    // Fonction appelée par le Routeur (pour initialiser)
    public static function connect() {
        if (self::$pdo === null) {
            try {
                self::$pdo = new PDO(
                    "mysql:host=" . self::$hostname . ";dbname=" . self::$database,
                    self::$login,
                    self::$password,
                    self::$tabUTF8
                );
                // Active l'affichage des erreurs SQL (très utile pour débugger)
                self::$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            } catch (PDOException $e) {
                echo "Erreur de connexion SQL : " . $e->getMessage();
                die();
            }
        }
    }
}
?>

