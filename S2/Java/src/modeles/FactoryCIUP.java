package modeles;

import java.util.ArrayList;
import java.util.Arrays;

public class FactoryCIUP {
	private ArrayList<Maison> listeMaisons = new ArrayList<>();
	private MaisonInternational maisonInternational;

	public FactoryCIUP() {
		// Creation des etudiants pour les differentes
		Etudiant etudiant1 = new Etudiant(1, "Morgan", "Daphne", "Chinois", "02/28/2006", "Informatique", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant2 = new Etudiant(2, "Teofilo", "Tito", "Portugais", "02/28/2002", "Chimie", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant3 = new Etudiant(3, "Lucie", "Socrates", "Bielorussie", "02/28/2000", "litéraire", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant4 = new Etudiant(4, "Almiro", "Andreia", "Chine", "02/28/1960", "jardinier", "suxum-eraxo31@hotmail.com");

		Etudiant etudiant5 = new Etudiant(5, "Wayne", "Brucce", "Benin", "02/28/2006", "Informatique", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant6 = new Etudiant(6, "Luthor", "Lex", "Benin", "02/28/2002", "Chimie", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant7 = new Etudiant(7, "Amaya", "Hawkins", "Sri Lanka", "02/28/1960", "jardinier", "suxum-eraxo31@hotmail.com");

		Etudiant etudiant8  = new Etudiant(8, "Abbott", "Victor", "Sri Lanka", "02/28/2006", "Informatique", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant9 	= new Etudiant(9, "Schaefer", "Ali", "Sri Lanka", "02/28/2002", "Chimie", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant10 = new Etudiant(10, "Jude", "Wolfe", "Trinite et Tobago", "02/28/1960", "jardinier", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant11 = new Etudiant(11, "Diane", "Carson", "Sri Lanka", "02/28/2000", "litéraire", "suxum-eraxo31@hotmail.com");

		Etudiant etudiant12 = new Etudiant(12, "Roderick", "Zimmerman", "Protugal", "02/28/2006", "Informatique", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant13 = new Etudiant(13, "Tony", "Church", "Protugal", "02/28/2002", "Chimie", "suxum-eraxo31@hotmail.com");
		Etudiant etudiant14 = new Etudiant(14, "Benita", "Chen", "Birmanie", "02/28/1960", "jardinier", "suxum-eraxo31@hotmail.com");

		//Creation des maisons
		Maison maisonChine = new Maison("Maison de la Chine", "Chine", "Xi Jinping", "34.66,104.16");
		Maison maisonPortugal = new Maison("Maison du Porugal", "Portugal", "Marcelo Rebelo de Sous", "14.66,5.16");
		Maison maisonSriLanka = new Maison("Maison du Sri Lanka", "Sri Lanka", "Anura Kumara Dissanayaka", "21.66,2.16");
		Maison maisonBenin = new Maison("Maison du Benin", "Benin", "Patrice Talon", "36.66,12.16");
		
		//creation de la maison Internationale
		maisonInternational = new MaisonInternational("2.56,15.63");

		//attribus la maisonChine avec des etudiants
		maisonChine.ajouteEtudiant(etudiant1);
		maisonChine.ajouteEtudiant(etudiant2);
		maisonChine.ajouteEtudiant(etudiant3);
		maisonChine.ajouteEtudiant(etudiant4);

		//attribus la maisonBenin avec des etudiants
		maisonBenin.ajouteEtudiant(etudiant5);
		maisonBenin.ajouteEtudiant(etudiant6);
		maisonBenin.ajouteEtudiant(etudiant7);

		//attribus la maisonSriLanka avec des etudiants
		maisonSriLanka.ajouteEtudiant(etudiant8 );
		maisonSriLanka.ajouteEtudiant(etudiant9 );
		maisonSriLanka.ajouteEtudiant(etudiant10);
		maisonSriLanka.ajouteEtudiant(etudiant11);

		//attribus la maisonSriLanka avec des etudiants
		maisonPortugal.ajouteEtudiant(etudiant12);
		maisonPortugal.ajouteEtudiant(etudiant13);
		maisonPortugal.ajouteEtudiant(etudiant14);
		
		//Creation d'un menu et ajout des menus de la semaine

		ArrayList<String> menuVegetarien = new ArrayList<String>();
		menuVegetarien.add("Aubergine_grille Ratatouille salade-de-fruit");
		menuVegetarien.add("Salade-verte Frites pomme-confite");
		menuVegetarien.add("Roquette Sorbet-menthe");
		menuVegetarien.add("Salade-mixte Steack-vegetal banana-split");
		menuVegetarien.add("Soupe-a-l'oignon babka-cannelle");
		menuVegetarien.add("Bruschetta spaghetti-pesto Aletria");
		menuVegetarien.add("Puree-d'igname-pesto crepe-massa");
		menuVegetarien.add("Salade-de-chou-rouge Tofu-sauce-arachide Tarte-mangue");
		
		//Creation d'un menu et ajout des menus de la semaine
		ArrayList<String> menuSansSpecification = new ArrayList<String>();
		menuSansSpecification.add("Salade-cesar Lasagne steak salade-de-fruit");
		menuSansSpecification.add("Soupe-tom-yum porc-Aigre-doux pomme-confite");
		menuSansSpecification.add("Salade-de-papaye Curry-de-fruit-du-jacquier Sorbet-menthe");
		menuSansSpecification.add("Crevettes-tempura Morue banana-split");
		menuSansSpecification.add("Tabouleh Le-Watche babka-cannelle");
		menuSansSpecification.add("Nems-au-porc Ablo Aletria");
		menuSansSpecification.add("Soupe-wonton raviolis-de-Shanghai crepe-massa");
		menuSansSpecification.add("Bricks-au-fromage Poulet-yassa Mousse-citron-vert");

		//Ajout des restoU
		RestoU menuPortugal = new RestoU();
		menuPortugal.ajouteMenuSemaine(menuSansSpecification);
		menuPortugal.ajouteMenuSemaine(menuVegetarien);
		menuPortugal.setType("normal/vege");

		RestoU menuSriLanka = new RestoU();
		menuSriLanka.ajouteMenuSemaine(menuVegetarien);
		menuSriLanka.ajouteMenuSemaine(menuVegetarien);
		menuSriLanka.setType("normal/vege");

		RestoU menuBenin = new RestoU();
		menuBenin.ajouteMenuSemaine(menuSansSpecification);
		menuBenin.ajouteMenuSemaine(menuVegetarien);
		menuBenin.setType("normal/vege");
		//menuBenin.setType("vege");
		

		RestoU menuChine = new RestoU();
		menuChine.ajouteMenuSemaine(menuSansSpecification);
		menuChine.ajouteMenuSemaine(menuVegetarien);
		menuChine.setType("normal/vege");
		

		RestoU menuInternational = new RestoU();
		menuInternational.ajouteMenuSemaine(menuSansSpecification);
		menuInternational.ajouteMenuSemaine(menuVegetarien);
		menuInternational.setType("normal/vege");
		

		//On assigne les menus au maisons
		maisonBenin.ajouteMenu(menuBenin);
		maisonChine.ajouteMenu(menuChine);
		maisonPortugal.ajouteMenu(menuPortugal);
		maisonSriLanka.ajouteMenu(menuSriLanka);
		
		System.out.println("Resto Ajouté");
		//maisonBenin.afficheRestoU();
		//menuBenin.afficheRestoU();

		maisonInternational.ajouteMenu(menuInternational);

		//On assigne les services a la maison intenational
		Service Bibliotheque = new Service(maisonInternational, "Bibliotheque", "La bibliothèque a pour mission de collecter, cataloguer, conserver, enrichir et communiquer le patrimoine documentaire national");
		Bibliotheque.set_horraireList(new ArrayList<>(Arrays.asList("8:00-22:30", "8:00-22:30", "12:00-22:30", "8:00-22:30", "8:00-22:30", "Ferme", "Ferme")));

		maisonInternational.ajouteService(Bibliotheque);
		
		//Ajout des maisons dans l'attribut
		listeMaisons.add(maisonBenin);
		listeMaisons.add(maisonChine);
		listeMaisons.add(maisonPortugal);
		listeMaisons.add(maisonSriLanka);
	}	
	public ArrayList<Maison> getListeMaisons() {
		return listeMaisons;
	}
	
	public MaisonInternational getMaisonInternational() {
		return maisonInternational;
	}
}
