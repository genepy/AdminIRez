package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import beans.Utilisateur;
//import forms.ConnexionForm;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "Deconnexion", urlPatterns = {"/deconnexion"})
public class Deconnexion extends HttpServlet {

   public static final String URL_REDIRECTION = "http://localhost:8080/AdminIRez";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();

        /* Redirection vers le Site du Zéro ! */
        response.sendRedirect( URL_REDIRECTION );
    }
}