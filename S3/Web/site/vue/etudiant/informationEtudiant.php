<?php
echo "<h3>Profit de l'étudiant</h3>";
echo "<p>Nom de l'étudiant : ".$etudiant->get("NomEtudiant")."</p>";
echo "<p>Prenom de l'étudiant : ".$etudiant->get("PrenomEtudiant")."</p>";
echo "<p>Email de l'étudiant : ".$etudiant->get("EmailEtudiant")."</p>";
echo "<p>Groupe de l'étudiant : ".$etudiant->get("NumGroupe")."</p>";
echo "<p>Parcours de l'étudiant : ".$etudiant->get("ParcoursEtudiant")."</p>";
echo "<a href=routeur.php?controleur=controleurEtudiant&action=Accueil><button>Retour</button></a>";
?>