package src;

import controleurs.MainController;

/**
 * Classe principale de l'application CIUP.
 * Point d'entrée de l'application.
 */
public class Main {
    /**
     * Point d'entrée de l'application.
     * @param args Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        try {
            // Utilisation du look and feel système
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Création et démarrage de l'application
        SwingUtilities.invokeLater(() -> {
            MainController controller = new MainController();
            controller.demarrer();
        });
    }
} 