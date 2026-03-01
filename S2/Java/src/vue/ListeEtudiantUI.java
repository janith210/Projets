package vue;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
//import CiteUniversitaire.*;
import modeles.Etudiant;
import modeles.Maison;

public class ListeEtudiantUI extends JFrame {

    Maison maisonlisteetudiant;
    JPanel listeetudiantpannel;

    void SetMaison (Maison maisonlisteetudiant) {
		this.maisonlisteetudiant = maisonlisteetudiant;
	}
    
    // Constructeur modifié pour recevoir la maison
    ListeEtudiantUI() {
    	
        listeetudiantpannel = new JPanel();
        listeetudiantpannel.setLayout(new BorderLayout());
        
        setTitle("Information Etudiant");
        setSize(800, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        if (maisonlisteetudiant == null || maisonlisteetudiant.getEtudiants().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun étudiant dans la maison !");
            dispose();
            return;
        }

        Etudiant etudiant = maisonlisteetudiant.getEtudiants().get(0);

        String[] colonnes = {"Prénom", "Nom", "Nationalité", "Date Naissance", "Etude", "Adresse email"};
        Object[][] donnees = {
            {
                etudiant.get_prenomEtudiant(),
                etudiant.get_nomEtudiant(),
                etudiant.get_nationaliteEtudiant(),
                etudiant.get_datedenaissance(),
                etudiant.get_Etude(),
                etudiant.getEmail()
            }
        };

        DefaultTableModel model = new DefaultTableModel(donnees, colonnes);
        JTable table = new JTable(model);
        table.setBackground(Color.LIGHT_GRAY);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        table.setEnabled(false);
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
            .setHorizontalAlignment(JLabel.CENTER);

        JLabel titre = new JLabel("Information Etudiant", JLabel.CENTER);
        titre.setFont(new Font("SansSerif", Font.BOLD, 16));
        titre.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        setLayout(new BorderLayout());
        add(titre, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
    public JPanel getListeEtudiantPanel() {
    	return listeetudiantpannel;
    }

    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	JFrame frame = new JFrame("Interface Étudiant");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);

            // Créer une instance de EtudiantUI
            ListeEtudiantUI ui = new ListeEtudiantUI();
            
            FactoryCIUP fi = new FactoryCIUP();
            
            ui.SetMaison(fi.getListeMaisons().get(0));
            
            // Récupérer le panel et l'ajouter à la fenêtre
            frame.setContentPane(ui.getListeEtudiantPanel());

            // Afficher la fenêtre
            frame.setVisible(true);
        });
    }
    */
}
