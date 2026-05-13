<?php
// index.php
header("Content-Type: application/json");
require_once 'Database.php';
require_once 'utilisateur.php';
require_once 'etudiant.php';
require_once 'enseignant.php';
require_once 'groupe.php';
require_once 'contrainte.php';

// Instanciation de la base de données
$database = new Database();
$db = $database->getConnection();
$utilisateur = new utilisateur($db);
$etudiant = new etudiant($db);
$enseignant = new enseignant($db);
$contrainte = new contrainte($db);
$groupe = new groupe($db);

// Récupération de la méthode HTTP et de l'URL
$method = $_SERVER['REQUEST_METHOD'];
$url = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);
$urlParts = explode('/', trim($url, '/'));
$resource = $urlParts[3];
$id = $urlParts[4] ?? null;
// TO DEBUG
// print_r( $urlParts);

// Routage
switch ($method) {
    case 'GET':
        switch ($resource) {
            case 'utilisateurs':
                if ($id) {
                    // GET /utilisateur/{id}
                    $data = $utilisateur->getOne($id);
                    echo json_encode($data);
                } else {
                    // GET /utilisateur
                    $data = $utilisateur->getAll();
                    echo json_encode($data);
                }
                break;
            case 'etudiants':
                if ($id) {
                    // GET /etudiant/{id}
                    $data = $etudiant->getOne($id);
                    echo json_encode($data);
                } else {
                    // GET /etudiant
                    $data = $etudiant->getAll();
                    echo json_encode($data);
                }
                break;
            case 'enseignants':
                if ($id) {
                    // GET /enseignant/{id}
                    $data = $utilisateur->getOne($id);
                    echo json_encode($data);
                } else {
                    // GET /enseignant
                    $data = $utilisateur->getAll();
                    echo json_encode($data);
                }
                break;
            case 'contraintes':
                if ($id) {
                    // GET /contrainte/{id}
                    $data = $contrainte->getOne($id);
                    echo json_encode($data);
                } else {
                    // GET /contrainte
                    $data = $contrainte->getAll();
                    echo json_encode($data);
                }
                break;
            case 'groupes':
                if ($id) {
                    // GET /groupe/{id}
                    $data = $groupe->getOne($id);
                    echo json_encode($data);
                } else {
                    // GET /groupe
                    $data = $groupe->getAll();
                    echo json_encode($data);
                }
                break;
            default:
                $data = $utilisateur->getOne($id);
                echo json_encode($data);
                http_response_code(405);
                echo json_encode(["error" => "Ressource non autorisée"]);
                break;
        }
        break;
        
    case 'POST':
        switch ($resource) {
            case 'utilisateurs':
                // POST /utilisateur
                $json = file_get_contents("php://input");
                $data = json_decode($json, true);
                // Vérification si $data est bien un tableau
                if (!is_array($data)) {
                    http_response_code(400); // Bad Request
                    echo json_encode(["error" => "Données JSON invalides ou manquantes"]);
                    break;
                }
                $id = $utilisateur->create($data);
                if ($id) {
                    http_response_code(201);
                    echo json_encode(["success" => true, "id" => $id]);
                } else {
                    http_response_code(500);
                    echo json_encode(["success" => false, "message" => "Erreur lors de la création"]);
                }
                break;
            case 'etudiants':
                $json = file_get_contents("php://input");
                $data = json_decode($json, true);
                if (!is_array($data)) {
                    echo json_encode(["error" => "JSON invalide"]);
                    break;
                }
                $id = $etudiant->create($data);
                if ($id) {
                    http_response_code(201);
                    echo json_encode(["success" => true, "id" => $id]);
                } else {
                    http_response_code(500);
                    echo json_encode(["success" => false, "message" => "Erreur lors de la création"]);
                }
                break;
            case 'enseignants':
                // POST /enseignant
                $json = file_get_contents("php://input");
                $data = json_decode($json, true);
                // Vérification si $data est bien un tableau
                if (!is_array($data)) {
                    http_response_code(400); // Bad Request
                    echo json_encode(["error" => "Données JSON invalides ou manquantes"]);
                    break;
                }
                $id = $enseignant->create($data);
                if ($id) {
                    http_response_code(201);
                    echo json_encode(["success" => true, "id" => $id]);
                } else {
                    http_response_code(500);
                    echo json_encode(["success" => false, "message" => "Erreur lors de la création"]);
                }
                break;
            case 'contraintes':
                // POST /contrainte
                $json = file_get_contents("php://input");
                $data = json_decode($json, true);
                // Vérification si $data est bien un tableau
                if (!is_array($data)) {
                    http_response_code(400); // Bad Request
                    echo json_encode(["error" => "Données JSON invalides ou manquantes"]);
                    break;
                }
                $id = $contrainte->create($data);
                if ($id) {
                    http_response_code(201);
                    echo json_encode(["success" => true, "id" => $id]);
                } else {
                    http_response_code(500);
                    echo json_encode(["success" => false, "message" => "Erreur lors de la création"]);
                }
                break;
            case 'groupes':
                // POST /groupe
                $json = file_get_contents("php://input");
                $data = json_decode($json, true);
                // Vérification si $data est bien un tableau
                if (!is_array($data)) {
                    http_response_code(400); // Bad Request
                    echo json_encode(["error" => "Données JSON invalides ou manquantes"]);
                    break;
                }
                $id = $groupe->create($data);
                if ($id) {
                    http_response_code(201);
                    echo json_encode(["success" => true, "id" => $id]);
                } else {
                    http_response_code(500);
                    echo json_encode(["success" => false, "message" => "Erreur lors de la création"]);
                }
                break;
            default:
                http_response_code(405);
                echo json_encode(["error" => "Ressource non autorisée"]);
                break;
        }
        break;

    case 'PUT':
        switch ($resource) {
            case 'utilisateurs':
                // Récupération de l'ID depuis l'URL (ex: /utilisateurs/21)
                if ($id) {
                    $json = file_get_contents("php://input");
                    $data = json_decode($json, true);
                    $rowCount = $utilisateur->update($id, $data);
                    // Si rowCount > 0, succès. Si 0, aucune modification (id inexistant ou données identiques)
                    if ($rowCount > 0) {
                        http_response_code(200);
                        echo json_encode(["success" => true, "message" => "Mise à jour réussie", "rows" => $rowCount]);
                    } elseif ($rowCount !== false) {
                        http_response_code(404);
                        echo json_encode(["success" => true, "message" => "Aucune modification effectuée (ID inconnu ou données identiques)."]);
                    } else {
                        http_response_code(400);
                        echo json_encode(["success" => false, "message" => "Erreur lors de la mise à jour"]);
                    }
                } else {
                    http_response_code(401);
                    echo json_encode(["message" => "ID manquant"]);
                }
                break;
            case 'etudiants':
                if ($id) {
                    $json = file_get_contents("php://input");
                    $data = json_decode($json, true);
                    
                    // On récupère le tableau de réponse
                    $resultat = $etudiant->update($id, $data);

                    if ($resultat['status']) {
                        http_response_code(200);
                        echo json_encode([
                            "success" => true, 
                            "message" => "Mise à jour réussie", 
                            "rows" => $resultat['rows']
                        ]);
                    } else {
                        http_response_code(400);
                        echo json_encode([
                            "success" => false, 
                            "message" => "Erreur lors de la mise à jour",
                            "details" => $resultat['error'] // C'est ici que vous verrez le bug
                        ]);
                    }
                }
                break;
            case 'enseignants':
                // Récupération de l'ID depuis l'URL (ex: /enseignant/21)
                if ($id) {
                    $json = file_get_contents("php://input");
                    $data = json_decode($json, true);
                    $rowCount = $enseignant->update($id, $data);
                    // Si rowCount > 0, succès. Si 0, aucune modification (id inexistant ou données identiques)
                    if ($rowCount > 0) {
                        http_response_code(200);
                        echo json_encode(["success" => true, "message" => "Mise à jour réussie", "rows" => $rowCount]);
                    } elseif ($rowCount !== false) {
                        http_response_code(404);
                        echo json_encode(["success" => true, "message" => "Aucune modification effectuée (ID inconnu ou données identiques)."]);
                    } else {
                        http_response_code(400);
                        echo json_encode(["success" => false, "message" => "Erreur lors de la mise à jour"]);
                    }
                } else {
                    http_response_code(401);
                    echo json_encode(["message" => "ID manquant"]);
                }
                break;
            case 'contraintes':
                if ($id) {
                    $json = file_get_contents("php://input");
                    $data = json_decode($json, true);
                    
                    // On récupère le tableau de réponse
                    $resultat = $contrainte->update($id, $data);

                    if ($resultat['status']) {
                        http_response_code(200);
                        echo json_encode([
                            "success" => true, 
                            "message" => "Mise à jour réussie", 
                            "rows" => $resultat['rows']
                        ]);
                    } else {
                        http_response_code(400);
                        echo json_encode([
                            "success" => false, 
                            "message" => "Erreur lors de la mise à jour",
                            "details" => $resultat['error'] // C'est ici que vous verrez le bug
                        ]);
                    }
                }
                break;
            case 'groupes':
                // Récupération de l'ID depuis l'URL (ex: /enseignant/21)
                if ($id) {
                    $json = file_get_contents("php://input");
                    $data = json_decode($json, true);
                    $rowCount = $groupe->update($id, $data);
                    // Si rowCount > 0, succès. Si 0, aucune modification (id inexistant ou données identiques)
                    if ($rowCount > 0) {
                        http_response_code(200);
                        echo json_encode(["success" => true, "message" => "Mise à jour réussie", "rows" => $rowCount]);
                    } elseif ($rowCount !== false) {
                        http_response_code(404);
                        echo json_encode(["success" => true, "message" => "Aucune modification effectuée (ID inconnu ou données identiques)."]);
                    } else {
                        http_response_code(400);
                        echo json_encode(["success" => false, "message" => "Erreur lors de la mise à jour"]);
                    }
                } else {
                    http_response_code(401);
                    echo json_encode(["message" => "ID manquant"]);
                }
                break;
            default:
                http_response_code(405);
                echo json_encode(["error" => "Ressource non autorisée"]);
                break;
        }
        break;
    

    case 'DELETE':
        switch ($resource) {
            case 'utilisateurs':
                // DELETE /utilisateurs/{id}
                $success = $utilisateur->delete($id);
                http_response_code($success ? 200 : 404);
                echo json_encode(["success" => $success]);
                break;
            case 'etudiants':
                // DELETE /etudiant/{id}
                $success = $etudiant->delete($id);
                http_response_code($success ? 200 : 404);
                echo json_encode(["success" => $success]);
                break;
            case 'enseignants':
                // DELETE /enseignant/{id}
                $success = $enseignant->delete($id);
                http_response_code($success ? 200 : 404);
                echo json_encode(["success" => $success]);
                break;
            case 'contraintes':
                // DELETE /enseignant/{id}
                $success = $contrainte->delete($id);
                http_response_code($success ? 200 : 404);
                echo json_encode(["success" => $success]);
                break;
            case 'groupes':
                // DELETE /enseignant/{id}
                $success = $groupe->delete($id);
                http_response_code($success ? 200 : 404);
                echo json_encode(["success" => $success]);
                break;
            default:
                http_response_code(405);
                echo json_encode(["error" => "Ressource non autorisée"]);
                break;
        }
        break;
        
        
    default:
        http_response_code(405);
        echo json_encode(["error" => "Méthode non autorisée"]);
        break;
}

?>