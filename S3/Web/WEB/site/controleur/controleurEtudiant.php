<?php

require_once("modele/etudiant.php");
require_once("modele/utilisateur.php");
class ControleurEtudiant{
    public static function lireEtudiants(){
      $titre="Les etudiants";
      $cle="NumEtudiant";
      $cible = "controleurEtudiant";
      $action = "lireEtudiant";
      $tabAff=etudiant::lireObjets();
      include("vue/header.php");
      include("vue/nav.php");
      include("vue/lesObjets.php");
      include("vue/footer.php"); 
    }

    public static function Accueil(){
      if(!isset($_SESSION['username'])){
        self::afficherFormulaire();
        return;
      }
      $titre="Accueil de l'étudiant ".$_SESSION['username'];
      include("vue/header.php");
      include("vue/nav.php");
      include("vue/etudiant/accueilEtudiant.php");
      include("vue/footer.php"); 
    }

    public static function Information(){
      $login=$_SESSION['username'];
      $titre="Les données personnelles de ".$login;

      $utilisateur=Utilisateur::getBy("LoginUtilisateur",$login);
      $etudiant=false;
  
      if($utilisateur){
        $num=$utilisateur->get("NumUtilisateur");
        $etudiant=Etudiant::getBy("NumUtilisateur",$num);
      }

      if($etudiant){
        include("vue/header.php");
        include("vue/etudiant/informationEtudiant.php");
        include("vue/footer.php"); 
      }
      else{
        echo "erreur";
      }
      
    }

  }
 
  
?>

