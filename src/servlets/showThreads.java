package servlets;

import beans.Category;
import beans.Thread;
import repositories.CategoryRepository;
import repositories.ThreadRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class showThreads extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Thread> listThread = new ArrayList<>();
        try {
            System.out.println(request.getParameter("catId"));
            Category category = CategoryRepository.getById(Integer.parseInt(request.getParameter("catId")));
            System.out.println(category);
//            listThread = category.threads();
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        try {
//            listThread = ThreadRepository.getByCategory(Integer.parseInt(request.getParameter("catId")));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        request.setAttribute("title", "Show Threads");
        request.setAttribute("catId", request.getParameter("catId"));
        request.setAttribute("listThread", listThread);

//        Thread t1 = new Thread("Un jour", new User(), 1);
//        Thread t2 = new Thread("peut-être", new User(), 2);
//        Thread t3 = new Thread("j'irai la bas", new User(), 3);
//        Thread t4 = new Thread("au loin vers", new User(), 4);
//        Thread t5 = new Thread("cette merveilleuse contrée", new User(), 5);

//        listThread.add(t1);
//        listThread.add(t2);
//        listThread.add(t3);
//        listThread.add(t4);
//        listThread.add(t5);
//        request.setAttribute("title", "Show Threads");
//        request.setAttribute("catId", request.getParameter("catId"));
//        request.setAttribute("listThread", listThread);
        this.getServletContext().getRequestDispatcher("/WEB-INF/showThreads.jsp").forward(request, response);
    }
}
