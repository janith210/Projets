<?php
    echo "<h2>$titre</h2>";
?>
<form method="POST" action="routeur.php?controleur=controleurSondage&action=Envoyer">
    <label for="reponse">Reponse :</label>
    <textarea id="ValeurReponseSondage" name="ValeurReponseSondage" required></textarea>
    <input type="hidden" name="NumSondage" value="<?php echo $sondage->get('NumSondage'); ?>">
    <button type="submit">Envoyer</button>
</form>
<?php
echo "<a href=routeur.php?controleur=controleurEtudiant&action=Accueil><button>Retour</button></a>";
?>