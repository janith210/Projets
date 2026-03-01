package CiteUniversitaireTest;
import java.util.*;


import CiteUniversitaire.*;
import modeles.Etudiant;

public class EtudiantTest {
    private Etudiant EtudiantObject;

    public static void main(String[] args) {
        EtudiantTest test = new EtudiantTest();

        test.getIdEtudiant_NormalInput_ExpectedReturnValue();
        test.get_nomEtudiant_NormalInput__ExpectedReturnValue();
        test.get_prenomEtudiant_NormalInput_ExpectedReturnValue();
        test.get_nationaliteEtudiant_NormalInput_ExpectedReturnValue();
    }

    private void setup(int id, String nom, String prenom, String nationalite) {
        EtudiantObject = new Etudiant(id, nom, prenom, nationalite);
    }

    private void getIdEtudiant_NormalInput_ExpectedReturnValue() {
        setup(1,"","","");
        assert(EtudiantObject.getIdEtudiant() == 1);
        System.out.println("getIdEtudiant_NormalInput_ExpectedReturnValue passed.");
    }

    private void get_nomEtudiant_NormalInput__ExpectedReturnValue() {
        setup(1,"Dupont","","");
        assert(EtudiantObject.get_nomEtudiant() == "Dupont");
        System.out.println("get_nomEtudiant_NormalInput_ExpectedReturnValue passed.");
    }

    private void get_prenomEtudiant_NormalInput_ExpectedReturnValue() {
        setup(1,"Dupont","Gérard","");
        assert(EtudiantObject.get_prenomEtudiant() == "Gérard");
        System.out.println("get_prenomEtudiant_NormalInput_ExpectedReturnValue passed.");
    }

    private void get_nationaliteEtudiant_NormalInput_ExpectedReturnValue() {
        setup(1,"Dupont","Gérard","Français");
        assert(EtudiantObject.get_nationaliteEtudiant() == "Français");
        System.out.println("get_prenomEtudiant_NormalInput_ExpectedReturnValue passed.");
    }

}
