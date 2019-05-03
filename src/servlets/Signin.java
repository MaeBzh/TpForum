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

public class Signin extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Inscription");
        this.getServletContext().getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setPseudo(request.getParameter("pseudo"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setRoleId(2);

        try {
            UserRepository.insert(user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("connectedUser", user);
        this.getServletContext().getRequestDispatcher("/WEB-INF/showCategory.jsp").forward(request, response);
    }
}
