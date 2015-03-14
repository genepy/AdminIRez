package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import javax.servlet.annotation.WebServlet;
import traitementBdd.BddConnectUser;
import traitementForms.FormConnectUser;

@WebServlet(name = "ConnectUser", urlPatterns = {"/connectuser"})
public class ConnectUser extends HttpServlet {

    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE = "/pages/connexion.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        FormConnectUser form = new FormConnectUser();

        /* Traitement de la requête et récupération du bean en résultant, qu'il faudra comparé au bean avec les data de la bdd */
        Utilisateur utilisateurAValider = form.connecterUtilisateur(request);

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /* ajout en BDD de l'objet test*/
        BddConnectUser test = new BddConnectUser();
        test.storeUser(utilisateurAValider);
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean Utilisateur à la session, sinon suppression du bean de la session.
         */
        if (form.getErreurs().isEmpty()) {
            session.setAttribute(ATT_SESSION_USER, utilisateurAValider);
        } else {
            session.setAttribute(ATT_SESSION_USER, null);
        }


        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, utilisateurAValider);

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
