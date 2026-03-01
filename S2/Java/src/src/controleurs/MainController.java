package controleurs;

import modeles.FactoryCIUP;
import modeles.Maison;
import vues2.AjoutMaisonView;
import vues2.EtudiantView;
import vues2.HomePageView;
import vues2.MainView;
import vues2.MaisonView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Contrôleur principal de l'application CIUP.
 * Gère la navigation entre les différentes vues et coordonne les actions utilisateur.
 */
public class MainController {
    private FactoryCIUP factory;
    private MainView mainView;
    private HashMap<String, JPanel> panelMap;
    
    /**
     * Constructeur du contrôleur principal.
     * Initialise la factory CIUP et la vue principale.
     */
    public MainController() {
        this.factory = new FactoryCIUP();
        this.panelMap = new HashMap<>();
        this.mainView = new MainView(this);
    }
    
    /**
     * Gère l'ajout d'une nouvelle maison.
     * @param nom Nom de la maison
     * @param directeur Nom du directeur
     * @param nationalite Nationalité de la maison
     * @param gps Coordonnées GPS
     * @param nbChambres Nombre de chambres
     */
    public void ajouterMaison(String nom, String directeur, String nationalite, String gps, int nbChambres) {
        try {
            Maison nouvelleMaison = new Maison(nom, nationalite, directeur, gps);
            factory.getListeMaisons().add(nouvelleMaison);
            mainView.creerVueMaison(nouvelleMaison);
            mainView.creerVueEtudiant(nouvelleMaison);
            mainView.rafraichirHomePage();
            JOptionPane.showMessageDialog(mainView, "Maison ajoutée avec succès!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainView, "Erreur lors de l'ajout: " + e.getMessage());
        }
    }
    
    /**
     * Gère la suppression d'une maison.
     * @param nomMaison Nom de la maison à supprimer
     */
    public void supprimerMaison(String nomMaison) {
        factory.getListeMaisons().removeIf(maison -> maison.get_nomMaison().equals(nomMaison));
        mainView.supprimerVueMaison(nomMaison);
        mainView.rafraichirHomePage();
    }
    
    /**
     * Retourne la liste des maisons.
     * @return Liste des maisons
     */
    public java.util.List<Maison> getListeMaisons() {
        return factory.getListeMaisons();
    }
    
    /**
     * Lance l'application.
     */
    public void demarrer() {
        mainView.setVisible(true);
    }
} 