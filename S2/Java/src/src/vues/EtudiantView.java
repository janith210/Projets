package vues;

import controleurs.MainController;
import modeles.Maison;
import modeles.Etudiant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Vue pour gérer les étudiants d'une maison dans l'application CIUP.
 */
public class EtudiantView {
    private JPanel mainPanel;
    private MainController controller;
    private Maison maison;
    private JTable tableEtudiants;
    private DefaultTableModel tableModel;
    
    /**
     * Constructeur de la vue des étudiants.
     * @param maison La maison concernée
     * @param controller Le contrôleur principal
     */
    public EtudiantView(Maison maison, MainController controller) {
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
        JLabel titre = new JLabel("Étudiants - " + maison.get_nomMaison(), JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titre, BorderLayout.CENTER);
        
        // Bouton retour
        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(e -> {
            // Navigation vers la vue de la maison
            // À implémenter avec le contrôleur
        });
        headerPanel.add(retourButton, BorderLayout.WEST);
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Table des étudiants
        String[] colonnes = {"Nom", "Prénom", "Nationalité", "Date d'arrivée", "Date de départ"};
        tableModel = new DefaultTableModel(colonnes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tableEtudiants = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableEtudiants);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Boutons d'action
        JPanel actionPanel = new JPanel();
        JButton ajouterButton = new JButton("Ajouter un étudiant");
        JButton modifierButton = new JButton("Modifier");
        JButton supprimerButton = new JButton("Supprimer");
        
        ajouterButton.addActionListener(e -> {
            // Ouvrir la vue d'ajout d'étudiant
            // À implémenter
        });
        
        modifierButton.addActionListener(e -> {
            int selectedRow = tableEtudiants.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(mainPanel, "Veuillez sélectionner un étudiant à modifier.");
                return;
            }
            // Ouvrir la vue de modification d'étudiant
            // À implémenter
        });
        
        supprimerButton.addActionListener(e -> {
            int selectedRow = tableEtudiants.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(mainPanel, "Veuillez sélectionner un étudiant à supprimer.");
                return;
            }
            
            int choix = JOptionPane.showConfirmDialog(
                mainPanel,
                "Êtes-vous sûr de vouloir supprimer cet étudiant ?",
                "Confirmation de suppression",
                JOptionPane.YES_NO_OPTION
            );
            
            if (choix == JOptionPane.YES_OPTION) {
                // Supprimer l'étudiant
                // À implémenter avec le contrôleur
            }
        });
        
        actionPanel.add(ajouterButton);
        actionPanel.add(modifierButton);
        actionPanel.add(supprimerButton);
        
        mainPanel.add(actionPanel, BorderLayout.SOUTH);
        
        // Charger les étudiants
        chargerEtudiants();
    }
    
    /**
     * Charge les étudiants dans la table.
     */
    private void chargerEtudiants() {
        tableModel.setRowCount(0);
        for (Etudiant etudiant : maison.getListeEtudiants()) {
            Object[] row = {
                etudiant.get_nom(),
                etudiant.get_prenom(),
                etudiant.get_nationalite(),
                etudiant.get_dateArrivee(),
                etudiant.get_dateDepart()
            };
            tableModel.addRow(row);
        }
    }
    
    /**
     * Retourne le panel principal de la vue.
     * @return Le panel principal
     */
    public JPanel getPanel() {
        return mainPanel;
    }
} 