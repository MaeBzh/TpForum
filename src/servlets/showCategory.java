package servlets;

import beans.Category;
import repositories.CategoryRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class showCategory extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory;

        listCategory = CategoryRepository.getAll();
        System.out.println(listCategory);

        request.setAttribute("title", "Index");
        request.setAttribute("listCategory", listCategory);
        this.getServletContext().getRequestDispatcher("/WEB-INF/showCategory.jsp").forward(request, response);
    }
}
