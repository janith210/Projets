<?php
// utilisateur.php
class utilisateur
{
    private $conn;

    public function __construct($db)
    {
        $this->conn = $db;
    }

    // Lister tous les utilisateurs
    public function getAll()
    {
        $query = "SELECT * FROM  AG_Utilisateur";


        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    // Lire un utilisateurs par son id
    public function getOne($id)
    {
        $query = "SELECT * FROM AG_Utilisateur WHERE NumUtilisateur LIKE ?";
        $stmt = $this->conn->prepare($query);
        $stmt->execute([$id]);
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    // Créer un utilisateur
    public function create($data)
    {

        // Vérification de sécurité : on s'assure que $data n'est pas nul et contient les clés
        if (!$data || !isset($data['login'], $data['mdp'], $data['type'])) {
            return false; 
        }

        try {
            $query = "INSERT INTO AG_Utilisateur (LoginUtilisateur, MotDePasseUtilisateur, TypeUtilisateur)
                        VALUES (:LoginUtilisateur, :MotDePasseUtilisateur, :TypeUtilisateur)";
            $stmt = $this->conn->prepare($query);
            $success = $stmt->execute([
                'LoginUtilisateur' => $data['LoginUtilisateur'],
                'MotDePasseUtilisateur' => $data['MotDePasseUtilisateur'],
                'TypeUtilisateur' => $data['TypeUtilisateur']
            ]);
            return $success;
        // si id en auto incrémente return $this->conn->lastInsertId();
        } catch(PDOException $e) {
            print "Error!: " . $e->getMessage() . "</br>";
            return false;
        }
    }

    // Mettre à jour un utilisateur
    public function update($id, $data)
    {
        try {
            $fields = [];
            $params = ['id' => $id];

            // On vérifie quels champs sont présents dans le JSON pour construire la requête
            if (isset($data['LoginUtilisateur'])) {
                $fields[] = "LoginUtilisateur = :LoginUtilisateur";
                $params['LoginUtilisateur'] = $data['LoginUtilisateur'];
            }
            if (isset($data['MotDePasseUtilisateur'])) {
                // Optionnel : hacher le mot de passe ici si nécessaire
                $fields[] = "MotDePasseUtilisateur = :MotDePasseUtilisateur";
                $params['MotDePasseUtilisateur'] = $data['MotDePasseUtilisateur'];
            }
            if (isset($data['TypeUtilisateur'])) {
                $fields[] = "TypeUtilisateur = :TypeUtilisateur";
                $params['TypeUtilisateur'] = $data['TypeUtilisateur'];
            }

            // Si aucun champ n'est fourni, on s'arrête
            if (empty($fields)) return 0;

            $query = "UPDATE AG_Utilisateur SET " . implode(', ', $fields) . " WHERE NumUtilisateur = :id";
            
            $stmt = $this->conn->prepare($query);
            $stmt->execute($params);

            // Retourne le nombre de lignes impactées
            return $stmt->rowCount();

        } catch(PDOException $e) {
            // En prod, préférez logger l'erreur plutôt que de l'afficher
            error_log($e->getMessage());
            return false;
        }
    }

    // Supprimer un utilisateur
    public function delete($id)
    {
        try {
            $query = "DELETE FROM AG_Utilisateur WHERE numUtilisateur = ?";
            $stmt = $this->conn->prepare($query);
            $sucess=$stmt->execute([$id]);
            //retourne toujours true même si la voture n'existe pas, 
            $sucess= $stmt->rowCount();
            //retourne le nombre de lignes modifiées 
            return $sucess;

        } catch(PDOException $e) {
        print "Error!: " . $e->getMessage() . "</br>";
        return false;
    }
    }
}
?>