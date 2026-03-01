<footer>
<?php 
     if(isset($_SESSION['username'])){
          echo "<a href=routeur.php?controleur=controleurUtilisateur&action=deconnecter><button>Se deconnecter</button></a>";
     }
?>
</footer>
</body>
</html>
