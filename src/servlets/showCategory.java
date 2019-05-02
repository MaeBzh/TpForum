package servlets;

import beans.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class showCategory extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = new ArrayList<>();

        Category c1 = new Category();
        Category c2 = new Category();
        Category c3 = new Category();
        Category c4 = new Category();

        c1.setTitle("Développement WEB");
        c2.setTitle("Développement orienté objet");
        c3.setTitle("Gestion de projet");
        c4.setTitle("Management d’équipe");
        c1.setId(1);
        c2.setId(2);
        c3.setId(3);
        c4.setId(4);

        listCategory.add(c1);
        listCategory.add(c2);
        listCategory.add(c3);
        listCategory.add(c4);

        request.setAttribute("title", "Index");
        request.setAttribute("listCategory", listCategory);
        this.getServletContext().getRequestDispatcher("/WEB-INF/showCategory.jsp").forward(request, response);
    }
}
