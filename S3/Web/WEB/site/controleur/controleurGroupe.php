<?php
require_once("modele/enseignant.php");
require_once("modele/utilisateur.php");
require_once("modele/etudiant.php"); 
require_once("modele/groupe.php"); 
class ControleurGroupe {

    public static function lireGroupes() {
        $titre = "Consultation des groupes";
        $tabAff = Groupe::lireObjets(); 
        $cle = "NumGroupe";
        $cible = "controleurGroupe"; 
        $action = "lireGroupe";       
        
        include("vue/header.php");
        include("vue/nav.php");
        include("vue/lesObjets.php"); 
        include("vue/footer.php");
    }

    public static function lireGroupe(){

      $titre="Details du groupe ";
      $num=$_GET["NumGroupe"];
      $groupe=Groupe::getBy("NumGroupe",$num);
      $LesEtudiants=array();
  
      if($groupe){
        $LesEtudiants=Etudiant::getAllBy("NumGroupe",$num);
      }

      if($groupe){
        $lienRetour="routeur.php?controleur=controleurEnseignant&action=Accueil";
        include("vue/header.php");
        include("vue/groupe/detailGroupe.php");
        include("vue/footer.php"); 
      }
      else{
        echo "erreur";
      }
      
    }

}
?>