package traitementBdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.Utilisateur;


public class BddAddUser {

    private static final String CHAMP_USERNAME = "username";
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "password";
    private static final String CHAMP_CONF = "confirmation";

    public void storeUser(Utilisateur u) {
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print("Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>");  
        }

        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/adminirez";
        String utilisateur = "root";
        String motDePasse = "root";
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            System.out.print("Connexion à la base de données...");
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.print("Connexion réussie !");

            /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();
            System.out.print("Objet requête créé !");

            
 /* ----------------------------------------- Requette SQL --------------------------------------------- */
            /* Exécution d'une requête d'écriture */
            int statut = statement.executeUpdate("INSERT INTO USER (username, mail, password) VALUES ('" + u.getUsername() + "', '" + u.getEmail() + "', '" + u.getPassword() + "');");
 
/* ---------------------------------------------------------------------------------------------------- */
            
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
    }
}
