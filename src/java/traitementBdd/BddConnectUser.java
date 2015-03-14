package traitementBdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class BddConnectUser {

    Utilisateur userBdd = new Utilisateur();

//    private List<String> messages = new ArrayList<String>();
//    List<Map<String, String>> ListeMessage = new ArrayList<Map<String, String>>();
//    Map<String, String> messages = new HashMap<String, String>();
//        public void storeUser(Utilisateur u) {
    public Utilisateur storeUser(HttpServletRequest request) {

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
            resultat = statement.executeQuery("SELECT username='" + request.getAttribute(username) + "' FROM USER");
            System.out.print("Requête sql réalisé");
            /* ---------------------------------------------------------------------------------------------------- */
            while (resultat.next()) {
                String user = resultat.getString("ip");
                String mail = resultat.getString("description");
                /* ajout des parametre dans le bean */
                userBdd.setUsername(user);
                userBdd.setEmail(mail);
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
    }
}
