package servlets;

import beans.Message;
import beans.Thread;
import beans.User;
import org.joda.time.DateTime;
import repositories.MessageRepository;
import repositories.ThreadRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewThread extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Nouveau sujet");
        request.setAttribute("catId", request.getParameter("catId"));
        this.getServletContext().getRequestDispatcher("/WEB-INF/new_thread.jsp").forward(request, response);
    }
}
