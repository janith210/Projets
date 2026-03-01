package vue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//import CiteUniversitaire.*;
import modeles.Maison;
import modeles.MaisonInternational;
import modeles.RestoU;

/**
 * Interface graphique pour afficher les menus du restaurant universitaire.
 * Permet d'afficher les menus normaux et végétariens (si disponibles) 
 * pour chaque jour de la semaine.
 * @author Janith Mapitiyage
 */
public class RestoUInterface extends JFrame {
    private Maison maison;
    private MaisonInternational maisonInternational;
    private JPanel panelPrincipal;
    private boolean isVegetarian = false;
    private boolean hasVegetarianMenu = false;

    /**
     * Constructeur de l'interface RestoU.
     * @param m La maison étudiante (peut être null)
     * @param mi La maison internationale (utilisée si m est null)
     */
    public RestoUInterface(Maison m, MaisonInternational mi) {
        setTitle("Restaurant U / Cafeteria - Menu spécifications");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);

        JLabel titre = new JLabel("Restaurant U / Cafeteria - Menu spécifications", JLabel.CENTER);
        titre.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(titre, BorderLayout.NORTH);
        
        panelPrincipal = new JPanel(new GridLayout(1, 5, 10, 10));
        RestoU resto;
        if(m == null) {
            this.maisonInternational = mi;
            resto = mi.get_RestoU();
        } else {
            this.maison = m;
            resto = maison.getRestoU();            
        }

        ArrayList<String> jours = resto._nom_jour_semaine;
        ArrayList<ArrayList<String>> menu = resto.getMenu();

        hasVegetarianMenu = menu.size() > 1;

        updateMenuDisplay(jours, menu);

        add(panelPrincipal, BorderLayout.CENTER);

        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnRetour = new JButton("Retour");
        JButton btnToggleMenu = new JButton(hasVegetarianMenu ? "Normal/Vege" : "Normal");

        btnToggleMenu.addActionListener(e -> {
            if (hasVegetarianMenu) {
                isVegetarian = !isVegetarian;
                updateMenuDisplay(jours, menu);
                btnToggleMenu.setText(isVegetarian ? "Vege" : "Normal");
                titre.setText("Restaurant U / Cafeteria - Menu spécifications " + (isVegetarian ? "(Végétarien)" : ""));
            }
        });

        panelBoutons.add(btnToggleMenu);
        panelBoutons.add(btnRetour);
        btnRetour.addActionListener(e -> dispose()); 

        add(panelBoutons, BorderLayout.SOUTH);
    }

    /**
     * Met à jour l'affichage du menu en fonction du type sélectionné (normal ou végétarien).
     * @param jours La liste des jours de la semaine
     * @param menu La liste des menus (normal et végétarien si disponible)
     */
    private void updateMenuDisplay(ArrayList<String> jours, ArrayList<ArrayList<String>> menu) {
        panelPrincipal.removeAll();
        int menuIndex = isVegetarian && hasVegetarianMenu ? 1 : 0;

        for (int i = 0; i < jours.size(); i++) {
            ArrayList<String> menuItems = split(menu.get(menuIndex).get(i));
            if (menuItems.size() >= 3) {
                panelPrincipal.add(creerJourPanel(jours.get(i), menuItems.get(0), menuItems.get(1), menuItems.get(2)));
            }
        }
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    /**
     * Sépare une chaîne de caractères en une liste de mots.
     * @param s La chaîne à séparer
     * @return ArrayList contenant les mots séparés
     */
    private ArrayList<String> split(String s) {
        ArrayList<String> split = new ArrayList<>();
        StringBuilder tempo = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                tempo.append(s.charAt(i));
            } else {
                if (!tempo.isEmpty()) {
                    split.add(tempo.toString());
                    tempo.setLength(0);
                }
            }
        }
        if (!tempo.isEmpty()) {
            split.add(tempo.toString());
        }
        return split;
    }

    /**
     * Crée un panneau affichant le menu d'un jour particulier.
     * @param jour Le nom du jour
     * @param entree L'entrée du menu
     * @param plat Le plat principal
     * @param dessert Le dessert
     * @return JPanel configuré pour afficher le menu du jour
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