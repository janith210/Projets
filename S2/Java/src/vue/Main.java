package vue;

import javax.swing.*;

import modeles.FactoryCIUP;
import modeles.Maison;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe principale de l'application CIUP (Cité Internationale Universitaire de Paris).
 * Cette classe gère la navigation entre les différentes interfaces utilisateur
 * en utilisant un système de CardLayout pour éviter les fenêtres popup.
 * 
 * @author Pierre Sounouvou
 * Janith Mapitiyage à réaliser la page d'accueil
 * @version 1.0
 */
public class Main extends JFrame implements HomePageMaison.CardClickListener, MaisonUI.DeleteListener{
    private CardLayout cardLayout;
    private JPanel cards;
    private HashMap<String, JPanel> panelMap;
    private JPanel ajoutMaisonPanel;
    private FactoryCIUP fact;
    private AjoutMaisonUI ajoutMaisonUI;
    private HomePageMaison home_page;
    
    private JLabel footer;
    private JPanel menuPanel;
    private JPanel centerPanel;
    private JButton homeButton;
    private JButton ModeButton;
    private JLabel titre;
    
    /**
     * Affiche une carte spécifique dans le layout.
     * @param cardName Le nom de la carte à afficher
     */
    public void showLayoutCard(String cardName) {
        cardLayout.show(cards, cardName);
    }
    
