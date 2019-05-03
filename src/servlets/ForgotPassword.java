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

public class ForgotPassword extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Mot de passe oublié ?");
        this.getServletContext().getRequestDispatcher("/WEB-INF/forgot_password.jsp").forward(request, response);    }


}
