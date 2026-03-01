package modeles;

import java.util.*;

public class RestoU {
	
	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
	private MaisonInternational saMaisonInternational;
	private Maison saMaison;
	private ArrayList<ArrayList<String>> _menu;
	public static ArrayList<String> _nom_jour_semaine = new ArrayList<>(
	        Arrays.asList("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"));
	final static private int _NB_MENU_MAX = 8;
	private String typeMenu;

	//-----------------------------------------	
	// CONSTRUCTEUR 
	//-----------------------------------------
	public RestoU() {
		_menu = new ArrayList<>();
	}
	
	public String getType() {return this.typeMenu;}
	public void setType(String t) {typeMenu = t;}
	
	//-----------------------------------------
	// METHODES
	//-----------------------------------------
	public ArrayList<ArrayList<String>> getMenu() {
		return _menu;
	}
	public boolean ajouteMenuSemaine(ArrayList<String> menu){
		if (menu.size() == _NB_MENU_MAX){
			_menu.add(menu);
			return true;
		}else{
			return false;
		}
	}

	public void afficheRestoU() {
        
        for (int i = 0; i < _menu.size(); i++) {
            System.out.println("Menu " + (i+1) + ":");
            ArrayList<String> weeklyMenu = _menu.get(i);
            for (int j = 0; j < weeklyMenu.size(); j++) {               
                System.out.println(weeklyMenu.get(j));
            }
            System.out.println();
        }
    }

}