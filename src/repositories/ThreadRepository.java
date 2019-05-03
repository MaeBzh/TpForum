package repositories;

import beans.Database;
import beans.Thread;

import java.sql.*;
import java.util.ArrayList;

public class ThreadRepository {

    private static Connection getConnection() throws SQLException {
        return Database.getInstance().getConnection();
    }

    public static Thread save(Thread thread) {

        Thread result = thread;
        String query;

        try {
            if (thread.getId() != 0) {
                query = "UPDATE thread SET(title = ?, issolved = ?, isvalidate = ?, author = ?, category = ?);";
            } else {
                query = "INSERT INTO message (title, issolved, isvalidate, author, category) VALUES (?,?,?,?,?);";
            }
            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, thread.getTitle());
            preparedStmt.setBoolean(2, thread.isSolved());
            preparedStmt.setBoolean(3, thread.isValidate());
            preparedStmt.setInt(4, thread.getAuthorId());
            preparedStmt.setInt(5, thread.getCategoryId());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating thread failed, no rows affected.");
            }

            if (thread.getId() == 0) {
                try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating thread failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    public static void delete(Thread thread) {

        String query = "DELETE from thread where id=?";

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, thread.getId());
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Thread> getAll() {
        String query = "SELECT * from thread";
        ArrayList<Thread> threads = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery(query);
            while (rs.next()) {
                Thread thread = new Thread();
                thread.setTitle(rs.getString("title"));
                thread.setAuthorId(rs.getInt("author"));
                thread.setCategoryId(rs.getInt("category"));
                thread.setSolved(rs.getBoolean("issolved"));
                thread.setValidate(rs.getBoolean("isvalidate"));
                threads.add(thread);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return threads;
    }

    public static Thread getById(int thread_id) throws SQLException {
        String query = "SELECT * from thread WHERE id=? LIMIT 1";
        Thread thread = null;

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setInt(1, thread_id);
            ResultSet rs = preparedStmt.executeQuery(query);
            if (rs.next()) {
                thread = new Thread();
                thread.setTitle(rs.getString("title"));
                thread.setAuthorId(rs.getInt("author"));
                thread.setCategoryId(rs.getInt("category"));
                thread.setSolved(rs.getBoolean("issolved"));
                thread.setValidate(rs.getBoolean("isvalidate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return thread;
    }

    public static ArrayList<Thread> getByCategory(int category_id) {
        String query = "SELECT * from thread WHERE category = ?";
        ArrayList<Thread> threads = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            System.out.println(preparedStmt);
            preparedStmt.setInt(1, category_id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                Thread thread = new Thread();
                thread.setTitle(rs.getString("title"));
                thread.setAuthorId(rs.getInt("author"));
                thread.setCategoryId(rs.getInt("category"));
                thread.setSolved(rs.getBoolean("issolved"));
                thread.setValidate(rs.getBoolean("isvalidate"));
                threads.add(thread);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return threads;
    }

    public static ArrayList<Thread> getByAuthor(int author_id) {
        String query = "SELECT * from thread WHERE author = ?";
        ArrayList<Thread> threads = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setInt(1, author_id);
            ResultSet rs = preparedStmt.executeQuery(query);
            while (rs.next()) {
                Thread thread = new Thread();
                thread.setTitle(rs.getString("title"));
                thread.setAuthorId(rs.getInt("author"));
                thread.setCategoryId(rs.getInt("category"));
                thread.setSolved(rs.getBoolean("issolved"));
                thread.setValidate(rs.getBoolean("isvalidate"));
                threads.add(thread);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return threads;
    }
}
