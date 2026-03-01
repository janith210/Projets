package CiteUniversitaireTest;

import java.util.ArrayList;
import java.util.Arrays;

import modeles.MaisonInternational;
import modeles.Service;

public class ServicesTest {
    private static MaisonInternational maisonTest;
    private static Service testService;

    // Initialisation des objets nécessaires
    public static void initialiseObjects() {
        maisonTest = new MaisonInternational("2.56,15.63");

        testService = new Service(maisonTest, "Bibliothèque", 
            "La bibliothèque a pour mission de collecter, cataloguer, conserver, enrichir et communiquer le patrimoine documentaire national");
        testService.set_horraireList(new ArrayList<>(Arrays.asList("8:00-22:30", "8:00-22:30", "12:00-22:30", "8:00-22:30", "8:00-22:30", "Fermé", "Fermé")));
    }

    // Test pour vérifier que le constructeur fonctionne correctement
    public static void serviceConstructorTest() {
        assert(testService.get_serviceMaisonInternational().equals("Bibliothèque")) : "Nom du service incorrect";
        assert(testService.get_descriptionService().equals("La bibliothèque a pour mission de collecter, cataloguer, conserver, enrichir et communiquer le patrimoine documentaire national")) : "Description du service incorrecte";
        assert(testService.get_horraireList().size() == 7) : "Les horaires du service sont incorrects";
        System.out.println("[OK] serviceConstructorTest réussi.");
    }

    // Test pour vérifier l'ajout d'un service à la MaisonInternational
    public static void addServiceTest() {
        maisonTest.ajouteService(testService);
        assert(maisonTest.get_Service().size() == 1) : "Le service n'a pas été correctement ajouté à la MaisonInternational";
        System.out.println("[OK] addServiceTest réussi.");
    }

    // Test pour vérifier la récupération des horaires
    public static void getHorraireListTest() {
        ArrayList<String> horaires = testService.get_horraireList();
        assert(horaires.size() == 7) : "Le nombre d'horaires est incorrect";
        assert(horaires.get(0).equals("8:00-22:30")) : "L'horaire du lundi est incorrect";
        assert(horaires.get(6).equals("Fermé")) : "L'horaire du dimanche est incorrect";
        System.out.println("[OK] getHorraireListTest réussi.");
    }

    // Exécution de tous les tests
    public static void runTests() {
        try {
            initialiseObjects();
            serviceConstructorTest();
            addServiceTest();
            getHorraireListTest();
            System.out.println("[OK] Tous les tests ont été passés avec succès : ServicesTest");
        } catch (Exception e) {
            System.out.println("[X] Les tests ne sont pas passés correctement : " + e);
        }
    }

    // Main pour exécuter les tests
    public static void main(String[] args) {
        runTests();
    }
}
