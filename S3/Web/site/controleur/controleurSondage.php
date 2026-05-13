<?php

require_once("modele/sondage.php");
require_once("modele/etudiant.php");
require_once("modele/utilisateur.php");
require_once("modele/reponsesondage.php");
class controleurSondage{
    public static function lireSondages(){
      $titre="Les sondages";
      $cle="NumSondage";
      $cible = "controleurSondage";
      $action ="lireSondage";
      $tabAff=Sondage::lireObjets();
      include("vue/header.php");
      include("vue/nav.php");
      include("vue/sondage/listeSondage.php");
      include("vue/footer.php"); 
    }

    public static function lireSondage(){

      $titre="Les données du sondage";
      $num=$_GET["NumSondage"];
      $sondage=Sondage::getBy("NumSondage",$num);
      if($sondage){
        include("vue/header.php");
        include("vue/sondage/formulaireReponse.php");
        include("vue/footer.php"); 
      }
      else{
        echo "erreur";
      }
      
    }

    public static function Envoyer(){

      if (!isset($_SESSION['username'])) {
        echo "Erreur : Vous n'êtes pas connecté.";
        header("Location: routeur.php?controleur=controleurUtilisateur&action=afficherFormulaire");
      }

      if(isset($_POST["NumSondage"]) && isset($_POST["ValeurReponseSondage"])){
        $numS=$_POST["NumSondage"];
        $valeur=$_POST["ValeurReponseSondage"];
        $login=$_SESSION['username'];

        $utilisateur=Utilisateur::getBy("LoginUtilisateur",$login);
        if($utilisateur){
            $etudiant=Etudiant::getBy("NumUtilisateur",$utilisateur->get("NumUtilisateur"));
            if($etudiant){
                $numE=$etudiant->get("NumEtudiant");
                $succes=ReponseSondage::EnvoyerReponse($numS,$numE,$valeur);
                header("Location: routeur.php?controleur=controleurSondage&action=lireSondages");
            }
        }
          
        }
      else{
        echo "erreur";
      }
    }
}
?>

