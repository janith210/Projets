<?php
require_once("modele/enseignant.php");
require_once("modele/utilisateur.php");
require_once("modele/etudiant.php"); 

class ControleurEnseignant {

    public static function Accueil(){
        
        if(!isset($_SESSION['username'])){
             header("Location: routeur.php?controleur=controleurUtilisateur&action=afficherFormulaire");
        }

        $titre = "Accueil de l'enseignant " . $_SESSION['username'];
        include("vue/header.php");
        include("vue/nav.php");
        include("vue/enseignant/accueilEnseignant.php");
        include("vue/footer.php"); 
    }


    public static function consulterEtudiants() {
        $titre = "Consultation des Étudiants";
        $tabAff = Etudiant::lireObjets(); 
        $cle = "NumEtudiant";
        $cible = "controleurEnseignant"; 
        $action = "consulterEtudiant";       
        
        include("vue/header.php");
        include("vue/nav.php");
        include("vue/lesObjets.php"); 
        include("vue/footer.php");
    }

    public static function consulterEtudiant() {
        $titre = "Dossier Étudiant";

        $id = null;
        if (isset($_GET["NumEtudiant"])) {
            $id = $_GET["NumEtudiant"];
        } elseif (isset($_POST["NumEtudiant"])) {
            $id = $_POST["NumEtudiant"];
        }

        if (!$id) {
            echo "Erreur : Aucun étudiant sélectionné.";
            return;
        }

        $etudiant = Etudiant::getBy("NumEtudiant", $id);

        include("vue/header.php");
        include("vue/nav.php");

        if ($etudiant) {
            $lienRetour = "routeur.php?controleur=controleurEnseignant&action=accueil";
            include("vue/enseignant/detailEtudiant.php"); 
        } else {
            echo "<p>Étudiant introuvable.</p>";
        }

        include("vue/footer.php"); 
    }
}
?>