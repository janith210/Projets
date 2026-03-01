package vues;

import controleurs.MainController;
import modeles.Maison;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Vue de la page d'accueil de l'application CIUP.
 * Affiche les cartes des différentes maisons et permet la navigation.
 */
public class HomePageView {
    private JPanel mainPanel;
    private MainController controller;
    
    /**
     * Constructeur de la vue de la page d'accueil.
     * @param controller Le contrôleur principal
     */
    public HomePageView(MainController controller) {
        this.controller = controller;
        this.mainPanel = new JPanel();
        initialiserComposants();
    }
    
    /**
     * Initialise les composants de la page d'accueil.
     */
    private void initialiserComposants() {
        mainPanel.setLayout(new BorderLayout());
        
        // Titre
        JLabel titre = new JLabel("Cité Internationale Universitaire de Paris", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titre, BorderLayout.NORTH);
        
        // Panel pour les cartes
        JPanel cardsPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Ajout des cartes pour chaque maison
        for (Maison maison : controller.getListeMaisons()) {
            JPanel card = creerCarteMaison(maison);
            cardsPanel.add(card);
        }
        
        // Ajout de la carte pour la maison internationale
        JPanel cardInternational = creerCarteMaisonInternational();
        cardsPanel.add(cardInternational);
        
        // Ajout du bouton pour ajouter une nouvelle maison
        JButton ajouterButton = new JButton("Ajouter une maison");
        ajouterButton.addActionListener(e -> {
            AjoutMaisonView ajoutView = new AjoutMaisonView(controller);
            ajoutView.setVisible(true);
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(ajouterButton);
        
        mainPanel.add(cardsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Crée une carte pour une maison.
     * @param maison La maison à afficher
     * @return Le panel représentant la carte
     */
    private JPanel creerCarteMaison(Maison maison) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Image de la maison (placeholder)
        JLabel imageLabel = new JLabel(new ImageIcon("src/vues/default_maison.jpg"));
        imageLabel.setPreferredSize(new Dimension(200, 150));
        card.add(imageLabel, BorderLayout.CENTER);
        
        // Informations de la maison
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        JLabel nomLabel = new JLabel(maison.get_nomMaison(), JLabel.CENTER);
        JLabel nationaliteLabel = new JLabel(maison.get_nationalite(), JLabel.CENTER);
        
        nomLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nationaliteLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        
        infoPanel.add(nomLabel);
        infoPanel.add(nationaliteLabel);
        card.add(infoPanel, BorderLayout.SOUTH);
        
        // Ajout de l'effet de survol
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(new Color(240, 240, 240));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(Color.WHITE);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                // Navigation vers la vue de la maison
                // À implémenter avec le contrôleur
            }
        });
        
        return card;
    }
    
    /**
     * Crée la carte pour la maison internationale.
     * @return Le panel représentant la carte
     */
    private JPanel creerCarteMaisonInternational() {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Image de la maison internationale (placeholder)
        JLabel imageLabel = new JLabel(new ImageIcon("src/vues/default_maison.jpg"));
        imageLabel.setPreferredSize(new Dimension(200, 150));
        card.add(imageLabel, BorderLayout.CENTER);
        
        // Informations de la maison internationale
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        JLabel nomLabel = new JLabel("Maison Internationale", JLabel.CENTER);
        JLabel descriptionLabel = new JLabel("Centre de la CIUP", JLabel.CENTER);
        
        nomLabel.setFont(new Font("Arial", Font.BOLD, 16));
        descriptionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        
        infoPanel.add(nomLabel);
        infoPanel.add(descriptionLabel);
        card.add(infoPanel, BorderLayout.SOUTH);
        
        // Ajout de l'effet de survol
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(new Color(240, 240, 240));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(Color.WHITE);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                // Navigation vers la vue de la maison internationale
                // À implémenter avec le contrôleur
            }
        });
        
        return card;
    }
    
    /**
     * Retourne le panel principal de la vue.
     * @return Le panel principal
     */
    public JPanel getPanel() {
        return mainPanel;
    }
} 