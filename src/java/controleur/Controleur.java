////toto
//
//package controleur;
//
//import java.io.IOException;
//import java.io.PrintWriter;
////import java.io.PrintWriter;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import static java.lang.System.out;
//
//
//@WebServlet(name = "Controleur", urlPatterns = {"/controleur/*"})
//public class Controleur extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try (PrintWriter out = response.getWriter()) {
//
//            
//            // test test test
//            String url = request.getRequestURI();
////            out.println(request.getRequestURL());
//            url = request.getRequestURL().toString();
////            out.println(url);
//            if (url.endsWith("creaClient")) {
//                RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/test/creaClient.jsp");
//                disp.forward(request, response);
//            } else if (url.endsWith("creaCommande")) {
//                RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/test/creaCommande.jsp");
//                disp.forward(request, response);
//            } else if (url.endsWith("afficheClient")) {
//                RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/test/afficheClient.jsp");
//                disp.forward(request, response);
//            } else if (url.endsWith("afficheCommande")) {
//                RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/test/afficheCommande.jsp");
//                disp.forward(request, response);
//            } else if (url.endsWith("addUser")) {
//                RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/WEB-INF/user/addUser.jsp");
//                disp.forward(request, response);
//            } else if (url.endsWith("suppUser")) {
//                RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/WEB-INF/user/suppUser.jsp");
//                disp.forward(request, response);
//            } else {
//                RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/index.html");
//                disp.forward(request, response);
//            }
//        // test test test
//
//            
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//}
