  <form action="routeur.php?controleur=controleurUtilisateur&action=connecter" method="POST">
    <div class="form-group">
      <label for="login">login</label>
      <input type="text" name="login" placeholder="votre login">
    </div>
    <div class="form-group">
      <label for="mdp">mot de passe</label>
      <input type="password" name="mdp">
    </div>
    <button type="submit">s'authentifier</button>
  </form>
