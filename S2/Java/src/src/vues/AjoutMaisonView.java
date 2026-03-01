package vues;

import controleurs.MainController;

import javax.swing.*;
import java.awt.*;

/**
 * Vue pour l'ajout d'une nouvelle maison dans l'application CIUP.
 */
public class AjoutMaisonView extends JDialog {
    private MainController controller;
    private JTextField nomField;
    private JTextField directeurField;
    private JTextField nationaliteField;
    private JTextField gpsField;
    private JSpinner nbChambresSpinner;
    
    /**
     * Constructeur de la vue d'ajout de maison.
     * @param controller Le contrôleur principal
     */
    public AjoutMaisonView(MainController controller) {
        super((Frame) null, "Ajouter une maison", true);
        this.controller = controller;
        
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        initialiserComposants();
    }
    
    /**
     * Initialise les composants de la vue.
     */
    private void initialiserComposants() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Champs de saisie
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Nom :"), gbc);
        
        gbc.gridx = 1;
        nomField = new JTextField(20);
        mainPanel.add(nomField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Directeur :"), gbc);
        
        gbc.gridx = 1;
        directeurField = new JTextField(20);
        mainPanel.add(directeurField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Nationalité :"), gbc);
        
        gbc.gridx = 1;
        nationaliteField = new JTextField(20);
        mainPanel.add(nationaliteField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("GPS :"), gbc);
        
        gbc.gridx = 1;
        gpsField = new JTextField(20);
        mainPanel.add(gpsField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Nombre de chambres :"), gbc);
        
        gbc.gridx = 1;
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 1000, 1);
        nbChambresSpinner = new JSpinner(spinnerModel);
        mainPanel.add(nbChambresSpinner, gbc);
        
        // Boutons
        JPanel buttonPanel = new JPanel();
        JButton ajouterButton = new JButton("Ajouter");
        JButton annulerButton = new JButton("Annuler");
        
        ajouterButton.addActionListener(e -> {
            try {
                String nom = nomField.getText().trim();
                String directeur = directeurField.getText().trim();
                String nationalite = nationaliteField.getText().trim();
                String gps = gpsField.getText().trim();
                int nbChambres = (Integer) nbChambresSpinner.getValue();
                
                if (nom.isEmpty() || directeur.isEmpty() || nationalite.isEmpty() || gps.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires !");
                    return;
                }
                
                controller.ajouterMaison(nom, directeur, nationalite, gps, nbChambres);
                dispose();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout : " + ex.getMessage());
            }
        });
        
        annulerButton.addActionListener(e -> dispose());
        
        buttonPanel.add(ajouterButton);
        buttonPanel.add(annulerButton);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);
        
        add(mainPanel);
    }
} 