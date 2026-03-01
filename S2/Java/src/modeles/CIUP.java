package modeles;

import java.util.ArrayList;

public class CIUP {
	public static void main(String[] args) {
		FactoryCIUP factory = new FactoryCIUP();

		//Tou d'abord on initialise les tout les objets et on les lient ensemble
		//factory.FactoryCIUP();

		// On récupère les maisons
		ArrayList<Maison> listeMaison = factory.getListeMaisons();
		MaisonInternational laMaisonInternational = factory.getMaisonInternational();

		for(int i=0; i<listeMaison.size();i++){
			System.out.println("Maison: " + listeMaison.get(i).get_nomMaison());
			System.out.println("Nationnalite: " + listeMaison.get(i).get_nationaliteMaison());
			System.out.println("Directeur: " + listeMaison.get(i).get_directeurMaison());
			System.out.println("Localisation: " + listeMaison.get(i).get_GPSLocalisationMaison());
			System.out.println("Etudiant present dans la maison: ");
			listeMaison.get(i).afficheetudiant();
			
			System.out.println("");
			System.out.println("");
			
			System.out.println("Menu Disponible");
			listeMaison.get(i).afficheRestoU();
			
		}

		System.out.println("La Maison International");
		laMaisonInternational.afficheService();
		laMaisonInternational.afficheRestoU();
	}
}
