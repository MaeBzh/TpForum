package repositories;

import beans.Category;
import beans.Database;
import beans.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryRepository {

    CategoryRepository() {
    }

    public static Category insert(Category category) throws SQLException {

        Category result = category;
        try {
            Connection connection = Database.getInstance().getConnection() ;

            String query = "INSERT INTO Category (title) VALUES (?);";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, category.getTitle());
            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating category failed, no rows affected.");
            }

//            try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    message.setId(generatedKeys.getLong(1));
//                                    }
//                else {
//                    throw new SQLException("Creating message failed, no ID obtained.");
//                }
//            }

            result = category;

        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }
}
