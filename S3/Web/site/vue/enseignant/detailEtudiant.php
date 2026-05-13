<?php

echo "<h2>Details de l'étudiant </h2>";

echo "<p>Nom : ".$etudiant->get("NomEtudiant")."</p>";
echo "<p>Prénom : ".$etudiant->get("PrenomEtudiant")."</p>";
echo "<p>Groupe : " .$etudiant->get("NumGroupe")."</p>";
echo "<p>Parcours : " .$etudiant->get("ParcoursEtudiant")."</p>";

echo "<a href=routeur.php?controleur=controleurEnseignant&action=Accueil><button>Retour</button></a>";
?>
