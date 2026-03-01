package vues;

import controleurs.MainController;
import modeles.Maison;

import javax.swing.*;
import java.awt.*;

/**
 * Vue pour afficher les détails d'une maison dans l'application CIUP.
 */
public class MaisonView {
    private JPanel mainPanel;
    private MainController controller;
    private Maison maison;
    
    /**
     * Constructeur de la vue d'une maison.
     * @param maison La maison à afficher
     * @param controller Le contrôleur principal
     */
    public MaisonView(Maison maison, MainController controller) {
        this.maison = maison;
        this.controller = controller;
        this.mainPanel = new JPanel();
        initialiserComposants();
    }
    
    /**
     * Initialise les composants de la vue.
     */
    private void initialiserComposants() {
        mainPanel.setLayout(new BorderLayout());
        
        // En-tête
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titre = new JLabel(maison.get_nomMaison(), JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titre, BorderLayout.CENTER);
        
        // Bouton retour
        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(e -> {
            // Navigation vers la page d'accueil
            // À implémenter avec le contrôleur
        });
        headerPanel.add(retourButton, BorderLayout.WEST);
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Informations de la maison
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Image de la maison
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel imageLabel = new JLabel(new ImageIcon("src/vues/default_maison.jpg"));
        imageLabel.setPreferredSize(new Dimension(300, 200));
        infoPanel.add(imageLabel, gbc);
        
        // Détails de la maison
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        infoPanel.add(new JLabel("Directeur :"), gbc);
        
        gbc.gridx = 1;
        infoPanel.add(new JLabel(maison.get_directeur()), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        infoPanel.add(new JLabel("Nationalité :"), gbc);
        
        gbc.gridx = 1;
        infoPanel.add(new JLabel(maison.get_nationalite()), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        infoPanel.add(new JLabel("GPS :"), gbc);
        
        gbc.gridx = 1;
        infoPanel.add(new JLabel(maison.get_gps()), gbc);
        
        mainPanel.add(infoPanel, BorderLayout.CENTER);
        
        // Boutons d'action
        JPanel actionPanel = new JPanel();
        JButton modifierButton = new JButton("Modifier");
        JButton supprimerButton = new JButton("Supprimer");
        JButton etudiantsButton = new JButton("Gérer les étudiants");
        
        modifierButton.addActionListener(e -> {
            // Ouvrir la vue de modification
            // À implémenter
        });
        
        supprimerButton.addActionListener(e -> {
            int choix = JOptionPane.showConfirmDialog(
                mainPanel,
                "Êtes-vous sûr de vouloir supprimer cette maison ?",
                "Confirmation de suppression",
                JOptionPane.YES_NO_OPTION
            );
            
            if (choix == JOptionPane.YES_OPTION) {
                controller.supprimerMaison(maison.get_nomMaison());
            }
        });
        
        etudiantsButton.addActionListener(e -> {
            // Navigation vers la vue des étudiants
            // À implémenter avec le contrôleur
        });
        
        actionPanel.add(modifierButton);
        actionPanel.add(supprimerButton);
        actionPanel.add(etudiantsButton);
        
        mainPanel.add(actionPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Retourne le panel principal de la vue.
     * @return Le panel principal
     */
    public JPanel getPanel() {
        return mainPanel;
    }
} 