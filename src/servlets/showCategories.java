package servlets;

import beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class showCategories extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> listCategories = new ArrayList<>();

        listCategories.add("Développement WEB");
        listCategories.add("Développement orienté objet");
        listCategories.add("Gestion de projet");
        listCategories.add("Management d’équipe");

        request.setAttribute("title", "Index");
        request.setAttribute("listCategories", listCategories);

        this.getServletContext().getRequestDispatcher("/WEB-INF/showCategories.jsp").forward(request, response);
    }
}
