package CiteUniversitaireTest;
import java.util.*;

import modeles.RestoU;

public class RestoUTest {
    private static ArrayList<String> menuTest = new ArrayList<String>();
    private static RestoU restoTest;

    // Initialiser le menu
    public void initialiseMenu() {
        menuTest.add("Aubergine grille ou Ratatouille et salade de fruit");
        menuTest.add("Frites et pomme confite");
        menuTest.add("Roquette et Sorbet menthe");
        menuTest.add("Steack vegetal et banana split");
        menuTest.add("Soupe a l'oignon et babka cannelle");
        menuTest.add("Spaghetti pesto et Aletria");
        menuTest.add("Puree d'igname pesto et crepe massa");
        menuTest.add("Saucisse Purée");
        RestoU restoTest = new RestoU();
    }

    // Test pour vérifier la bon initialisation du constructeur
    public static void constructorIsAnArrayOfArray() {
        assert(restoTest.getMenu() instanceof ArrayList<ArrayList<String>>) : "Mauvais instance de l'attribut";
        assert(restoTest.getMenu() != null) : "Menu n'as pas été initialisé";
        System.out.println("[OK] constructorIsAnArrayOfArray est réussi avec succès");
    }

    // Test pour vérifier la taille du menu
    public void checkSizeMenu() {
        assert(restoTest.ajouteMenuSemaine(menuTest) == false);
        System.out.println("[OK] checkSizeMenu est réussi avec succès");
    }
    
    public static void testAjoutePlusieursMenus() {
        RestoU resto = new RestoU();
        ArrayList<String> menu1 = new ArrayList<>(Arrays.asList(
            "P1", "P2", "P3", "P4", "P5", "P6", "P7"
        ));
        ArrayList<String> menu2 = new ArrayList<>(Arrays.asList(
            "Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7"
        ));
        assert(resto.ajouteMenuSemaine(menu1));
        assert(resto.ajouteMenuSemaine(menu2));
        assert(2 == resto.getMenu().size());
        System.out.println("[OK] testAjoutePlusieursMenus est réussi avec succès");
    }

    // Méthode pour exécuter tous les tests
    public static void runTest() {
        try {
            RestoUTest test = new RestoUTest();
            test.initialiseMenu();
            constructorIsAnArrayOfArray();
            test.checkSizeMenu();
            testAjoutePlusieursMenus();
            
            System.out.println("[OK] Tous les Tests RestoU ont été passés avec succès");
        } catch (Exception exceptionAttrape) {
            System.out.println("[X] Les tests ne sont pas passés correctement : " + exceptionAttrape);
        }
    }
    
    public static void main(String[] arg) {
    	runTest();
    }

}
