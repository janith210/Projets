<?php

session_start();
session_destroy(); // Supprime les variables de session
//Redirige vers une page sans droit
header("Location: lireEtudiant.php");

?>