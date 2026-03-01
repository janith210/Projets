package CiteUniversitaireTest;
import java.util.*;

import modeles.MaisonInternational;
import modeles.RestoU;
import modeles.Service;


public class MaisonInternationalTest {
    static MaisonInternational maisonTestSansRestoUSansService;
    static MaisonInternational maisonTestAvecRestoUAvecService;
    static ArrayList<String> menuTest = new ArrayList<String>();
    static Service Test_Service; 
    static RestoU restoUMenuTest;
	

    public static void initialiseMenu() {
        menuTest.add("Aubergine grille ou Ratatouille et salade de fruit");
        menuTest.add("Frites et pomme confite");
        menuTest.add("Roquette et Sorbet menthe");
        menuTest.add("Steack vegetal et banana split");
        menuTest.add("Soupe a l'oignon et babka cannelle");
        menuTest.add("Spaghetti pesto et Aletria");
        menuTest.add("Puree d'igname pesto et crepe massa");



        Test_Service = new Service(maisonTestAvecRestoUAvecService, "Bibliotheque", "La bibliothèque a pour mission de collecter, cataloguer, conserver, enrichir et communiquer le patrimoine documentaire national");

        restoUMenuTest = new RestoU();
        restoUMenuTest.ajouteMenuSemaine(menuTest);
        
        maisonTestSansRestoUSansService = new MaisonInternational("3.12,15");
        maisonTestAvecRestoUAvecService = new MaisonInternational("3.12,15", restoUMenuTest);
    }

    public static void MaisonInternationalConstructeurRestoU(){
        assert(maisonTestSansRestoUSansService.get_RestoU() == null) : "Constructeur mal initialisé";
        assert(maisonTestAvecRestoUAvecService.get_RestoU() != null) : "Constructeur mal initialisé";
        System.out.println("[OK] MaisonInternationalConstructeurRestoU est réussi avec succès");
    }

    public static void MaisonInternationalCheckServiceAjout(){
        maisonTestAvecRestoUAvecService.ajouteService(Test_Service);
        assert(maisonTestSansRestoUSansService.get_Service() == null) : "Mauvais ajout de service";
        assert(maisonTestAvecRestoUAvecService.get_Service() != null) : "Mauvais ajout de service";
        System.out.println("[OK] MaisonInternationalCheckServiceAjout est réussi avec succès");
    }

    public static void MaisonInternationalAjoutRestoU(){
        maisonTestSansRestoUSansService.ajouteMenu(restoUMenuTest);
        assert(maisonTestSansRestoUSansService.get_RestoU() != null) : "Mauvais ajout Resto";
        System.out.println("[OK] MaisonInternationalAjoutRestoU est réussi avec succès");
    }


    public static void runTest(){
        try{
            initialiseMenu();
            MaisonInternationalConstructeurRestoU();
            MaisonInternationalCheckServiceAjout();
            MaisonInternationalAjoutRestoU();
            System.out.println("[OK] Tout les tests ont été passés avec succès:  MaisonInternationalTest");
        }catch(Exception exceptionAttrape){
            System.out.println("[X] Les tests ne sont pas passés correctement : MaisonInternationalTest : " + exceptionAttrape);
        }
    }
    
    public static void main(String[] arg) {
    	runTest();
    }
}
