package application.modeles;

public class Groupe {
    private int NumGroupe;
    private String TypeGroupe;
    private int CapaciteGroupe;
    private int NumEnseignantResponsableAnnee;
    private int NumEnseignantResponsable;

    public Groupe() {}

    public Groupe(int NumGroupe, String TypeGroupe, int CapaciteGroupe, int NumEnseignantResponsableAnnee, int NumResp) {
        this.NumGroupe = NumGroupe;
        this.TypeGroupe = TypeGroupe;
        this.CapaciteGroupe = CapaciteGroupe;
        this.NumEnseignantResponsableAnnee = NumEnseignantResponsableAnnee;
        this.NumEnseignantResponsable = NumEnseignantResponsable;
    }

    public int getNum() {return NumGroupe;}
    public void setNum(int NumGroupe) {this.NumGroupe = NumGroupe;}

    public String getType() {return TypeGroupe;}
    public void setType(String TypeGroupe) {this.TypeGroupe = TypeGroupe;}

    public int getCapacite() {return CapaciteGroupe;}
    public void setCapacite(int capacite) {CapaciteGroupe = CapaciteGroupe;}

    public int getNumRespAnnee() {return NumEnseignantResponsableAnnee;}
    public void setNumRespAnnee(int NumEnseignantResponsableAnnee) {NumEnseignantResponsableAnnee = NumEnseignantResponsableAnnee;}

    public int getNumResp() {return NumEnseignantResponsable;}
    public void setNumResp(int NumEnseignantResponsable) {NumEnseignantResponsable = NumEnseignantResponsable;}

}
