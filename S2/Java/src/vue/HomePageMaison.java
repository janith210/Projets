package vue;

import javax.swing.*;

import modeles.Maison;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Interface principale pour afficher la liste des maisons de la Cité Universitaire.
 * Cette classe gère l'affichage sous forme de cartes cliquables et permet la navigation
 * vers les différentes maisons ainsi que l'ajout de nouvelles maisons.
 * 
 * @author Pierre Sounouvou
 * @version 1.0
 */
public class HomePageMaison {
    private JPanel frame;
    private CardClickListener listener;
    private ArrayList<Maison> maisons;
    
    /**
     * Interface pour gérer les clics sur les cartes des maisons.
     */
    public interface CardClickListener {
        /**
         * Méthode appelée lors du clic sur une carte.
         * @param cardName Le nom de la carte cliquée
         */
        void onCardClick(String cardName);
    }
    
    /**
     * Retourne la liste des maisons.
     * @return ArrayList contenant toutes les maisons
     */
    public ArrayList<Maison> getListMaison(){return this.maisons;}
    
    /**
     * Constructeur de la page d'accueil des maisons.
     * @param listener L'écouteur pour les clics sur les cartes
     * @param maisons La liste des maisons à afficher
     */
    public HomePageMaison(CardClickListener listener, ArrayList<Maison> maisons) {
        this.listener = listener;
        this.maisons = maisons;
        frame = new JPanel(new BorderLayout());
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel("Listes des Maisons");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        
        JButton addButton = new JButton("Ajouter une maison");
        addButton.addActionListener(e -> listener.onCardClick("AjoutMaison"));
        addButton.setBackground(new Color(0, 200, 0));
        addButton.setForeground(Color.WHITE);
        topPanel.add(title);
        topPanel.add(addButton);
        frame.add(topPanel, BorderLayout.NORTH);
        
        JPanel housePanel = new JPanel(new GridLayout(0, 3, 20, 20));
        housePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Add regular maisons
        for (Maison maison : maisons) {
            housePanel.add(createHouseCard(maison.get_nomMaison(), getImagePathForMaison(maison)));
        }
        
        housePanel.add(createHouseCard("MaisonInternational", "international_maison.jpg"));
                
        frame.add(housePanel, BorderLayout.CENTER);
    }
    
    /**
     * Retourne le chemin de l'image pour une maison donnée.
     * @param maison La maison pour laquelle récupérer l'image
     * @return Le chemin vers l'image par défaut
     */
    private String getImagePathForMaison(Maison maison) {
        return "default_maison.jpg";
    }
    
    /**
     * Retourne le panel principal de l'interface.
     * @return Le JPanel contenant toute l'interface
     */
    public JPanel HomePageUI_panel() {
        return this.frame;
    }
    
    /**
     * Crée une carte cliquable pour une maison.
     * @param name Le nom de la maison
     * @param imagePath Le chemin vers l'image de la maison
     * @return Un JPanel représentant la carte de la maison
     */
    private JPanel createHouseCard(String name, String imagePath) {
        JPanel panel = new JPanel(new BorderLayout());
        
        // On devait avoir des images mais les icons ne fonctionnent pas
        ImageIcon icon;
        try {
            icon = new ImageIcon(imagePath);
        } catch (Exception e) {
            icon = createDefaultIcon(name);
        }
        
        Image img = icon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(nameLabel, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (listener != null) {
                    listener.onCardClick(name);
                }
            }
        });
        
        return panel;
    }
    
    /**
     * Crée une icône par défaut pour une maison quand l'image n'est pas disponible.
     * @param name Le nom de la maison pour personnaliser l'icône
     * @return Une ImageIcon générée par défaut
     */
    private ImageIcon createDefaultIcon(String name) {
        // Create a simple colored rectangle as default image
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(200, 130, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        
        // 
        if (name.equals("MaisonInternational")) {
            g2d.setColor(new Color(70, 130, 180));
        } else {
            g2d.setColor(new Color(100, 149, 237));
        }
        
        g2d.fillRect(0, 0, 200, 130);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(name);
        int textHeight = fm.getHeight();
        
        g2d.drawString(name, (200 - textWidth) / 2, (130 + textHeight) / 2);
        g2d.dispose();
        
        return new ImageIcon(img);
    }
}