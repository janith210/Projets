<?php
// etudiant.php
class etudiant
{
    private $conn;

    public function __construct($db)
    {
        $this->conn = $db;
    }

    // Lister tous les etudiants
    public function getAll()
    {
        $query = "SELECT * FROM AG_Etudiant";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    // Lire un étudiant par son id
    public function getOne($id)
    {
        $query = "SELECT * FROM AG_Etudiant WHERE NumEtudiant = ?";
        $stmt = $this->conn->prepare($query);
        $stmt->execute([$id]);
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    // Créer un étudiant
    public function create($data): bool
    {
        try {
            $query = "INSERT INTO AG_Etudiant (
                NomEtudiant, PrenomEtudiant, DateNaissanceEtudiant, AdresseEtudiant,
                TelephoneEtudiant, GenreEtudiant, EmailEtudiant, TypeBacEtudiant, 
                ParcoursEtudiant, OptionAnglaisEtudiant, PeriodeRedoublementEtudiant, 
                NumUtilisateur, NumEnseignant, NumEnseignantResponsable,
                NumEnseignantResponsableFiliere, NumCovoiturage, NumPromotion, NumGroupe
            )
            VALUES (
                :NomEtudiant, :PrenomEtudiant, :DateNaissanceEtudiant, :AdresseEtudiant,
                :TelephoneEtudiant, :GenreEtudiant, :EmailEtudiant, :TypeBacEtudiant, 
                :ParcoursEtudiant, :OptionAnglaisEtudiant, :PeriodeRedoublementEtudiant, 
                :NumUtilisateur, :NumEnseignant, :NumEnseignantResponsable,
                :NumEnseignantResponsableFiliere, :NumCovoiturage, :NumPromotion, :NumGroupe
            )";

            $stmt = $this->conn->prepare($query);

            $success = $stmt->execute([
                'NomEtudiant'          => $data['NomEtudiant'],
                'PrenomEtudiant'       => $data['PrenomEtudiant'],
                'DateNaissanceEtudiant' => $data['DateNaissanceEtudiant'],
                'AdresseEtudiant'      => $data['AdresseEtudiant'],
                'TelephoneEtudiant'    => $data['TelephoneEtudiant'],
                'GenreEtudiant'        => $data['GenreEtudiant'],
                'EmailEtudiant'        => $data['EmailEtudiant'],
                'TypeBacEtudiant'      => $data['TypeBacEtudiant'],
                'ParcoursEtudiant'     => $data['ParcoursEtudiant'] ?? null,
                'OptionAnglaisEtudiant'   => $data['OptionAnglaisEtudiant'],
                'PeriodeRedoublementEtudiant' => $data['PeriodeRedoublementEtudiant'] ?? null,
                'NumUtilisateur'         => $data['NumUtilisateur'],
                'NumEnseignant'          => $data['NumEnseignant'] ?? null,
                'NumEnseignantResponsable'       => $data['NumEnseignantResponsable'] ?? null,
                'NumEnseignantResponsableFiliere'    => $data['NumEnseignantResponsableFiliere'] ?? null,
                'NumCovoiturage'       => $data['NumCovoiturage'] ?? null,
                'NumPromotion'        => $data['NumPromotion'] ?? null,
                'NumGroupe'       => $data['NumGroupe'] ?? null
            ]);

            return $success;

        } catch (PDOException $e) {
            error_log("Error Delete: " . $e->getMessage());
            return false;
        }
    }

    // Mettre à jour un étudiant
    // Simplification fait grâce à un exemple demandé par gémini
    public function update($id, $data)
    {
        try {
            $fields = [];
            $params = ['id' => $id];

            $map = [
                'NomEtudiant' => 'NomEtudiant',
                'PrenomEtudiant' => 'PrenomEtudiant',
                'DateNaissanceEtudiant' => 'DateNaissanceEtudiant',
                'AdresseEtudiant' => 'AdresseEtudiant',
                'TelephoneEtudiant' => 'TelephoneEtudiant',
                'GenreEtudiant' => 'GenreEtudiant',
                'EmailEtudiant' => 'EmailEtudiant',
                'TypeBacEtudiant' => 'TypeBacEtudiant',
                'ParcoursEtudiant' => 'ParcoursEtudiant',
                'OptionAnglaisEtudiant' => 'OptionAnglaisEtudiant',
                'PeriodeRedoublementEtudiant' => 'PeriodeRedoublementEtudiant',
                'NumUtilisateur' => 'NumUtilisateur',
                'NumEnseignant' => 'NumEnseignant',
                'NumEnseignantResponsable' => 'NumEnseignantResponsable',
                'NumEnseignantResponsableFiliere' => 'NumEnseignantResponsableFiliere',
                'NumCovoiturage' => 'NumCovoiturage',
                'NumPromotion' => 'NumPromotion',
                'NumGroupe' => 'NumGroupe'
            ];

            $map2 = [
                'NumEnseignant' => 'NumEnseignant',
                'NumEnseignantResponsable' => 'NumEnseignantResponsable',
                'NumEnseignantResponsableFiliere' => 'NumEnseignantResponsableFiliere',
                'NumCovoiturage' => 'NumCovoiturage',
                'NumPromotion' => 'NumPromotion',
                'NumGroupe' => 'NumGroupe'
            ];

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

            if (empty($fields)) {
                return ["status" => false, "error" => "Aucune donnée à mettre à jour"];
            }

            $query = "UPDATE AG_Etudiant SET " . implode(', ', $fields) . " WHERE NumEtudiant = :id";
            
            $stmt = $this->conn->prepare($query);
            $stmt->execute($params);

            // rowCount() >= 0 est toujours vrai si la requête n'a pas crashé.
            return ["status" => true, "rows" => $stmt->rowCount()];

        } catch(PDOException $e) {
            return ["status" => false, "error" => $e->getMessage()];
        }
    }

    // Supprimer un étudiant
    public function delete($id): bool
    {
        try {
            $query = "DELETE FROM AG_Etudiant WHERE NumEtudiant = ?";
            $stmt = $this->conn->prepare($query);
            return $stmt->execute([$id]);
        } catch(PDOException $e) {
            error_log("Error Delete: " . $e->getMessage());
            return false;
        }
    }
}
?>