package modeles;

import java.util.*;

public class MaisonInternational {

	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
	private RestoU sonRestoU;
	private String _localisationGPS;
	private ArrayList<Service> sesServices;

	//-----------------------------------------
	// CONSTRUCTEUR 
	//-----------------------------------------
	public MaisonInternational (String _localisationGPS) {
		this._localisationGPS = _localisationGPS;
		sesServices = new ArrayList<Service>();
	}
	
	public MaisonInternational (String _localisationGPS, RestoU sonRestoU) {
		this._localisationGPS = _localisationGPS;
		this.sonRestoU = sonRestoU;	
		sesServices = new ArrayList<Service>();
	}
	
	//-----------------------------------------
	// METHODES
	//-----------------------------------------

	public RestoU get_RestoU(){
		return sonRestoU;
	}

	public ArrayList<Service> get_Service(){
		return sesServices;
	}

	public void ajouteService(Service _service){
		sesServices.add(_service);
	}

	public void ajouteMenu(RestoU r) {
		this.sonRestoU = r;
	}

	public void afficheService() {
		for (Service s : sesServices) {
			System.out.println("Service: " + s.get_serviceMaisonInternational());
			System.out.println("Description: " + s.get_descriptionService());
			System.out.println("Horaires: " + String.join(", ", s.get_horraireList()));
		}
	}
	
	public void afficheRestoU() {
		if (sonRestoU != null) {
			sonRestoU.afficheRestoU();
		}
	}
	
	
}