package groupe.donnee;

public class Note {

    private String nom;
    private double valeur;
    private int num;
    private Etudiant etudiant;

    public Note(int numNote, double valeurNote, String nomNote, Etudiant etudiantNote) {
        this.num = numNote;
        this.valeur = valeurNote;
        this.nom = nomNote;
        this.etudiant = etudiantNote;

        this.etudiant.setNotes(this);
    }

    public double getValeur() {
        return this.valeur;
    }

}
