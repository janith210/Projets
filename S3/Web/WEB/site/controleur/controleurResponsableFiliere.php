<?php
require_once("modele/enseignant.php");
require_once("modele/utilisateur.php");
require_once("modele/etudiant.php"); 
require_once("modele/groupe.php"); 
require_once("modele/sondage.php"); 
require_once("modele/note.php");
class ControleurResponsableFiliere{

    public static function consulterSondages() {
        $titre = "Consultation des sondages";
        $tabAff = Sondage::lireObjets(); 
        $cle = "NumSondage";
        $cible = "controleurResponsableFiliere"; 
        $action = "gererSondage";       
        
        include("vue/header.php");
        include("vue/nav.php");
        include("vue/filiere/consulterSondage.php"); 
        include("vue/footer.php");
    }

    public static function gererSondage() {
        $titre = "Dossier Sondage";
        $num = $_GET["NumSondage"];

        $sondage = Sondage::getBy("NumSondage", $num);

        include("vue/header.php");
        include("vue/nav.php");

        if ($sondage) {
            $lienRetour = "routeur.php?controleur=controleurEnseignant&action=accueil";
            include("vue/filiere/detailSondage.php"); 
        } else {
            echo "<p>Sondage introuvable.</p>";
        }

        include("vue/footer.php"); 
    }

    public static function afficherFormulaire(){
        $titre = "Création d'un sondage";     
        
        include("vue/header.php");
        include("vue/nav.php");
        include("vue/filiere/formulaireSondage.php"); 
        include("vue/footer.php");
    }

    public static function enregistrerSondage(){
        $titre = $_POST['titre'];
        $description=$_POST['description'];
        $type=$_POST['type'];
        $numE=$_SESSION['NumEnseignant'];
        
        Sondage::ajouterSondage($titre,$description,$type,$numE);
        header("Location: routeur.php?controleur=controleurResponsableFiliere&action=consulterSondages");
    }

    public static function supprimerSondage(){
        if(isset($_GET["NumSondage"])){
            $num = $_GET["NumSondage"];
            Sondage::supprimer($num);
            header("Location: routeur.php?controleur=controleurResponsableFiliere&action=consulterSondages");
        }
        else{
            echo "erreur";
        }
        
    }

    public static function listeEtudiants() {
        $titre = "Gérer les Notes";
        $cle = "NumEtudiant";
        $cible = "controleurResponsableFiliere"; 
        $action = "gererNotesEtudiant";  
        $tabAff = Etudiant::lireObjets();

        include("vue/header.php");
        include("vue/nav.php");
        include("vue/filiere/listeEtudiants.php"); 
        include("vue/footer.php");
    }

    public static function gererNotesEtudiant() {
            $num = $_GET['NumEtudiant'];
        
            $etudiant = Etudiant::getBy("NumEtudiant", $num);
            $lesNotes = Note::getNotesByEtudiant($num);
            $titre = "Notes de " . $etudiant->get('NomEtudiant'); 

            include("vue/header.php");
            include("vue/nav.php");
            include("vue/filiere/detailNotes.php"); 
            include("vue/footer.php");
    }

    public static function afficherFormulaireImport() {
        $titre = "Importer CSV";
        include("vue/header.php");
        include("vue/nav.php");
        include("vue/filiere/formulaireImport.php");
        include("vue/footer.php");
    }


    public static function traiterImportCSV() {
        if (isset($_FILES['fichierNotes']) && $_FILES['fichierNotes']['error'] == 0) {
            
            $tmpName = $_FILES['fichierNotes']['tmp_name'];
            
            if (($handle = fopen($tmpName, "r")) !== FALSE) {
                while (($data = fgetcsv($handle, 1000, ";")) !== FALSE) {

                    $numEtudiant = $data[0];
                    $matiere = $data[1];
                    
                    $noteVal = str_replace(',', '.', $data[2]); 

                    if (!empty($numEtudiant) && !empty($matiere) && is_numeric($noteVal)) {
                        Note::ajouterNote($noteVal, $matiere, $numEtudiant);
                    }
                }
                
                fclose($handle);
                
                header("Location: routeur.php?controleur=controleurResponsableFiliere&action=listeEtudiants");
            }
        } else {
            echo "Erreur lors du téléchargement du fichier.";
        }
    }
}