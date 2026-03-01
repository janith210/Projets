package application.services;

import application.modeles.Contrainte;
import application.modeles.Etudiant;
import application.modeles.Groupe;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServiceApi {

    private final HttpClient client;
    private final Gson gson;

    // Base de l'URL
    private final String BASE_URL = "https://projets.iut-orsay.fr/saes3-rstinus/WEB/API_REST/";

    public ServiceApi() {
        this.gson = new Gson();

        // --- CONFIGURATION DU PROXY (Indispensable à l'IUT) ---
        // --- CONFIGURATION À L'IUT ---
    /*
    this.client = HttpClient.newBuilder()
            .proxy(ProxySelector.of(new InetSocketAddress("cache.iut-orsay.fr", 3128)))
            .build();
    */

        // --- CONFIGURATION À LA MAISON ---
        this.client = HttpClient.newBuilder()
                .build();
    }

    public Groupe[] recupererGroupes() {
        return appelApi("groupes", Groupe[].class);
    }

    public Etudiant[] recupererEtudiants() {
        return appelApi("etudiants", Etudiant[].class);
    }

    public Contrainte[] recupererContraintes() {
        return appelApi("contraintes", Contrainte[].class);
    }

    private <T> T appelApi(String scriptPhp, Class<T> typeDeClasse) {


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + scriptPhp))
                .GET()
                .build();

        try {
            System.out.println("Appel API vers : " + scriptPhp + " ...");

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            if (response.statusCode() != 200) {
                System.err.println("ERREUR HTTP " + response.statusCode() + " pour " + scriptPhp);
                return null;
            }

            int indexDebutCrochet = body.indexOf("[");
            int indexDebutAccolade = body.indexOf("{");
            int indexDebutJson = -1;

            if (indexDebutCrochet != -1 && (indexDebutAccolade == -1 || indexDebutCrochet < indexDebutAccolade)) {
                indexDebutJson = indexDebutCrochet;
            } else if (indexDebutAccolade != -1) {
                indexDebutJson = indexDebutAccolade;
            }

            if (indexDebutJson == -1) {
                System.err.println("ERREUR : Pas de JSON valide reçu (pas de crochet '[' trouvé ou d'accolade '{' trouvé).");
                System.err.println("Contenu reçu : " + body);
                return null;
            }

            String cleanJson = body.substring(indexDebutJson);

            T resultat = gson.fromJson(cleanJson, typeDeClasse);
            System.out.println("Succès ! Données récupérées pour " + scriptPhp);

            return resultat;

        } catch (java.net.ConnectException e) {
            System.err.println("ERREUR DE CONNEXION : Vérifiez le VPN ou le Proxy !");
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            System.err.println("ERREUR JSON : Le format reçu ne correspond pas à la classe " + typeDeClasse.getSimpleName());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("ERREUR INCONNUE :");
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateEtudiant(Etudiant etudiant) {
        try {
            String jsonBody = gson.toJson(etudiant);

            System.out.println("----------------------------------------");
            System.out.println("CONTENU DU JSON ENVOYÉ :");
            System.out.println(jsonBody);
            System.out.println("----------------------------------------");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "etudiants/" + etudiant.getNumEtudiant()))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                System.out.println("Mise à jour réussie sur le serveur !");
                return true;
            } else {
                System.err.println("Echec Update. Code HTTP : " + response.statusCode());
                System.err.println("Réponse serveur : " + response.body());
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}