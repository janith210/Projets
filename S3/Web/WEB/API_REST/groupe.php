<?php
// groupe.php
class groupe
{
    private $conn;

    public function __construct($db)
    {
        $this->conn = $db;
    }

    // Lister tous les groupes
    public function getAll()
    {
        $query = "SELECT * FROM AG_Groupe";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    // Lire un groupe par son id
    public function getOne($id)
    {
        $query = "SELECT * FROM AG_Groupe WHERE NumGroupe = ?";
        $stmt = $this->conn->prepare($query);
        $stmt->execute([$id]);
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    // Créer un groupe
    public function create($data): bool
    {
        try {
            $query = "INSERT INTO AG_Groupe (TypeGroupe, CapaciteGroupe, NumEnseignantResponsableAnnee, NumEnseignantResponsable)
            VALUES (:TypeGroupe, :CapaciteGroupe, :NumEnseignantResponsableAnnee, :NumEnseignantResponsable)";

            $stmt = $this->conn->prepare($query);

            $success = $stmt->execute([
                'TypeGroupe' => $data['TypeGroupe'],
                'CapaciteGroupe' => $data['CapaciteGroupe'],
                'NumEnseignantResponsableAnnee' => $data['NumEnseignantResponsableAnnee'],
                'NumEnseignantResponsable' => $data['NumEnseignantResponsable']
            ]);
            return $success;
        } catch (PDOException $e) {
            error_log("Error Create: " . $e->getMessage());
            return false;
        }
    }

    // Mettre à jour un groupe
    public function update($id, $data): mixed
    {
        try {
            $fields = [];
            $params = ['id' => $id];

            // Table de correspondance : Colonne SQL => Clé dans le JSON $data
            $map = [
                'TypeGroupe'                      => 'TypeGroupe',
                'CapaciteGroupe'                  => 'CapaciteGroupe',
                'NumEnseignantResponsableAnnee'   => 'NumEnseignantResponsableAnnee',
                'NumEnseignantResponsable'        => 'NumEnseignantResponsable'
            ];

            $map2 = [
                'NumEnseignantResponsableAnnee'   => 'NumEnseignantResponsableAnnee'
            ];

            // On construit dynamiquement la requête selon les données reçues
            foreach ($map as $column => $key) {
                // Vérifie si la clé est présente dans le JSON envoyé, même si elle vaut null
                if (array_key_exists($key, $data)) {

                    $valeur = $data[$key];

                    if (array_key_exists($key, $map2) && $valeur === 0) {
                        $valeur = null;
                    }

                    $fields[] = "$column = :$key";
                    $params[$key] = $valeur;
                }
            }

            if (empty($fields)) return false;

            $query = "UPDATE AG_Groupe SET " . implode(', ', $fields) . " WHERE NumGroupe = :id";
            
            $stmt = $this->conn->prepare($query);
            $stmt->execute($params);

            return $stmt->rowCount() >= 0; // Retourne true si la requête a été exécutée

        } catch(PDOException $e) {
            error_log("Error Update: " . $e->getMessage());
            return false;
        }
    }

    // Supprimer un groupe
    public function delete($id): bool
    {
        try {
            $query = "DELETE FROM AG_Groupe WHERE NumGroupe = ?";
            $stmt = $this->conn->prepare($query);
            return $stmt->execute([$id]);
        } catch(PDOException $e) {
            error_log("Error Delete: " . $e->getMessage());
            return false;
        }
    }
}
?> 