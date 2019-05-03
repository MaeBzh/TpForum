package servlets;

import beans.Message;
import beans.Thread;
import repositories.MessageRepository;
import repositories.ThreadRepository;
import repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class showThread extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Message> listMessages;
        listMessages = MessageRepository.getByThread(Integer.parseInt(request.getParameter("thrId")));

        request.setAttribute("title", "Show Thread");
        request.setAttribute("thrId", request.getParameter("thrId"));
        request.setAttribute("catId", request.getParameter("catId"));
        request.setAttribute("listMessages", listMessages);
        for (Message message : listMessages) {
            try {
                message.setAuthor(UserRepository.getById(ThreadRepository.getById(Integer.parseInt(request.getParameter("thrId"))).getAuthorId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            request.setAttribute("titleThr", ThreadRepository.getById(Integer.parseInt(request.getParameter("thrId"))).getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/showThread.jsp").forward(request, response);
    }
}
