package traitementBdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class BddListIp {

    private List<String> messages = new ArrayList<String>();
//    List<Map<String, String>> ListeMessage = new ArrayList<Map<String, String>>();
//    Map<String, String> messages = new HashMap<String, String>();

    public List<String> viewIp(HttpServletRequest request) {

        /* Chargement du driver JDBC pour MySQL */
        try {
            System.out.print("Chargement du driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.print("Driver chargé !");
        } catch (ClassNotFoundException e) {
            System.out.print("Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! ");
        }

        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/adminirez";
        String utilisateurBdd = "root";
        String motDePasseBdd = "root";
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            System.out.print("Connexion à la base de données...");
            connexion = DriverManager.getConnection(url, utilisateurBdd, motDePasseBdd);
            System.out.print("Connexion réussie !");

            /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();
            System.out.print("Objet requête créé !");

            /* ----------------------------------------- Requette SQL --------------------------------------------- */
            /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery("SELECT * FROM IP");
            System.out.print("Requête sql réalisé");
            /* ---------------------------------------------------------------------------------------------------- */
            while (resultat.next()) {
                String ipIP = resultat.getString("ip");
                String descriptioniP = resultat.getString("description");
                /* Formatage des données pour affichage dans la JSP finale. */
//                messages.put(ipIP, descriptioniP);
                
                messages.add(ipIP);
                messages.add(descriptioniP);
            }

        } catch (SQLException e) {
            System.out.print("Erreur lors de la connexion : <br/>"
                    + e.getMessage());
        } finally {
            System.out.print("Fermeture de l'objet ResultSet.");
            if (resultat != null) {
                try {
                    resultat.close();
                } catch (SQLException ignore) {
                }
            }
            System.out.print("Fermeture de l'objet Statement.");
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            System.out.print("Fermeture de l'objet Connection.");
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return messages;
    }
}
