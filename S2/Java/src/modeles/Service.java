package modeles;

import java.util.*;

public class Service {

	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
	private MaisonInternational saMaisonInternational;
	private ArrayList<String> _horraireList;
	private String _serviceMaisonInternational;
	private String _descriptionService;

	//-----------------------------------------
	// CONSTRUCTEUR
	//-----------------------------------------
	public Service(MaisonInternational saMaisonInternational, String _serviceMaisonInternational, String _descriptionService){
		this.saMaisonInternational = saMaisonInternational;
		_horraireList = new ArrayList<String>();
		this._serviceMaisonInternational = _serviceMaisonInternational;
		this._descriptionService = _descriptionService;
	}
	
	//-----------------------------------------
	// SETTER AND GETTER
	//-----------------------------------------
	public ArrayList<String> get_horraireList() {
		return this._horraireList;
	}

	public void set_horraireList(ArrayList<String> _horraireList) {
		this._horraireList = _horraireList;
	}

	public String get_serviceMaisonInternational() {
		return this._serviceMaisonInternational;
	}

	public String get_descriptionService() {
		return this._descriptionService;
	}
	
}