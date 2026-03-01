
<?php
echo "<h2>$titre</h2>";
?>
    <form action="routeur.php?controleur=controleurResponsableFiliere&action=enregistrerSondage" method="post">
      <div>
        <label for="titre">Titre</label>
        <input type="text" name="titre" placeholder="votre titre">
      </div>
      <div>
        <label for="description">Description</label>
        <input type="text" name="description" placeholder="votre description">
      </div>
      <div>
        <label for="type">Type</label>
        <select  name="type">
          <option value="unique">Choix unique</option>
          <option value="multiple">Choix multiple</option>
        </select>
      </div>
      <button type="submit">envoyer</button>
    </form>
  </body>
</html>
