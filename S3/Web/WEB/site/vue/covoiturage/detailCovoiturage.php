<?php
echo "<h2>Details </h2>";
foreach($LesEtudiants as $etudiant){ echo "<ul>";
echo "<li>Nom de l'étudiant : ".$etudiant->get("NomEtudiant")."</li>";
echo "<li>Prenom de l'étudiant : ".$etudiant->get("PrenomEtudiant")."</li>";
echo "</ul>"; }
?>
<div>
    <form method="POST" action="routeur.php?controleur=controleurCovoiturage&action=Rejoindre">
        <input type="hidden" name="NumCovoiturage" value="<?php echo $covoiturage->get('NumCovoiturage'); ?>">
        <button type="submit">Rejoindre le groupe</button>
    </form>
</div>
<?php
echo "<a href=routeur.php?controleur=controleurEtudiant&action=Accueil><button>Retour</button></a>";
?>
