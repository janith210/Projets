<?php
// enseignant.php
class enseignant
{
    private $conn;

    public function __construct($db)
    {
        $this->conn = $db;
    }

    // Lister tous les enseignants
    public function getAll()
    {
        $query = "SELECT * FROM AG_Enseignant";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    // Lire un étudiant par son id
    public function getOne($id)
    {
        $query = "SELECT * FROM AG_Enseignant WHERE NumEnseignant = ?";
        $stmt = $this->conn->prepare($query);
        $stmt->execute([$id]);
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    // Créer un enseignant
    public function create($data): bool
    {
        try {
            $query = "INSERT INTO AG_Enseignant (
                
            )
            VALUES (
            )";

            $stmt = $this->conn->prepare($query);

            return $stmt->execute([
                
            ]);
        } catch (PDOException $e) {
            error_log("Error Create: " . $e->getMessage());
            return false;
        }
    }

    // Mettre à jour un enseignant
    // Simplification fait grâce à un exemple demandé par gémini
    public function update($id, $data): mixed
    {
        try {
            $fields = [];
            $params = ['id' => $id];

            // Table de correspondance : Colonne SQL => Clé dans le JSON $data
            $map = [
                'NomEtudiant'                     => 'NomEtudiant',
                'PrenomEtudiant'                  => 'PrenomEtudiant',
                'DateNaissanceEtudiant'           => 'DateNaissanceEtudiant',
                'AdresseEtudiant'                 => 'AdresseEtudiant',
                'TelephoneEtudiant'               => 'TelephoneEtudiant',
                'GenreEtudiant'                   => 'GenreEtudiant',
                'EMailEtudiant'                   => 'EMailEtudiant',
                'TypeBacEtudiant'                 => 'TypeBacEtudiant',
                'ParcoursEtudiant'                => 'ParcoursEtudiant',
                'OptionAnglaisEtudiant'           => 'OptionAnglaisEtudiant',
                'PeriodeRedoublementEtudiant'     => 'PeriodeRedoublementEtudiant',
                'NumUtilisateur'                  => 'NumUtilisateur',
                'NumEnseignant'                   => 'NumEnseignant',
                'NumEnseignantResponsable'        => 'NumEnseignantResponsable',
                'NumEnseignantResponsableFiliere' => 'NumEnseignantResponsableFiliere',
                'NumCovoiturage'                  => 'NumCovoiturage',
                'NumPromotion'                    => 'NumPromotion',
                'NumGroupe'                       => 'NumGroupe'
            ];

            // On construit dynamiquement la requête selon les données reçues
            foreach ($map as $column => $key) {
                if (isset($data[$key])) {
                    $fields[] = "$column = :$key";
                    $params[$key] = $data[$key];
                }
            }

            if (empty($fields)) return false;

            $query = "UPDATE AG_Enseignant SET " . implode(', ', $fields) . " WHERE NumEnseignant = :id";
            
            $stmt = $this->conn->prepare($query);
            $stmt->execute($params);

            return $stmt->rowCount() >= 0; // Retourne true si la requête a été exécutée

        } catch(PDOException $e) {
            error_log("Error Update: " . $e->getMessage());
            return false;
        }
    }

    // Supprimer un étudiant
    public function delete($id): bool
    {
        try {
            $query = "DELETE FROM AG_Enseignant WHERE NumEnseignant = ?";
            $stmt = $this->conn->prepare($query);
            return $stmt->execute([$id]);
        } catch(PDOException $e) {
            error_log("Error Delete: " . $e->getMessage());
            return false;
        }
    }
}
?>