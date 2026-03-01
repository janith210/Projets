<?php

require_once("modele/utilisateur.php");
require_once("modele/etudiant.php");
require_once("modele/enseignant.php");
class controleurUtilisateur{
    public static function afficherFormulaire() {
        $titre = "Se connecter";
        include("vue/header.php");
        include("vue/authentificationFormulaire.php");
    }



    public static function connecter() {
        if (isset($_POST["login"]) && isset($_POST["mdp"])) {
            $login = $_POST["login"];
            $mdp = $_POST["mdp"];
            $utilisateur = Utilisateur::CheckMDP($login, $mdp); 

            if ($utilisateur) {
                $_SESSION['username'] = $login;
                $numUtilisateur = $utilisateur->get("NumUtilisateur");

            
                $estEtudiant = Etudiant::getBy("NumUtilisateur", $numUtilisateur);
                $estEnseignant = Enseignant::getBy("NumUtilisateur", $numUtilisateur);

                if ($estEtudiant) {
                    $_SESSION['role'] = "etudiant";
                    header("Location: routeur.php?controleur=controleurEtudiant&action=Accueil");
                } 
                else{
                    $_SESSION['role'] = "enseignant";
                    $_SESSION['NumEnseignant']=$estEnseignant->get("NumEnseignant");
                    $numEns = $_SESSION['NumEnseignant'];
                    $_SESSION['responsabilites'] = Enseignant::getDetailsResponsabilite($numEns);
                    header("Location: routeur.php?controleur=controleurEnseignant&action=Accueil");
                } 
            } else {
                echo "erreur";
            }
        } else {
            self::afficherFormulaire();
        }
    }

    public static function deconnecter() {
        session_destroy();
        header("Location: routeur.php?controleur=controleurUtilisateur&action=afficherFormulaire");
        exit();
    }
  }
 
  
?>

