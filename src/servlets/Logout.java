package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("logout") != null ){
            request.getSession().invalidate();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
