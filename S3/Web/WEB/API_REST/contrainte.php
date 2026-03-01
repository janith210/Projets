<?php
// contrainte.php
class contrainte
{
    private $conn;

    public function __construct($db)
    {
        $this->conn = $db;
    }

    // Lister tous les contraintes
    public function getAll()
    {
        $query = "SELECT * FROM AG_Contrainte";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    // Lire une contrainte par son id
    public function getOne($id)
    {
        $query = "SELECT * FROM AG_Contrainte WHERE NumContrainte = ?";
        $stmt = $this->conn->prepare($query);
        $stmt->execute([$id]);
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    // Créer une contrainte
    public function create($data): bool
    {
        try {
            $query = "INSERT INTO AG_Contrainte (NomContrainte, TypeContrainte, ValeurContrainte, NumEnseignant)
            VALUES (:NomContrainte, :TypeContrainte, :ValeurContrainte, :NumEnseignant)";

            $stmt = $this->conn->prepare($query);

            $success = $stmt->execute([
                'NomContrainte' => $data['NomContrainte'],
                'TypeContrainte' => $data['TypeContrainte'],
                'ValeurContrainte' => $data['ValeurContrainte'],
                'NumEnseignant' => $data['NumEnseignant']
            ]);
            return $success;
        } catch (PDOException $e) {
            error_log("Error Create: " . $e->getMessage());
            return false;
        }
    }

    // Mettre à jour une contrainte
    public function update($id, $data): mixed
    {
        try {
            $fields = [];
            $params = ['id' => $id];

            // Table de correspondance : Colonne SQL => Clé dans le JSON $data
            $map = [
                'NomContrainte'         => 'NomContrainte',
                'TypeContrainte'        => 'TypeContrainte',
                'ValeurContrainte'      => 'ValeurContrainte',
                'NumEnseignant'         => 'NumEnseignant'
            ];

            // On construit dynamiquement la requête selon les données reçues
            foreach ($map as $column => $key) {
                if (isset($data[$key])) {
                    $fields[] = "$column = :$key";
                    $params[$key] = $data[$key];
                }
            }

            if (empty($fields)) return false;

            $query = "UPDATE AG_Contrainte SET " . implode(', ', $fields) . " WHERE NumContrainte = :id";
            
            $stmt = $this->conn->prepare($query);
            $stmt->execute($params);

            return ["status" => true, "rows" => $stmt->rowCount()];

        } catch(PDOException $e) {
            return ["status" => false, "error" => $e->getMessage()];
        }
    }

    // Supprimer une contrainte
    public function delete($id): bool
    {
        try {
            $query = "DELETE FROM AG_Contrainte WHERE NumContrainte = ?";
            $stmt = $this->conn->prepare($query);
            return $stmt->execute([$id]);
        } catch(PDOException $e) {
            error_log("Error Delete: " . $e->getMessage());
            return false;
        }
    }
}
?>