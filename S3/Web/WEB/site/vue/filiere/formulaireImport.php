<?php
echo "<h2>Import fichier csv </h2>";
echo "<h3> Format attendu</h3>";
echo "<p style='text-align: center'>1;Mathématique;14.5</p>";
?>
<form action="routeur.php?controleur=controleurResponsableFiliere&action=traiterImportCSV" method="post" enctype="multipart/form-data">
    <label style="font-weight: bold;">Choisir le fichier .csv :</label><br><br>
    <input type="file" name="fichierNotes" accept=".csv" required>
    <br>
    <br>
<button type="submit">Lancer l'importation</button></form>
