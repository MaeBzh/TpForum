package servlets;

import beans.Message;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateMessage extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Nouveau message");
        this.getServletContext().getRequestDispatcher("/WEB-INF/create_message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message message = new Message();
        message.setContent(request.getParameter("content"));
        message.setDate(DateTime.now());

        request.setAttribute("message", message);

        this.getServletContext().getRequestDispatcher("/WEB-INF/display_message.jsp").forward(request, response);
    }
 }
