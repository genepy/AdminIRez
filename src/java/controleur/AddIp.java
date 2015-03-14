package controleur;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import beans.BeanAdresseIp;
import traitementForms.FormAddIp;
import traitementBdd.BddAddIp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddIp", urlPatterns = {"/addip"})
public class AddIp extends HttpServlet {

    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/pages/addip.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page d'ajout d'utilisateurs */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Préparation de l'objet formulaire */
        FormAddIp form = new FormAddIp();

        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        BeanAdresseIp toto = form.ajouterIp(request);

        /* ajout en BDD de l'objet ip*/
        BddAddIp addIp = new BddAddIp();
        addIp.storeIp(toto);

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, toto);

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
