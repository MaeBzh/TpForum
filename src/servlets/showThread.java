package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class showThread extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Show Thread");
        request.setAttribute("thrId", request.getParameter("thrId"));
        request.setAttribute("catId", request.getParameter("catId"));
        this.getServletContext().getRequestDispatcher("/WEB-INF/showThread.jsp").forward(request, response);
    }
}
