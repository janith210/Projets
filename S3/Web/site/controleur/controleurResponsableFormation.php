<?php
require_once("modele/enseignant.php");
require_once("modele/utilisateur.php");
require_once("modele/etudiant.php"); 
require_once("modele/groupe.php"); 

class ControleurResponsableFormation {
    const racine = "."; 

    public static function explorer() {

        $titre = "Explorateur du Site";
        $dossierActuel = isset($_GET['dir']) ? $_GET['dir'] : self::racine;
        if (strpos($dossierActuel, '..') !== false) {
            $dossierActuel = self::racine; 
        }

        if (is_dir($dossierActuel)) {
            $toutLeContenu = scandir($dossierActuel);
            
            $lesDossiers = [];
            $lesFichiers = [];

            foreach ($toutLeContenu as $item) {

                if ($item == '.' || $item == '..') continue;

                $cheminComplet = $dossierActuel . '/' . $item;

                if (is_dir($cheminComplet)) {
                    $lesDossiers[] = $item;
                } else {
                    $lesFichiers[] = $item;
                }
            }
        } else {
            $dossierActuel = self::racine;
            $lesDossiers = [];
            $lesFichiers = [];
        }

        include("vue/header.php");
        include("vue/nav.php");
        include("vue/formation/explorerFichiers.php");
        include("vue/footer.php");
    }

    public static function afficherFormulaire() {
        $cheminFichier = $_GET['file'];
        $titre = "Modifier : " . basename($cheminFichier);
        
        include("vue/header.php");
        include("vue/nav.php");
        include("vue/formation/formulaireFichier.php");
        include("vue/footer.php");
    }


    public static function traiter() {
        $cheminCible = $_POST['cheminCible'];
        
        if (isset($_FILES['nouveauFichier']) && $_FILES['nouveauFichier']['error'] == 0) {
            
            if (move_uploaded_file($_FILES['nouveauFichier']['tmp_name'], $cheminCible)) {
                $dossierParent = dirname($cheminCible);
                header("Location: routeur.php?controleur=controleurResponsableFormation&action=explorer&dir=" . $dossierParent);
                exit();
            }
        }
        echo "Erreur lors du transfert.";
    }

    public static function consulterEnseignants() {
        $titre = "Consultation des Étudiants";
        $tabAff = Enseignant::lireObjets(); 
        $cle = "NumEnseignant";
        $cible = "controleurResponsableFormation"; 
        $action = "consulterEnseignant";       
        
        include("vue/header.php");
        include("vue/nav.php");
        include("vue/formation/listeEnseignants.php"); 
        include("vue/footer.php");
    }

    public static function gererEnseignant() {
        $titre = "Dossier Enseignant";
        $num = $_GET["NumEnseignant"];

        $enseignant = Enseignant::getBy("NumEnseignant", $num);

        $sonRole=Enseignant::getDetailsResponsabilite($num);

        include("vue/header.php");
        include("vue/nav.php");

        if ($enseignant) {
            $lienRetour = "routeur.php?controleur=controleurEnseignant&action=accueil";
            include("vue/formation/detailDroitsEnseignant.php"); 
        } else {
            echo "<p>Enseignant introuvable.</p>";
        }

        include("vue/footer.php"); 
    }

    public static function actionDroit() {
        $action = $_GET['mode'];
        $num = $_POST['NumEnseignant'];
        $type   = $_POST['typeDroit'];
        $valeur=isset($_POST['valeurDroit']) ? $_POST['valeurDroit'] : "";

        if ($action == 'ajout') {
            Enseignant::ajouterResponsabilite($num, $type, $valeur);
        } 
        elseif ($action == 'suppr') {
            Enseignant::supprimerResponsabilite($num, $type, $valeur);
        }
        header("Location: routeur.php?controleur=controleurResponsableFormation&action=gererEnseignant&NumEnseignant=$num");
    }
}
?>