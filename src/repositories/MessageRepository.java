package repositories;

import beans.Database;
import beans.Message;

import java.sql.*;

public class MessageRepository {

    MessageRepository() {
    }

    public static Message insert(Message message) throws SQLException {
        Message result = message;

        try {
            Connection connection = Database.getInstance().getConnection() ;

            String query = "INSERT INTO Message (author, thread, content) VALUES (?,?,?);";
            PreparedStatement preparedStmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt (1, message.getAuthor());
            preparedStmt.setInt (2, message.getThread());
            preparedStmt.setString   (3, message.getContent());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating message failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    result.setId(generatedKeys.getLong(1));
                                    }
                else {
                    throw new SQLException("Creating message failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }
}
