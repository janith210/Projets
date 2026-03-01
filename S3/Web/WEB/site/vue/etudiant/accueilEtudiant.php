<?php
echo "<h2>Bienvenue dans votre espace d'information</h2>";
echo "<h3>".$_SESSION['username']."</h3>";
?>
<div class="table-wrapper">
    <table class="schedule-table">
        <thead>
            <tr>
                <th>Jour</th>
                <th>Horaire</th>
                <th>Matière</th>
                <th>Salle</th>
                <th>Groupe</th>
                <th>Statut</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><strong>Lundi</strong></td>
                <td>08:30 - 10:30</td>
                <td>Algorithmique Avancée</td>
                <td>Amphi B</td>
                <td>INFO-S3</td>
                <td><span class="badge badge-ok">Maintenu</span></td>
            </tr>
            <tr>
                <td><strong>Lundi</strong></td>
                <td>14:00 - 16:00</td>
                <td>Base de Données (SQL)</td>
                <td>Salle 204</td>
                <td>TD-2</td>
                <td><span class="badge badge-ok">Maintenu</span></td>
            </tr>
            <tr>
                <td><strong>Mardi</strong></td>
                <td>09:00 - 12:00</td>
                <td>Développement Web (PHP)</td>
                <td>Salle Machine 3</td>
                <td>TP-A</td>
                <td><span class="badge badge-warn">Déplacé</span></td>
            </tr>
            <tr>
                <td><strong>Mercredi</strong></td>
                <td>10:00 - 12:00</td>
                <td>Base de données</td>
                <td>Salle I112</td>
                <td>-</td>
                <td><span class="badge badge-ok">Maintenu</span></td>
            </tr>
            <tr>
                <td><strong>Jeudi</strong></td>
                <td>08:30 - 10:30</td>
                <td>Mathématiques</td>
                <td>I116</td>
                <td>INFO-S3</td>
                <td><span class="badge badge-danger">Annulé</span></td>
            </tr>
            <tr>
                <td><strong>Vendredi</strong></td>
                <td>13:30 - 17:30</td>
                <td>Projet</td>
                <td>Salle 102</td>
                <td>Groupe 4</td>
                <td><span class="badge badge-info">Exam</span></td>
            </tr>
        </tbody>
    </table>