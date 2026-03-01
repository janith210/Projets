<?php
try {
    // On s'adapte à MySQL (XAMPP)
    $host = 'localhost';
    $dbname = 'bourse_db';
    $user = 'root';
    $pass = '';
    $conn = new PDO("mysql:host=localhost;dbname=bourse_db", "root", "");
    
    // Ton reste de code (prepare, execute, fetchAll) reste le même !
    $requete = "SELECT * FROM historique"; 
    $stmt = $conn->prepare($requete);
    $stmt->execute();
    $data = $stmt->fetchAll(PDO::FETCH_ASSOC);

} catch (PDOException $e) {
    die("Erreur MySQL : " . $e->getMessage());
}
?>
<link rel="stylesheet" href="style.css">
<table>
  <caption>
    Historique de Recherche
  </caption>
  <thead>
    <tr>
      <th scope="col">Nom</th>
      <th scope="col">Prix</th>
      <th scope="col">Quantite</th>
      <th scope="col">Date de Recherche</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($data as $ligne){ ?>
    <tr>
      <th scope="row"><?php echo $ligne['ticker']; ?></th>
      <td><?php echo $ligne['prix']; ?></td>
      <td><?php echo $ligne['quantite_simulee']; ?></td>
      <td><?php echo $ligne['date_recherche']; ?></td>
    </tr><?php } ?>
  </tbody>
</table>
<a href="https://fr.wikipedia.org/wiki/Liste_des_compagnies_du_S%26P_500?utm_source=chatgpt.com">Liste des actions</a>