    /**
     * Initialise et démarre l'horloge dans le footer de l'application.
     */
    private void Clock() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Timer timer = new Timer(1000, e -> {
            String time = LocalTime.now().format(dtf);
            footer.setText("Cité International Universitaire - Heure actuelle : " + time);
        });
        timer.start();
    }
    
    /**
     * Constructeur principal de l'application.
     * Initialise tous les composants de l'interface utilisateur et configure
     * le système de navigation par cartes.
     */
    public Main() {
    	//Basiquement pour Avoir un système de navigation correcte (éviter d'avoir des fenêtres
    	//qui popup) on utilise des Panel qui sont associé à des nom on les switches
    	//quand une page est demandé
        setTitle("CIUP");
        setSize(1080, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        panelMap = new HashMap<>();
        
        fact = new FactoryCIUP();
        
        JPanel mainPanel = new JPanel();
        JButton enterApp = new JButton("Entrer dans l'application");
        
        menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        enterApp.setBackground(Color.blue);
        enterApp.setForeground(Color.WHITE);
        enterApp.setFont(new Font("Arial", Font.BOLD, 16));
        enterApp.setMargin(new Insets(10, 20, 10, 20));
        enterApp.setFocusPainted(false);
        enterApp.setContentAreaFilled(true);

        add(menuPanel, BorderLayout.WEST);

        homeButton = new JButton("Entrer");
        homeButton.setPreferredSize(new Dimension(125, 60));

        centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(homeButton);
        add(centerPanel, BorderLayout.CENTER);

        footer = new JLabel("", JLabel.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 12));
        add(footer, BorderLayout.SOUTH);
        Clock();
        
        
        HomePageMaison home_page = new HomePageMaison(this, fact.getListeMaisons());
        JPanel homePagePanel = home_page.HomePageUI_panel();

        cards.add(mainPanel, "Main");
        cards.add(homePagePanel, "HomePage");
        panelMap.put("Main", mainPanel); 
        panelMap.put("HomePage", homePagePanel);
        
        ajoutMaisonUI = new AjoutMaisonUI(e -> {
            try {
                String nom = ajoutMaisonUI.getNom().trim();
                String directeur = ajoutMaisonUI.getDirecteur().trim();
                String nationalite = ajoutMaisonUI.getNationalite().trim();
                String gps = ajoutMaisonUI.getGPS().trim();
                
                int nbChambres = ajoutMaisonUI.getNbChambres();

                Maison nouvelleMaison = new Maison(nom, nationalite, directeur, gps);
                fact.getListeMaisons().add(nouvelleMaison);
                System.out.println("Maison ajoutée : " + nouvelleMaison.get_nomMaison());

                createMaisonPanel(nouvelleMaison);
                createEtudiantPanel(nouvelleMaison); 
                refreshHomePage();

                ajoutMaisonUI.clearFields();

                JOptionPane.showMessageDialog(this, "Maison ajoutée avec succès!");
                showLayoutCard(nom);
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nombre chambre doit etre un int!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
        
        ajoutMaisonPanel = ajoutMaisonUI.getPanel();
        cards.add(ajoutMaisonPanel, "AjoutMaison");
        panelMap.put("AjoutMaison", ajoutMaisonPanel);

        for (Maison maison : fact.getListeMaisons()) {
            createMaisonPanel(maison);
            createEtudiantPanel(maison); 
        }

        enterApp.addActionListener(e -> cardLayout.show(cards, "HomePage"));
        mainPanel.add(enterApp);

        add(cards);
        cardLayout.show(cards, "Main");
        
    }

    /**
     * Crée un panel pour l'interface d'une maison spécifique.
     * @param maison La maison pour laquelle créer le panel
     */
    private void createMaisonPanel(Maison maison) {
        MaisonUI maisonUI = new MaisonUI(maison, this, this); 
        JPanel maisonPanel = maisonUI.MaisonUI_panel();
        String cardName = maison.get_nomMaison();
        cards.add(maisonPanel, cardName);
        panelMap.put(cardName, maisonPanel);
    }

    /**
     * Crée un panel pour l'interface d'ajout d'étudiant d'une maison.
     * @param maison La maison pour laquelle créer le panel étudiant
     */
    private void createEtudiantPanel(Maison maison) {
        EtudiantUI etudiantUI = new EtudiantUI(this); 
        etudiantUI.SetMaison(maison);
        JPanel etudiantPanel = etudiantUI.getEtudiantPanel();
        
        String cardName = "EtudiantUI_" + maison.get_nomMaison();
        cards.add(etudiantPanel, cardName);
        panelMap.put(cardName, etudiantPanel);
        
        System.out.println("Ajout carte EtudiantUI: " + cardName);
    }
    
    /**
     * Crée le panel pour la Maison Internationale.
     */
    private void createMaisonInternationalPanel() {
    	//Créer la maison International
        String cardName = "MaisonInternational";
        if (!panelMap.containsKey(cardName)) {
            try {
                MaisonInternationalUI mi = new MaisonInternationalUI(this, fact.getMaisonInternational());
                JPanel miPanel = mi.creerPanelPrincipal();
                cards.add(miPanel, cardName);
                panelMap.put(cardName, miPanel);
                System.out.println("Créer une MaisonInternational");
            } catch (Exception e) {
                System.out.println("Erreur création Maisoninternational: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("MaisonInternational existe déjà");
        }
    }
    
    /**
     * Supprime une maison de l'application par son nom.
     * @param nomMaison Le nom de la maison à supprimer
     */
    public void removeMaison(String nomMaison) {
    	//Enlerver une maison par son nom
        fact.getListeMaisons().removeIf(maison -> maison.get_nomMaison().equals(nomMaison));
        
        String maisonCardName = nomMaison;
        String etudiantCardName = "EtudiantUI_" + nomMaison;
        if (panelMap.containsKey(maisonCardName)) {
            cards.remove(panelMap.get(maisonCardName));
            panelMap.remove(maisonCardName);
        }
        
        if (panelMap.containsKey(etudiantCardName)) {
            cards.remove(panelMap.get(etudiantCardName));
            panelMap.remove(etudiantCardName);
        }

        refreshHomePage();
        cardLayout.show(cards, "HomePage");
        
        System.out.println("Maison supprimée: " + nomMaison);
        System.out.println("Cartes disponibles après suppression: " + panelMap.keySet());
    }
    
    /**
     * Interface pour écouter les suppressions de maisons.
     */
    public interface MaisonDeletionListener {
        /**
         * Méthode appelée quand une maison est supprimée.
         * @param nomMaison Le nom de la maison supprimée
         */
        void onMaisonDeleted(String nomMaison);
    }

    /**
     * Rafraîchit la page d'accueil pour refléter les modifications.
     */
    private void refreshHomePage() {
    	//Rafrait la homePage pour avoir les modifs
        if (panelMap.containsKey("HomePage")) {
            cards.remove(panelMap.get("HomePage"));
            panelMap.remove("HomePage");
        }
        
        HomePageMaison homePage = new HomePageMaison(this, fact.getListeMaisons());
        JPanel homePagePanel = homePage.HomePageUI_panel();
        cards.add(homePagePanel, "HomePage");
        panelMap.put("HomePage", homePagePanel);
        
        System.out.println("HomePage rafraichit cartes à: " + panelMap.keySet());
    }

    /**
     * Gère les clics sur les cartes de la page d'accueil.
     * @param cardName Le nom de la carte cliquée
     */
    @Override
    public void onCardClick(String cardName) {
    	//Click des cartes pour HomePage
        System.out.println("Essaye de naviguer: " + cardName);
        System.out.println("Cartes: " + panelMap.keySet());
        
        if (cardName.equals("MaisonInternational")) {
            if (!panelMap.containsKey("MaisonInternational")) {
                createMaisonInternationalPanel();
            }
            cardLayout.show(cards, "MaisonInternational");
            System.out.println("Navigation vers: MaisonInternational");
            return;
        }
        
        if (panelMap.containsKey(cardName)) {
            cardLayout.show(cards, cardName);
            System.out.println("Navigation vers: " + cardName);
            return;
        }
        if (cardName.startsWith("EtudiantUI_")) {
            String maisonName = cardName.substring("EtudiantUI_".length());
            
            Maison targetMaison = null;
            for (Maison maison : fact.getListeMaisons()) {
                if (maison.get_nomMaison().equals(maisonName)) {
                    targetMaison = maison;
                    break;
                }
            }
            
            if (targetMaison != null) {
                createEtudiantPanel(targetMaison);
                cardLayout.show(cards, cardName);
                System.out.println("Créer et Navigation vers: " + cardName);
                return;
            }
        }
        
        System.out.println("Carte pas trouvé: " + cardName);

        if (cardName.equals("HomePage")) {
            try {
                cardLayout.show(cards, "HomePage");
                System.out.println("Erreur");
            } catch (IllegalArgumentException ex) {                
                refreshHomePage();
                cardLayout.show(cards, "HomePage");
            }
        }
    }

    /**
     * Point d'entrée de l'application.
     * @param args Arguments de la ligne de commande
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main fenetre = new Main();
            fenetre.setVisible(true);
        });
    }
}