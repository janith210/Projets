package vue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
//import CiteUniversitaire.*;
import modeles.Etudiant;
import modeles.Maison;

/**
 * Classe représentant l'interface utilisateur pour la gestion d'une maison d'étudiants.
 * Cette classe permet d'afficher les informations d'une maison, de gérer les étudiants,
 * d'accéder aux services de restauration et d'effectuer des opérations administratives.
 * @author Pierre Sounouvou
 */
public class MaisonUI {
    /**
     * Interface pour écouter les événements d'ajout d'étudiant.
     */
    public interface StudentAddedListener {
        /**
         * Méthode appelée lorsqu'un étudiant est ajouté.
         */
        void onStudentAdded();
    }
    
    private JPanel fenetre;
    private JLabel l = new JLabel("");
    private JPanel Information;
    private JButton RestoU;
    private JButton AjoutEtudiant;
    private JButton SupprimerMaison;
    private JButton lst_etud;
    private JButton backToHomeButton; 
    private JPanel panelButton;
    private JScrollPane scrollPane;
    private JPanel listeEtudiantPanel;
    
    private Maison nomMaison;
    private ArrayList<Etudiant> students;
    private HomePageMaison.CardClickListener cardClickListener; 
    private DeleteListener DeleteListener; 
    
    /**
     * Interface pour écouter les événements de suppression de maison.
     */
    public interface DeleteListener {
        /**
         * Méthode appelée pour supprimer une maison.
         * @param nomMaison le nom de la maison à supprimer
         */
        void removeMaison(String nomMaison);
    }
    
    /**
     * Définit la maison à afficher dans l'interface.
     * @param m la maison à afficher
     */
    public void setMaison(Maison m) {this.nomMaison = m;}

    /**
     * Applique un style personnalisé à un bouton.
     * @param bouton le bouton à styliser
     * @param couleur la couleur de fond du bouton
     */
    private void style_boutton(JButton bouton, Color couleur) {
        bouton.setBackground(couleur);
        bouton.setForeground(Color.WHITE);
        bouton.setFont(new Font("Arial", Font.BOLD, 16));
        bouton.setMargin(new Insets(10, 20, 10, 20));
        bouton.setFocusPainted(false);
        bouton.setContentAreaFilled(true);
    }    

