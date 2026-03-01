package vue;

import javax.swing.*;
import java.util.ArrayList;
//import CiteUniversitaire.*;
import modeles.Maison;
import modeles.RestoU;

import java.awt.*;

/**
 * Interface graphique pour afficher le menu végétarien du restaurant universitaire.
 * @author Janith Mapitiyage
 */
public class RestoUVege extends JFrame {
    private Maison maison;
    
    /**
     * Définit la maison associée à ce restaurant.
     * @param m La maison à associer
     */
    public void setMaison(Maison m) {
        maison = m;
    }
    
    /**
     * Constructeur qui initialise l'interface avec le menu végétarien.
     * @param m La maison associée à ce restaurant
     */
    RestoUVege(Maison m) {
        setTitle("Restaurant U / Cafeteriat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);

        // Titre principal
        JLabel titre = new JLabel("Restaurant U / Cafeteriat - Menu sans spécifications (Non Végétarien)", JLabel.CENTER);
        titre.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(titre, BorderLayout.NORTH);
        
        this.maison = m;
        // Conteneur principal
        RestoU resto = maison.getRestoU();
        JPanel panelPrincipal = new JPanel(new GridLayout(1, 5, 10, 10));
        ArrayList<String> jours = resto._nom_jour_semaine;
        
        ArrayList<ArrayList<String>> menu = resto.getMenu();
        String t = resto.getType();
        int indice=0;
        if (t == "normal/vege") {
            indice = 1;
        }
        
        for (int i=0;i<jours.size();i++) {
            panelPrincipal.add(creerJourPanel(jours.get(i), split(menu.get(indice).get(i)).get(0), split(menu.get(indice).get(i)).get(1), split(menu.get(indice).get(i)).get(2)));
        }

        add(panelPrincipal, BorderLayout.CENTER);

        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(e -> dispose()); 
        add(btnRetour, BorderLayout.SOUTH);        
    }
    
    /**
     * Divise une chaîne en mots séparés par des espaces.
     * @param s La chaîne à diviser
     * @return Une liste des mots
     */
    private ArrayList<String> split(String s) {
        ArrayList<String> split = new ArrayList<String>();
        String tempo = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                tempo += s.charAt(i);
            } else {
                if (!tempo.isEmpty()) {
                    split.add(tempo);
                    tempo = "";
                }
            }
        }
        if (!tempo.isEmpty()) {
            split.add(tempo); // ajoute le dernier mot
        }
        return split;
    }

    /**
     * Crée un panel pour afficher le menu d'un jour spécifique.
     * @param jour Le jour de la semaine
     * @param entree L'entrée du menu
     * @param plat Le plat principal
     * @param dessert Le dessert
     * @return Le panel créé
     */
    private JPanel creerJourPanel(String jour, String entree, String plat, String dessert) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(jour));
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        
        JLabel entreeLabel = new JLabel("Entrée:");
        JLabel oeuf = new JLabel(entree);

        JLabel platLabel = new JLabel("Plat:");
        JLabel lasagne = new JLabel(plat);

        JLabel dessertLabel = new JLabel("Dessert:");
        JLabel yaourt = new JLabel(dessert);

        panel.add(entreeLabel);
        panel.add(oeuf);
        panel.add(Box.createVerticalStrut(10));

        panel.add(platLabel);
        panel.add(lasagne);
        panel.add(Box.createVerticalStrut(10));

        panel.add(dessertLabel);
        panel.add(yaourt);

        return panel;
    }
}