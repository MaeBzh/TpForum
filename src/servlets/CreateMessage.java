package servlets;

import beans.Database;
import beans.Message;
import org.joda.time.DateTime;
import repositories.MessageRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMessage extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Nouveau message");
        this.getServletContext().getRequestDispatcher("/WEB-INF/create_message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Message message = new Message();
            message.setContent(request.getParameter("content"));
            message.setDate(DateTime.now());
            message.setAuthor(1);
            message.setThread(1);
            message = MessageRepository.insert(message);

            request.setAttribute("message", message);
            response.setStatus(200);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            response.setStatus(500);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/display_message.jsp").forward(request, response);
    }
}
