package servlets;

import beans.User;
import repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Connexion");
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        try {
            user = UserRepository.checkCredentials(request.getParameter("pseudo"), request.getParameter("password"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("connectedUser", user);
        }
        response.sendRedirect("category");
//        this.getServletContext().getRequestDispatcher("/WEB-INF/showCategory.jsp").forward(request, response);
    }
}
