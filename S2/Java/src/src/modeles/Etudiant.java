package modeles;

import java.util.*;

public class Etudiant {

	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
	private Maison saMaison;
	private String _nomEtudiant;
	private String _prenomEtudiant;
	private String _nationaliteEtudiant;
	private int idEtudiant;
	private String _datedenaissance;
	private String _Etude;
	private String _email;

	//-----------------------------------------
	// CONSTRUCTEUR 
	//-----------------------------------------
	public Etudiant(int id, String nom, String prenom, String nationalite, String datedenaissance, String Etude, String email) {
		this.idEtudiant = id;
		this._nomEtudiant = nom;
		this._prenomEtudiant = prenom;
		this._nationaliteEtudiant = nationalite;
		this._datedenaissance = datedenaissance;
		this._Etude = Etude;
		this._email = email;
	}


	
	//-----------------------------------------
	// SETTER AND GETTER
	//-----------------------------------------
	public String get_nomEtudiant() {
		return this._nomEtudiant;
	}

	public String get_prenomEtudiant() {
		return this._prenomEtudiant;
	}

	public String get_nationaliteEtudiant() {
		return this._nationaliteEtudiant;
	}

	public int getIdEtudiant() {
		return this.idEtudiant;
	}

	public String get_datedenaissance() {

	    return this._datedenaissance;

	}
	
	public String getEmail() {
	    return _email;
	}


	public String get_Etude() {

	    return this._Etude;

	}
	
}