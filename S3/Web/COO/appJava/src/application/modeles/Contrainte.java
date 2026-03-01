package application.modeles;

public class Contrainte {
    private int NumContrainte;
    private String NomContrainte;
    private String TypeContrainte;
    private int ValeurContrainte;
    private int NumEnseignant;

    public Contrainte() {}

    public Contrainte(int NumContrainte, String NomContrainte, String TypeContrainte, int ValeurContrainte, int NumEnseignant) {
        this.NumContrainte = NumContrainte;
        this.NomContrainte = NomContrainte;
        this.TypeContrainte = TypeContrainte;
        this.ValeurContrainte = ValeurContrainte;
        this.NumEnseignant = NumEnseignant;
    }

    public int getNumEnseignant() {
        return NumEnseignant;
    }
    public void setNumEnseignant(int NumEnseignant) {
        this.NumEnseignant = NumEnseignant;
    }

    public String getNomContrainte() {
        return NomContrainte;
    }
    public void setNomContrainte(String NomContrainte) {
        this.NomContrainte = NomContrainte;
    }

    public String getTypeContrainte() {
        return TypeContrainte;
    }
    public void setTypeContrainte(String TypeContrainte) {
        this.TypeContrainte = TypeContrainte;
    }

    public int getValeurContrainte() {
        return ValeurContrainte;
    }
    public void setValeurContrainte(int ValeurContrainte) {
        this.ValeurContrainte = ValeurContrainte;
    }

    public int getNumContrainte() {
        return NumContrainte;
    }
    public void setNumContrainte(int numContrainte) {
        NumContrainte = numContrainte;
    }
}
