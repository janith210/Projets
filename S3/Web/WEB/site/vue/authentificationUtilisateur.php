<?php
      require_once("utilisateur.php");
      session_start();
      $utilisateur=new Utilisateur($_POST["LoginUtilisateur"],$_POST["MotDePasseUtilisateur"],NULL);
      try {
        if(Utilisateur::CheckMDP($_POST["LoginUtilisateur"],$_POST["MotDePasseUtilisateur"])){
          $_SESSION['username']=$_POST["LoginUtilisateur"];
          header("Location: lireEtudiant.php");
        }
        else{
          header("Location: formulaireAuthentification.php");
        }
    }catch(PDOException $e) {
      header("Location: formulaireAuthentification.php");
    }
      

?>