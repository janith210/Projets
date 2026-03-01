<?php
require_once("modele/enseignant.php");
require_once("modele/etudiant.php"); 
require_once("modele/groupe.php"); 

class ControleurResponsableAnnee {

    public static function AccueilGroupe() {
        $titre = "Gestion des groupes";
        
        $lesGroupes = Groupe::lireObjets();
        
        if (!$lesGroupes) {
            $lesGroupes = []; 
        }
        
        include("vue/header.php");
        include("vue/annee/constituerGroupe.php"); 
        include("vue/footer.php");
    }

    public static function genererRepartion() {
        
        $algo = $_POST['algo'] ?? $_GET['algo'] ?? 'parcours_bac'; 
        $numGroupeCible = $_POST['NumGroupeCible'] ?? null;

        if (!$numGroupeCible) {
            echo "<script>alert('Veuillez sélectionner un groupe.'); window.history.back();</script>";
            return;
        }

        Etudiant::viderGroupe($numGroupeCible);

        $groupeObj = Groupe::getBy("NumGroupe", $numGroupeCible); 
        $capaciteMax = $groupeObj->get('CapaciteGroupe'); 
        $placesLibres = $capaciteMax; 
        $lesEtudiants = [];

        switch ($algo) {
            case 'parcours_bac':
                $lesEtudiants = Etudiant::getTousLesEtudiants("ParcoursEtudiant, TypeBacEtudiant");
                break;
            case 'taille_fille': 
                $lesEtudiants = Etudiant::getTousLesEtudiants("GenreEtudiant");
                break;
            case 'covoiturage':
                $lesEtudiants = Etudiant::getTousLesEtudiants("NumCovoiturage DESC");
                break;
            case 'anglophone':
                $lesEtudiants = Etudiant::getTousLesEtudiants("OptionAnglaisEtudiant DESC");
                break;
            default:
                $lesEtudiants = Etudiant::getTousLesEtudiants();
                break;
        }

        $misesAJour = 0;
        $statsRepartion = [$numGroupeCible => 0];

        foreach ($lesEtudiants as $etudiant) {
            if ($misesAJour >= $capaciteMax) break; 

            $idEtudiant = $etudiant->get('NumEtudiant');
            $groupeActuel = $etudiant->get('NumGroupe');
            
            if ($groupeActuel == null) {
                
                $succes = Etudiant::affecterGroupe($idEtudiant, $numGroupeCible);
                
                if($succes) {
                    $misesAJour++;
                    $statsRepartion[$numGroupeCible]++;
                }
            }
        }
        $titre = "Résultat";
        include("vue/header.php");
        include("vue/annee/resultatGeneration.php"); 
        include("vue/footer.php");
    }
}
?>