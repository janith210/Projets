package application.modeles;

public class Etudiant {

    private int NumEtudiant;
    private String NomEtudiant;
    private String PrenomEtudiant;
    private String DateNaissanceEtudiant;
    private String AdresseEtudiant;
    private String TelephoneEtudiant;
    private String GenreEtudiant;
    private String EmailEtudiant;
    private String TypeBacEtudiant;
    private String ParcoursEtudiant;
    private int OptionAnglaisEtudiant;
    private String PeriodeRedoublementEtudiant;
    private int NumUtilisateur;
    private int NumEnseignant;
    private int NumEnseignantResponsable;
    private int NumEnseignantResponsableFiliere;
    private int NumCovoiturage;
    private int NumPromotion;
    private int NumGroupe;

    public Etudiant() {}

    public Etudiant(int NumEtudiant,
                    String NomEtudiant,
                    String PrenomEtudiant,
                    String DateNaissanceEtudiant,
                    String AdresseEtudiant,
                    String TelephoneEtudiant,
                    String GenreEtudiant,
                    String EmailEtudiant,
                    String TypeBacEtudiant,
                    String ParcoursEtudiant,
                    int OptionAnglaisEtudiant,
                    String PeriodeRedoublementEtudiant,
                    int NumUtilisateur,
                    int NumEnseignant,
                    int NumEnseignantResponsable,
                    int NumEnseignantResponsableFiliere,
                    int NumCovoiturage,
                    int NumPromotion,
                    int NumGroupe)
    {
        this.NumEtudiant = NumEtudiant;
        this.NomEtudiant = NomEtudiant;
        this.PrenomEtudiant = PrenomEtudiant;
        this.DateNaissanceEtudiant = DateNaissanceEtudiant;
        this.AdresseEtudiant = AdresseEtudiant;
        this.TelephoneEtudiant = TelephoneEtudiant;
        this.GenreEtudiant = GenreEtudiant;
        this.EmailEtudiant = EmailEtudiant;
        this.TypeBacEtudiant = TypeBacEtudiant;
        this.ParcoursEtudiant = ParcoursEtudiant;
        this.OptionAnglaisEtudiant=OptionAnglaisEtudiant;
        this.PeriodeRedoublementEtudiant=PeriodeRedoublementEtudiant;
        this.NumUtilisateur=NumUtilisateur;
        this.NumEnseignant=NumEnseignant;
        this.NumEnseignantResponsable=NumEnseignantResponsable;
        this.NumEnseignantResponsableFiliere=NumEnseignantResponsableFiliere;
        this.NumCovoiturage=NumCovoiturage;
        this.NumPromotion=NumPromotion;
        this.NumGroupe=NumGroupe;
    }

    public int getNumEtudiant() {
        return NumEtudiant;
    }
    public void setNumEtudiant(int numEtudiant) {
        NumEtudiant = numEtudiant;
    }

    public String getNomEtudiant() {
        return NomEtudiant;
    }
    public void setNomEtudiant(String nomEtudiant) {
        NomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return PrenomEtudiant;
    }
    public void setPrenomEtudiant(String prenomEtudiant) {
        PrenomEtudiant = prenomEtudiant;
    }

    public String getDateNaissanceEtudiant() {
        return DateNaissanceEtudiant;
    }
    public void setDateNaissanceEtudiant(String dateNaissanceEtudiant) {
        DateNaissanceEtudiant = dateNaissanceEtudiant;
    }

    public String getAdresseEtudiant() {
        return AdresseEtudiant;
    }
    public void setAdresseEtudiant(String adresseEtudiant) {
        AdresseEtudiant = adresseEtudiant;
    }

    public String getTelephoneEtudiant() {
        return TelephoneEtudiant;
    }
    public void setTelephoneEtudiant(String telephoneEtudiant) {
        TelephoneEtudiant = telephoneEtudiant;
    }

    public String getGenreEtudiant() {
        return GenreEtudiant;
    }
    public void setGenreEtudiant(String genreEtudiant) {
        GenreEtudiant = genreEtudiant;
    }

    public String getEmailEtudiant() {
        return EmailEtudiant;
    }
    public void setEmailEtudiant(String emailEtudiant) {
        EmailEtudiant = emailEtudiant;
    }

    public String getTypeBacEtudiant() {
        return TypeBacEtudiant;
    }
    public void setTypeBacEtudiant(String typeBacEtudiant) {
        TypeBacEtudiant = typeBacEtudiant;
    }

    public String getParcoursEtudiant() {
        return ParcoursEtudiant;
    }
    public void setParcoursEtudiant(String parcoursEtudiant) {
        ParcoursEtudiant = parcoursEtudiant;
    }

    public int getOptionAnglaisEtudiant() {
        return OptionAnglaisEtudiant;
    }
    public void setOptionAnglaisEtudiant(int optionAnglaisEtudiant) {
        OptionAnglaisEtudiant = optionAnglaisEtudiant;
    }

    public String getPeriodeRedoublementEtudiant() {
        return PeriodeRedoublementEtudiant;
    }
    public void setPeriodeRedoublementEtudiant(String periodeRedoublementEtudiant) {
        PeriodeRedoublementEtudiant = periodeRedoublementEtudiant;
    }

    public int getNumUtilisateur() {
        return NumUtilisateur;
    }
    public void setNumUtilisateur(int numUtilisateur) {
        NumUtilisateur = numUtilisateur;
    }

    public int getNumEnseignant() {
        return NumEnseignant;
    }
    public void setNumEnseignant(int numEnseignant) {
        NumEnseignant = numEnseignant;
    }

    public int getNumEnseignantResponsable() {
        return NumEnseignantResponsable;
    }
    public void setNumEnseignantResponsable(int numEnseignantResponsable) {
        NumEnseignantResponsable = numEnseignantResponsable;
    }

    public int getNumEnseignantResponsableFiliere() {
        return NumEnseignantResponsableFiliere;
    }
    public void setNumEnseignantResponsableFiliere(int numEnseignantResponsableFiliere) {
        NumEnseignantResponsableFiliere = numEnseignantResponsableFiliere;
    }

    public int getNumCovoiturage() {
        return NumCovoiturage;
    }
    public void setNumCovoiturage(int numCovoiturage) {
        NumCovoiturage = numCovoiturage;
    }

    public int getNumPromotion() {
        return NumPromotion;
    }
    public void setNumPromotion(int numPromotion) {
        NumPromotion = numPromotion;
    }

    public int getNumGroupe() {
        return NumGroupe;
    }
    public void setNumGroupe(int numGroupe) {
        NumGroupe = numGroupe;
    }
}