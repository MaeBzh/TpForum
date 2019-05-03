package servlets;

import beans.Category;
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

public class showCategory extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory;

        listCategory = CategoryRepository.getAll();

        for (Category cat: listCategory) {
            try {
                cat.setNbThreads(cat.threads().size());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("title", "Index");
        request.setAttribute("listCategory", listCategory);
        this.getServletContext().getRequestDispatcher("/WEB-INF/showCategory.jsp").forward(request, response);
    }
}
