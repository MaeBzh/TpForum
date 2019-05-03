package repositories;

import beans.Database;
import beans.Message;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.ArrayList;

public class MessageRepository {


    private static Connection getConnection() throws SQLException {
        return Database.getInstance().getConnection();
    }

    public static Message save(Message message) {

        Message result = message;
        String query;

        try {
            if (message.getId() != 0) {
                query = "UPDATE message SET(author = ?, thread = ?, content = ?);";
            } else {
                query = "INSERT INTO message (author, thread, content) VALUES (?,?,?);";
            }
            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, message.getAuthorId());
            preparedStmt.setInt(2, message.getThreadId());
            preparedStmt.setString(3, message.getContent());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating message failed, no rows affected.");
            }

            if (message.getId() == 0) {
                try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating message failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    public static void delete(Message message) {

        String query = "DELETE from message where id=?";

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, message.getId());
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Message> getAll() {
        String query = "SELECT * from message";
        ArrayList<Message> messages = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery(query);
            while (rs.next()) {
                Message message = new Message();
                message.setThreadId(rs.getInt("thread"));
                message.setAuthorId(rs.getInt("author"));
                message.setContent(rs.getString("content"));
                message.setDate(DateTime.parse(rs.getString("date")));
                message.setId(rs.getInt("id"));
                messages.add(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    public static Message getById(int message_id) throws SQLException {
        String query = "SELECT * from message WHERE id=? LIMIT 1";
        Message message = null;

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setInt(1, message_id);
            ResultSet rs = preparedStmt.executeQuery(query);
            if (rs.next()) {
                message = new Message();
                message.setThreadId(rs.getInt("thread"));
                message.setAuthorId(rs.getInt("author"));
                message.setContent(rs.getString("content"));
                message.setDate(DateTime.parse(rs.getString("date")));
                message.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return message;
    }

    public static ArrayList<Message> getByThread(int thread_id) {
        String query = "SELECT * from message WHERE thread = ?";
        ArrayList<Message> messages = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setInt(1, thread_id);
            ResultSet rs = preparedStmt.executeQuery(query);
            while (rs.next()) {
                Message message = new Message();
                message.setThreadId(rs.getInt("thread"));
                message.setAuthorId(rs.getInt("author"));
                message.setContent(rs.getString("content"));
                message.setDate(DateTime.parse(rs.getString("date")));
                message.setId(rs.getInt("id"));
                messages.add(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    public static ArrayList<Message> getByAuthor(int author_id) {
        String query = "SELECT * from message WHERE author = ?";
        ArrayList<Message> messages = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setInt(1, author_id);
            ResultSet rs = preparedStmt.executeQuery(query);
            while (rs.next()) {
                Message message = new Message();
                message.setThreadId(rs.getInt("thread"));
                message.setAuthorId(rs.getInt("author"));
                message.setContent(rs.getString("content"));
                message.setDate(DateTime.parse(rs.getString("date")));
                message.setId(rs.getInt("id"));
                messages.add(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }
}
