package repositories;

import beans.Category;
import beans.Database;

import java.sql.*;
import java.util.ArrayList;

public class CategoryRepository {


    private static Connection getConnection() throws SQLException {
        return Database.getInstance().getConnection();
    }

    public static Category save(Category category) {

        Category result = category;
        String query;

        try {
            if (category.getId() != 0) {
                query = "UPDATE category SET(name = ?);";
            } else {
                query = "INSERT INTO message (author, thread, content) VALUES (?,?,?);";
            }
            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, category.getTitle());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating category failed, no rows affected.");
            }

            if (category.getId() == 0) {
                try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating category failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    public static void delete(Category category) {

        String query = "DELETE from category where id=?";

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, category.getId());
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Category> getAll() {
        String query = "SELECT * from category";
        ArrayList<Category> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery(query);
            while (rs.next()) {
                Category category = new Category();
                category.setTitle(rs.getString("name"));
                category.setId(rs.getInt("id"));
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    public static Category getById(int category_id) throws SQLException {
        String query = "SELECT * from category WHERE id=? LIMIT 1";
        Category category = null;

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setInt(1, category_id);
            ResultSet rs = preparedStmt.executeQuery(query);
            if (rs.next()) {
                category = new Category();
                category.setTitle(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }
}
