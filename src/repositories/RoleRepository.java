package repositories;

import beans.Database;
import beans.Role;

import java.sql.*;
import java.util.ArrayList;

public class RoleRepository {


    private static Connection getConnection() throws SQLException {
        return Database.getInstance().getConnection();
    }

    public static Role save(Role role) {

        Role result = role;
        String query;

        try {
            if (role.getId() != 0) {
                query = "UPDATE category SET(name = ?);";
            } else {
                query = "INSERT INTO role (name) VALUES (?);";
            }
            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, role.getName());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating role failed, no rows affected.");
            }

            if (role.getId() == 0) {
                try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating role failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    public static void delete(Role role) {

        String query = "DELETE from role where id=?";

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, role.getId());
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Role> getAll() {
        String query = "SELECT * from role";
        ArrayList<Role> roles = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery(query);
            while (rs.next()) {
                Role role = new Role();
                role.setName(rs.getString("name"));
                roles.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    public static Role getById(int role_id) throws SQLException {
        String query = "SELECT * from role WHERE id=? LIMIT 1";
        Role role = null;

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setInt(1, role_id);
            ResultSet rs = preparedStmt.executeQuery(query);
            if (rs.next()) {
                role = new Role();
                role.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }
}
