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

public class CreateMessage extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Nouveau message");
        this.getServletContext().getRequestDispatcher("/WEB-INF/create_message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("connectedUser");
        Message message = new Message();
        int thrId = Integer.parseInt(request.getParameter("thrId"));
        if (thrId != 0) {
            message.setThreadId(thrId);
        } else {
            Thread thread = new Thread();
            thread.setTitle(request.getParameter("title"));
            thread.setCategoryId(Integer.parseInt(request.getParameter("catId")));
            thread.setAuthorId(user.getId());
            thread.setSolved(false);
            thread.setValidate(true);
            ThreadRepository.save(thread);
        }

        message.setContent(request.getParameter("content"));
        message.setDate(DateTime.now());
        message.setAuthorId(1);

        message = MessageRepository.save(message);

        request.setAttribute("message", message);
        response.setStatus(200);

        this.getServletContext().getRequestDispatcher("/WEB-INF/display_message.jsp").forward(request, response);
    }
}
