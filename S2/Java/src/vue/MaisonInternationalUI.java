package vue;

import javax.swing.*;

//import CiteUniversitaire.*;
import modeles.MaisonInternational;

import java.awt.*;

/**
 * Interface utilisateur pour la Maison Internationale.
 * Cette classe gère l'affichage des services disponibles dans la Maison Internationale
 * comme le restaurant universitaire, la piscine, le théâtre, la bibliothèque et l'administration.
 * 
 * @author Jimmy Zheng
 * @version 1.0
 */
public class MaisonInternationalUI {
	private HomePageMaison.CardClickListener cardClickListener;
	private MaisonInternational MaisonInternational;
	
    /**
     * Constructeur de l'interface de la Maison Internationale.
     * @param listener L'écouteur pour les clics sur les cartes
     * @param maisonInternational L'instance de la Maison Internationale
     */
    public MaisonInternationalUI(HomePageMaison.CardClickListener listener, MaisonInternational maisonInternational) {
        // Constructor can be empty since we're not creating a JFrame anymore
        // The panel creation is handled by creerPanelPrincipal()
    	this.cardClickListener = listener;
    	this.MaisonInternational = maisonInternational;
    }

    /**
     * Crée le panel principal de l'interface de la Maison Internationale.
     * @return Le JPanel contenant tous les éléments de l'interface
     */
    public JPanel creerPanelPrincipal() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Titre
        JLabel title = new JLabel("Maison Internationale");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(title);

        // Boutton
        JButton btnResto = new JButton("Resto U/Cafet");
        btnResto.setBackground(new Color(25, 50, 180));
        btnResto.setForeground(Color.WHITE);
        btnResto.setPreferredSize(new Dimension(180, 35));
        btnResto.setMaximumSize(new Dimension(180, 35));
        btnResto.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(btnResto);


        JLabel serviceLabel = new JLabel("Les listes des services :");
        serviceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        serviceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(serviceLabel);

        // Services
        JPanel grid = new JPanel(new GridLayout(2, 2, 30, 20));
        grid.setMaximumSize(new Dimension(400, 150));
        grid.setBackground(Color.WHITE);

        JButton btnPiscine = new JButton("Piscine");
        btnPiscine.setBackground(new Color(129, 212, 250));
        btnPiscine.setForeground(Color.WHITE);
        grid.add(btnPiscine);

        JButton btnTheatre = new JButton("Théâtre");
        btnTheatre.setBackground(new Color(198, 40, 40));
        btnTheatre.setForeground(Color.WHITE);
        grid.add(btnTheatre);

        JButton btnBiblio = new JButton("Bibliothèque");
        btnBiblio.setBackground(new Color(141, 110, 99));
        btnBiblio.setForeground(Color.WHITE);
        grid.add(btnBiblio);

        JButton btnAdmin = new JButton("Administration");
        btnAdmin.setBackground(Color.RED);
        btnAdmin.setForeground(Color.WHITE);
        grid.add(btnAdmin);
        
        JButton btnRetour = new JButton("← Retour à l'accueil");
        btnRetour.setBackground(new Color(200, 50, 50));  
        btnRetour.setForeground(Color.WHITE);
        btnRetour.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); 
        btnRetour.setFocusPainted(false);  
        btnRetour.setFont(new Font("Arial", Font.PLAIN, 12));
        btnRetour.addActionListener(e -> {
            if (cardClickListener != null) {
                cardClickListener.onCardClick("HomePage");
            }
        });
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(Color.WHITE);
        topPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));  
        topPanel.add(btnRetour);
        
        centerPanel.add(topPanel, 0);  
        centerPanel.add(Box.createVerticalStrut(10));          
        
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(grid);
        

        btnResto.addActionListener(e -> {
            	//nomMaison.afficheRestoU();
        		//Maison m = new Maison(null, null, null, null);
        		RestoUInterface restoInterface = new RestoUInterface(null, MaisonInternational);
                
                restoInterface.setVisible(true);
                //RestoUVege restoInterface = new RestoUVege();
        });
        
        btnPiscine.addActionListener(e -> new PiscineUI().setVisible(true));
        btnTheatre.addActionListener(e -> new TheatreUI().setVisible(true));
        btnBiblio.addActionListener(e -> new BibliothequeUI().setVisible(true));
        btnAdmin.addActionListener(e -> new AdministrationUI().setVisible(true));

        
        //backToHomeButton.addActionListener(e -> {
        //    if (cardClickListener != null) {
        //        cardClickListener.onCardClick("HomePage");
        //    }
        //});

        return centerPanel;
    }
}