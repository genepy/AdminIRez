package controleur;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
import traitementBdd.BddListIp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListIp", urlPatterns = {"/listip"})
public class ListIp extends HttpServlet {

    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "/pages/listip.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         /* Initialisation de l'objet Java et récupération des messages */
        BddListIp listIp = new BddListIp();
        List<String> messages = listIp.viewIp(request);

        /* Enregistrement de la liste des messages dans l'objet requête */
        request.setAttribute(ATT_MESSAGES, messages);

        /* Transmission vers la page en charge de l'affichage des résultats */
        
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        /* Préparation de l'objet formulaire */
////        FormAddIp form = new FormAddIp();
//
//        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
////        BeanAdresseIp toto = form.ajouterIp(request);
//        /* récupération de la table dans la BDD */
//        BddListIp listIp = new BddListIp();
//        listIp.viewIp();
//
//        /* Stockage du formulaire et du bean dans l'objet request */
////        request.setAttribute(ATT_FORM, form);
//        request.setAttribute(ATT_USER, listIp);
//
//        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
//    }
}
