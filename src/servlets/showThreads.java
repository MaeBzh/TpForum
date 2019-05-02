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
        List<Thread> listThread = new ArrayList<>();

        Thread t1 = new Thread("Un jour", new User(), 1);
        Thread t2 = new Thread("peut-être", new User(), 2);
        Thread t3 = new Thread("j'irai la bas", new User(), 3);
        Thread t4 = new Thread("au loin vers", new User(), 4);
        Thread t5 = new Thread("cette merveilleuse contrée", new User(), 5);
        listThread.add(t1);
        listThread.add(t2);
        listThread.add(t3);
        listThread.add(t4);
        listThread.add(t5);
        request.setAttribute("title", "Show Threads");
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("listThread", listThread);
        this.getServletContext().getRequestDispatcher("/WEB-INF/showThreads.jsp").forward(request, response);
    }
}
