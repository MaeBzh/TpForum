package servlets;

import beans.Thread;
import beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class showThreads extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Thread> listThread;

        listThread = ThreadRepository.getByCategory();
        request.setAttribute("title", "Show Threads");
        request.setAttribute("catId", request.getParameter("catId"));
        request.setAttribute("listThread", listThread);
        this.getServletContext().getRequestDispatcher("/WEB-INF/showThreads.jsp").forward(request, response);
    }
}
