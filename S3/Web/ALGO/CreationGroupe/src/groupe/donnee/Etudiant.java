package groupe.donnee;

import java.util.ArrayList;

public class Etudiant {
    public static ArrayList<Etudiant> etudiantFiliere = new ArrayList<>();

    private char parcours;
    private String typeBac;
    private String nom;
    private String prenom;
    private int groupe;
    private int promo;
    private char genre;
    private int covoiturage;
    private boolean anglophone;
    private ArrayList<Note> notes;

    public Etudiant(char parcours, String typeBac, String nom, String prenom, int promo, char genre, boolean anglophone, int covoiturage) {
        this.nom = nom;
        this.prenom = prenom;
        this.typeBac = typeBac;
        this.parcours = parcours;
        this.promo = promo;
        this.covoiturage = covoiturage;
        this.anglophone = anglophone;
        this.genre = genre;

        etudiantFiliere.add(this);
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getTypeBac() {
        return this.typeBac;
    }

    public char getParcours() {
        return this.parcours;
    }

    public int getGroupe() {
        return this.groupe;
    }

    public int getPromo() {
        return this.promo;
    }

    public char getGenre() {
        return this.genre;
    }

    public int getCovoiturage() {
        return this.covoiturage;
    }

    public boolean getAnglophone() {
        return this.anglophone;
    }

    public static ArrayList<Etudiant> getEtudiantFiliere() {
        return etudiantFiliere;
    }

    public double getMoyenne() {
        double resultat=0;
        double somme=0;

        for (int i=0; i<notes.toArray().length; i++) {
            somme += notes.get(i).getValeur();
        }

        resultat = (somme/notes.toArray().length);

        return resultat;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    public void setNotes(Note note) {
        this.notes.add(note);
    }

}
