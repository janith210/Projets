package vues;

import controleurs.MainController;
import modeles.Maison;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Vue principale de l'application CIUP.
 * Gère l'interface graphique et la navigation entre les différentes vues.
 */
public class MainView extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;
    private HashMap<String, JPanel> panelMap;
    private MainController controller;
    private JLabel footer;
    
    /**
     * Constructeur de la vue principale.
     * @param controller Le contrôleur principal
     */
    public MainView(MainController controller) {
        this.controller = controller;
        this.panelMap = new HashMap<>();
        
        setTitle("CIUP");
        setSize(1080, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initialiserComposants();
        configurerHorloge();
        creerVuesInitiales();
    }
    
    /**
     * Initialise les composants de base de l'interface.
     */
    private void initialiserComposants() {
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        
        JPanel mainPanel = new JPanel();
        JButton enterApp = new JButton("Entrer dans l'application");
        configurerBoutonEntree(enterApp);
        
        mainPanel.add(enterApp);
        cards.add(mainPanel, "Main");
        panelMap.put("Main", mainPanel);
        
        add(cards);
        cardLayout.show(cards, "Main");
    }
    
    /**
     * Configure le bouton d'entrée dans l'application.
     */
    private void configurerBoutonEntree(JButton button) {
        button.setBackground(Color.blue);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setMargin(new Insets(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.addActionListener(e -> cardLayout.show(cards, "HomePage"));
    }
    
    /**
     * Configure l'horloge dans le footer.
     */
    private void configurerHorloge() {
        footer = new JLabel("", JLabel.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 12));
        add(footer, BorderLayout.SOUTH);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Timer timer = new Timer(1000, e -> {
            String time = LocalTime.now().format(dtf);
            footer.setText("Cité International Universitaire - Heure actuelle : " + time);
        });
        timer.start();
    }
    
    /**
     * Crée les vues initiales de l'application.
     */
    private void creerVuesInitiales() {
        HomePageView homePage = new HomePageView(controller);
        JPanel homePagePanel = homePage.getPanel();
        cards.add(homePagePanel, "HomePage");
        panelMap.put("HomePage", homePagePanel);
        
        for (Maison maison : controller.getListeMaisons()) {
            creerVueMaison(maison);
            creerVueEtudiant(maison);
        }
    }
    
    /**
     * Crée une vue pour une maison.
     * @param maison La maison à afficher
     */
    public void creerVueMaison(Maison maison) {
        MaisonView maisonView = new MaisonView(maison, controller);
        JPanel maisonPanel = maisonView.getPanel();
        String cardName = maison.get_nomMaison();
        cards.add(maisonPanel, cardName);
        panelMap.put(cardName, maisonPanel);
    }
    
    /**
     * Crée une vue pour les étudiants d'une maison.
     * @param maison La maison concernée
     */
    public void creerVueEtudiant(Maison maison) {
        EtudiantView etudiantView = new EtudiantView(maison, controller);
        JPanel etudiantPanel = etudiantView.getPanel();
        String cardName = "EtudiantUI_" + maison.get_nomMaison();
        cards.add(etudiantPanel, cardName);
        panelMap.put(cardName, etudiantPanel);
    }
    
    /**
     * Supprime les vues associées à une maison.
     * @param nomMaison Nom de la maison à supprimer
     */
    public void supprimerVueMaison(String nomMaison) {
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
    }
    
    /**
     * Rafraîchit la page d'accueil.
     */
    public void rafraichirHomePage() {
        if (panelMap.containsKey("HomePage")) {
            cards.remove(panelMap.get("HomePage"));
            panelMap.remove("HomePage");
        }
        
        HomePageView homePage = new HomePageView(controller);
        JPanel homePagePanel = homePage.getPanel();
        cards.add(homePagePanel, "HomePage");
        panelMap.put("HomePage", homePagePanel);
    }
} 