    /**
     * Génère et affiche la liste des étudiants de la maison.
     */
    public void liste_etudiant() {
        listeEtudiantPanel = new JPanel();
        listeEtudiantPanel.setLayout(new BoxLayout(listeEtudiantPanel, BoxLayout.Y_AXIS));
        listeEtudiantPanel.setBackground(Color.WHITE);
        listeEtudiantPanel.add(new JLabel("Liste des étudiants"));

        this.students = nomMaison.getEtudiants();

        for (Etudiant student : students) {
            JPanel etudiantInfo = new JPanel(new GridLayout(1, 1));
            etudiantInfo.setBackground(Color.BLACK);
            etudiantInfo.setBorder(new EmptyBorder(10, 20, 10, 20));

            JLabel label = new JLabel("Prénom: " + student.get_nomEtudiant() + 
"   |   Nom: " + student.get_prenomEtudiant() + 
                                   "   |   Nationalité: " + student.get_nationaliteEtudiant(), 
                                    SwingConstants.CENTER);
            label.setForeground(Color.WHITE);
            etudiantInfo.add(label);

            listeEtudiantPanel.add(etudiantInfo);
        }

        scrollPane = new JScrollPane(listeEtudiantPanel);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    /**
     * Rafraîchit la liste des étudiants affichée.
     */
    public void refreshEtudiantList() {
        updateStudentCount();
        
        // Recreer la liste etudiant
        liste_etudiant();
        
        if (scrollPane != null) {
            boolean wasVisible = scrollPane.isVisible();
            fenetre.remove(scrollPane);
            fenetre.add(scrollPane, BorderLayout.SOUTH);
            scrollPane.setVisible(wasVisible);
            fenetre.revalidate();
            fenetre.repaint();
        }
    }

    /**
     * Met à jour l'affichage du nombre d'étudiants dans le panneau d'information.
     */
    private void updateStudentCount() {
        this.students = nomMaison.getEtudiants();
        // trouver et mettre à jour l'étiquette du nombre d'étudiants dans le panneau d'information
        Component[] components = ((JPanel) Information.getComponent(1)).getComponents();
        for (Component comp : components) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                if (label.getText().startsWith("Nombre Etudiant:")) {
                    label.setText("Nombre Etudiant: " + students.size());
                    break;
                }
            }
        }
    }

    /**
     * Ajoute les boutons principaux à l'interface et configure leurs actions.
     */
    public void add_main_button() {
        panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        RestoU = new JButton("Resto U/Cafet");
        AjoutEtudiant = new JButton("Ajout d'étudiant");
        SupprimerMaison = new JButton("Supprimer la maison");
        lst_etud = new JButton("Rafraichir liste étudiants");
        backToHomeButton = new JButton("← Retour à l'accueil"); 

        style_boutton(RestoU, new Color(0, 70, 200));
        style_boutton(AjoutEtudiant, Color.BLACK);
        style_boutton(SupprimerMaison, Color.RED);
        style_boutton(lst_etud, Color.BLACK);
        style_boutton(backToHomeButton, new Color(0, 128, 0));

        // Ecouteurs
        RestoU.addActionListener(e -> {
            RestoUInterface restoInterface = new RestoUInterface(nomMaison, null);
            restoInterface.setVisible(true);
        });

        AjoutEtudiant.addActionListener(e -> {
            if (cardClickListener != null) {
                // Navigue vers Maison
                String etudiantCardName = "EtudiantUI_" + nomMaison.get_nomMaison();
                cardClickListener.onCardClick(etudiantCardName);
            } else {
                JFrame etudiantFrame = new JFrame("Ajouter Étudiant - " + nomMaison.get_nomMaison());
                EtudiantUI etudiantUI = new EtudiantUI();
                etudiantUI.SetMaison(nomMaison);
                
                etudiantFrame.setContentPane(etudiantUI.getEtudiantPanel());
                etudiantFrame.setSize(700, 500);
                etudiantFrame.setLocationRelativeTo(fenetre);
                etudiantFrame.setVisible(true);
            }
        });

        SupprimerMaison.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                fenetre, 
                "Êtes-vous sûr de vouloir supprimer cette maison ?", 
                "Confirmation", 
                JOptionPane.YES_NO_OPTION
            );
            if (result == JOptionPane.YES_OPTION) {
                if (DeleteListener != null) {
                    DeleteListener.removeMaison(nomMaison.get_nomMaison());
                }

                if (cardClickListener != null) {
                    cardClickListener.onCardClick("HomePage");
                }
            }
        });

        lst_etud.addActionListener(e -> {
            if (scrollPane.isVisible()) {
                scrollPane.setVisible(false);
                refreshEtudiantList();
                scrollPane.setVisible(true);
            } else {
                refreshEtudiantList();
                scrollPane.setVisible(true);
            }
            fenetre.revalidate();
            fenetre.repaint();
        });

        backToHomeButton.addActionListener(e -> {
            if (cardClickListener != null) {
                cardClickListener.onCardClick("HomePage");
            }
        });

        panelButton.add(backToHomeButton); 
        panelButton.add(RestoU);
        panelButton.add(AjoutEtudiant);
        panelButton.add(SupprimerMaison);
        panelButton.add(lst_etud);
    }

    /**
     * Retourne le panel principal de l'interface.
     * @return le panel principal
     */
    public JPanel MaisonUI_panel() {
        return this.fenetre;
    }
    
    /**
     * Définit le listener pour les événements de suppression.
     * @param listener le listener à définir
     */
    public void setDeleteListener(DeleteListener listener) {
        this.DeleteListener = listener;
    }
    
    /**
     * Constructeur de l'interface MaisonUI.
     * @param m la maison à afficher
     * @param listener le listener pour les événements de clic sur les cartes
     * @param deleteListener le listener pour les événements de suppression
     */
    public MaisonUI(Maison m, HomePageMaison.CardClickListener listener, DeleteListener deleteListener) {
        this.nomMaison = m;
        this.students = nomMaison.getEtudiants();
        this.cardClickListener = listener; 
        this.DeleteListener = deleteListener;
        
        fenetre = new JPanel();
        fenetre.setLayout(new BorderLayout());

        // Titre principal
        l.setText(m.get_nomMaison());
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 32));
        l.setBorder(new EmptyBorder(20, 0, 20, 0));
        fenetre.add(l, BorderLayout.NORTH);

        Information = new JPanel(new BorderLayout());

        try {
            ImageIcon icon = new ImageIcon("default_maison.jpg"); 
            if (icon.getIconWidth() > 0) {
                Image image = icon.getImage().getScaledInstance(180, 110, Image.SCALE_SMOOTH);
                JLabel drapeau = new JLabel(new ImageIcon(image));
                Information.add(drapeau, BorderLayout.NORTH);
            } else {
                JLabel noImage = new JLabel("Image non trouvée", SwingConstants.CENTER);
                noImage.setPreferredSize(new Dimension(180, 110));
                noImage.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                Information.add(noImage, BorderLayout.NORTH);
            }
        } catch (Exception ex) {
            JLabel noImage = new JLabel("Image non disponible", SwingConstants.CENTER);
            noImage.setPreferredSize(new Dimension(180, 110));
            noImage.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            Information.add(noImage, BorderLayout.NORTH);
        }

        JPanel infos = new JPanel(new GridLayout(6, 1));
        infos.setBackground(Color.BLACK);
        infos.setForeground(Color.WHITE);
        
        infos.add(new JLabel("Directeur: " + m.get_directeurMaison()));
        infos.add(new JLabel("Nationalité: " + m.get_nationaliteMaison()));
        infos.add(new JLabel("Localisation GPS: " + m.get_GPSLocalisationMaison()));
        infos.add(new JLabel("Nombre Etudiant: " + Integer.toString(students.size())));
        infos.add(new JLabel("Nombre de chambre: " + m._NB_MAX_ETUDIANT));
        infos.setBorder(new EmptyBorder(20, 10, 20, 10));

        for (Component comp : infos.getComponents()) {
            if (comp instanceof JLabel) {
                ((JLabel) comp).setForeground(Color.WHITE);
            }
        }

        Information.add(infos, BorderLayout.CENTER);
        Information.setBorder(new EmptyBorder(10, 10, 10, 10));
        Information.setBackground(Color.BLACK);

        fenetre.add(Information, BorderLayout.EAST);
       
        add_main_button();
        fenetre.add(panelButton, BorderLayout.CENTER);

        // Liste des étudiants
        liste_etudiant();
        fenetre.add(scrollPane, BorderLayout.SOUTH);
    }
}