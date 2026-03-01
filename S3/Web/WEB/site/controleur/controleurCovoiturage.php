<?php

require_once("modele/covoiturage.php");
require_once("modele/etudiant.php");
require_once("modele/utilisateur.php");
class ControleurCovoiturage{
    public static function lireCovoiturages(){
      $titre="Les covoiturages";
      $cle="NumCovoiturage";
      $cible = "controleurCovoiturage";
      $action = "lireCovoiturage";
      $tabAff=Covoiturage::lireObjets();
      include("vue/header.php");
      include("vue/nav.php");
      include("vue/covoiturage/listeCovoiturage.php");
      include("vue/footer.php"); 
    }


    public static function lireCovoiturage(){

      $titre="Les données du covoiturage";
      $num=$_GET["NumCovoiturage"];
      $covoiturage=Covoiturage::getBy("NumCovoiturage",$num);
      $LesEtudiants=array();
  
      if($covoiturage){
        $LesEtudiants=Etudiant::getAllBy("Numcovoiturage",$num);
      }

      if($covoiturage){
        include("vue/header.php");
        include("vue/covoiturage/detailCovoiturage.php");
        include("vue/footer.php"); 
      }
      else{
        echo "erreur";
      }
      
    }

    public static function Rejoindre(){
      if(isset($_POST["NumCovoiturage"])){
        $numC=$_POST["NumCovoiturage"];
      }
      elseif(isset($_GET["NumCovoiturage"])){
        $numC=$_GET["NumCovoiturage"];
      }
      else{
        echo "Erreur : Aucun covoiturage a été trouver.";
      }

      if (!isset($_SESSION['username'])) {
        echo "Erreur : Vous n'êtes pas connecté.";
        return;
      }
      $login=$_SESSION['username'];
      
      $utilisateur=Utilisateur::getBy("LoginUtilisateur",$login);

      if($utilisateur){
        $num=$utilisateur->get("NumUtilisateur");
        
        $etudiant=Etudiant::getBy("NumUtilisateur",$num);
        if($etudiant){
          $numE=$etudiant->get("NumEtudiant");
          Etudiant::rejoindreCovoiturage($numE,$numC);
          header("Location: routeur.php?controleur=controleurCovoiturage&action=lireCovoiturage&NumCovoiturage=$numC");
        }
      }
      else{
        echo "erreur";
      }
    }

/*
    public static function lireEtudiant(){
      $titre="L'etudiant";
      $l=$_GET["Num"];
      $o=etudiant::getUtilisateurBylogin(l: $l);
      include("vue/debut.php");
      include("vue/menu.html");
      if(!$o){
        $message="<p>L'utilisateur avec login $l n'existe pas dans la base !</p>";
        include("vue/erreur.php");
      }
      else{
        include("vue/unObjet.php");
      }
      include("vue/fin.html"); 
    }
*/ 
  }
 
  
?>

