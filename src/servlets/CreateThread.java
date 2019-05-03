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

public class CreateThread extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("connectedUser");
        Thread thread = new Thread();
        thread.setTitle(request.getParameter("title"));
        thread.setCategoryId(Integer.parseInt(request.getParameter("catId")));
        thread.setAuthorId(user.getId());
        thread.setSolved(false);
        thread.setValidate(true);
        ThreadRepository.save(thread);


        Message message = new Message();
        message.setContent(request.getParameter("content"));
        message.setDate(DateTime.now());
        message.setAuthorId(user.getId());
        message.setThreadId(thread.getId());

        MessageRepository.save(message);

        request.setAttribute("message", message);
        request.setAttribute("catId", request.getParameter("catId"));

        response.setStatus(200);

        response.sendRedirect("/web_war_exploded/category/thread/?catId="+ thread.getCategoryId() + "&thrId=" + thread.getId());
//        this.getServletContext().getRequestDispatcher("/WEB-INF/showThread.jsp/?catId=" + thread.getCategoryId() + "&thrId=" + thread.getId()).forward(request, response);
    }
}
