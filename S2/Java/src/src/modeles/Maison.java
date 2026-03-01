package modeles;

import java.util.*;
import modeles.*;

public class Maison {

	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
	private RestoU sonRestoU;
	private ArrayList<Etudiant> sesEtudiants;
	private String _nomMaison;
	private String _nationaliteMaison;
	private String _directeurMaison;
	private String _GPSLocalisationMaison;
	private int _nbChambreMaison;
	public final int _NB_MAX_ETUDIANT = 30;
	
	//-----------------------------------------
	// CONSTRUCTEUR 
	//-----------------------------------------
	public Maison(String nom, String nationalite, String directeur, String localisation) {
		this._nomMaison = nom;
		this._nationaliteMaison = nationalite;
		this._directeurMaison = directeur;
		this._GPSLocalisationMaison = localisation;
		this.sesEtudiants = new ArrayList<>();
		this._nbChambreMaison = _NB_MAX_ETUDIANT; 
		//this.sonRestoU = new RestoU();
	}
	
	//-----------------------------------------
	// SETTER AND GETTER
	//-----------------------------------------
	public String get_nomMaison() {
		return this._nomMaison;
	}

	public void set_nomMaison(String nomMaison) {
		this._nomMaison = nomMaison;
	}

	public String get_nationaliteMaison() {
		return this._nationaliteMaison;
	}

	public void set_nationaliteMaison(String nationaliteMaison) {
		this._nationaliteMaison = nationaliteMaison;
	}
	
	public ArrayList<Etudiant> getEtudiants() {
		return this.sesEtudiants;
	}

	public String get_directeurMaison(){
		return this._directeurMaison;
	}

	public String get_GPSLocalisationMaison(){
		return this._GPSLocalisationMaison;
	}
	
	//-----------------------------------------
	// METHODES
	//-----------------------------------------
	public void afficheetudiant() {
		for (Etudiant etudiant : sesEtudiants) {
	        System.out.print(etudiant.get_nomEtudiant() + "; ");
	        System.out.print(etudiant.get_nomEtudiant() + "; ");
	        System.out.println(etudiant.get_nationaliteEtudiant() + "; ");
	    }
	}
	
	public void ajouteEtudiant(Etudiant e) {
	    if (_nbChambreMaison > 0) {
	        sesEtudiants.add(e);
	        _nbChambreMaison--;
	    } else {
	        throw new IllegalArgumentException("Plus de chambres disponibles !");
	    }
	}

	public void ajouteMenu(RestoU r) {
		sonRestoU = r;
	}
	
	public RestoU getRestoU() {return sonRestoU;}

	public void afficheRestoU() {
	    if (sonRestoU == null) {
	        throw new IllegalArgumentException("Le RestoU est null !");
	    } else {
	        sonRestoU.afficheRestoU();
	    }
	}

}