<h2>Explorateur de fichiers</h2>

<p>Chemin actuel : <?php echo $dossierActuel; ?></p>

<?php 
if ($dossierActuel != ".") { 
    $parent = dirname($dossierActuel);
    echo '<p><a href="routeur.php?controleur=controleurResponsableFormation&action=explorer&dir=' . $parent . '"><button>Remonter d un niveau</button></a></p>';
} 

echo "<h3>Dossiers</h3>";
echo "<ul>";
    
    if (empty($lesDossiers)) echo "<li>Aucun sous-dossier</li>";
    
    foreach ($lesDossiers as $dossier) { 
        $lien = "routeur.php?controleur=controleurResponsableFormation&action=explorer&dir=" . $dossierActuel . '/' . $dossier;

        echo "<li>";
        echo '<a href="'.$lien.'">'.$dossier.'</a>';
        echo "</li>";
    } 
echo "</ul>";

echo "<h3>Fichiers</h3>";
echo "<ul>";
    if (empty($lesFichiers)){
        echo "<li>Aucun fichier</li>";
    } 

    foreach ($lesFichiers as $fichier) { 
        $cheminComplet = $dossierActuel . '/' . $fichier;
        $lienModif = "routeur.php?controleur=controleurResponsableFormation&action=afficherFormulaire&file=" . $cheminComplet;
        echo '<li>';
            echo $fichier; 
            echo '<a href="'.$lienModif.'">[Modifier]</a>';
        echo '</li>';
    }
echo '</ul>';

echo "<br>";
echo '<a href="routeur.php?controleur=controleurEnseignant&action=Accueil"><button>Retour à l accueil</button></a>';
?>