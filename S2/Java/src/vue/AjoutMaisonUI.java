package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Interface graphique pour ajouter une nouvelle maison.
 * @author Pierre Sounouvou
 */
public class AjoutMaisonUI {
    private JPanel panel;
    private JTextField nomField, directeurField, nationaliteField, gpsField, nbChambresField;
    private JButton validerButton;

    /**
     * Constructeur qui initialise l'interface d'ajout de maison.
     * @param onValider ActionListener pour le bouton de validation
     */
    public AjoutMaisonUI(ActionListener onValider) {
        panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Ajouter une Maison"));

        nomField = new JTextField();
        directeurField = new JTextField();
        nationaliteField = new JTextField();
        gpsField = new JTextField();
        nbChambresField = new JTextField();
        validerButton = new JButton("Créer la maison");

        panel.add(new JLabel("Nom de la maison:"));
        panel.add(nomField);
        panel.add(new JLabel("Directeur:"));
        panel.add(directeurField);
        panel.add(new JLabel("Nationalité:"));
        panel.add(nationaliteField);
        panel.add(new JLabel("Localisation GPS:"));
        panel.add(gpsField);
        panel.add(new JLabel("Nombre de chambres:"));
        panel.add(nbChambresField);

        panel.add(new JLabel(""));
        panel.add(validerButton);

        validerButton.addActionListener(onValider);
    }

    /**
     * Retourne le panel principal de l'interface.
     * @return Le panel contenant tous les composants
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Récupère le nom saisi pour la maison.
     * @return Le nom de la maison
     */
    public String getNom() { 
        return nomField.getText(); 
    }
    
    /**
     * Récupère le nom du directeur saisi.
     * @return Le nom du directeur
     */
    public String getDirecteur() { 
        return directeurField.getText(); 
    }
    
    /**
     * Récupère la nationalité saisie.
     * @return La nationalité
     */
    public String getNationalite() { 
        return nationaliteField.getText(); 
    }
    
    /**
     * Récupère les coordonnées GPS saisies.
     * @return Les coordonnées GPS
     */
    public String getGPS() { 
        return gpsField.getText(); 
    }
    
    /**
     * Récupère le nombre de chambres saisi.
     * @return Le nombre de chambres
     */
    public int getNbChambres() { 
        return Integer.parseInt(nbChambresField.getText()); 
    }
    
    /**
     * Réinitialise tous les champs de saisie.
     */
    public void clearFields() {
        nomField.setText("");
        directeurField.setText("");
        nationaliteField.setText("");
        gpsField.setText("");
        nbChambresField.setText("");
    }
}