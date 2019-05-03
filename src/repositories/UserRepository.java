package repositories;

import beans.Database;
import beans.Message;
import beans.User;
import org.joda.time.DateTime;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

public class UserRepository {


    private static Connection getConnection() throws SQLException {
        return Database.getInstance().getConnection();
    }

    private static String hash(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytesOfMessage = password.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        BigInteger bigInt = new BigInteger(1, thedigest);
        String pwd = bigInt.toString(16);
        System.out.println(pwd);
        return pwd;
    }

    public static User update(User user) {
        User result = user;

        try {
            String query = "UPDATE user SET(nom = ?, prenom = ?, mail = ?, pseudo = ?, avatar = ?, role = ?);";

            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, user.getLastname());
            preparedStmt.setString(2, user.getFirstname());
            preparedStmt.setString(3, user.getEmail());
            preparedStmt.setString(4, user.getPseudo());
            preparedStmt.setString(5, user.getAvatar());
            preparedStmt.setLong(6, user.getRoleId());


            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating user failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    public static User insert(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User result = user;

        try {
            String query =  query = "INSERT INTO user (nom, prenom, mail, password, pseudo, avatar, role) VALUES (?,?,?,?,?,?,?);";

            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, user.getLastname());
            preparedStmt.setString(2, user.getFirstname());
            preparedStmt.setString(3, user.getEmail());
            preparedStmt.setString(4, hash(user.getPassword()));
            preparedStmt.setString(5, user.getPseudo());
            preparedStmt.setString(6, user.getAvatar());
            preparedStmt.setLong(7, user.getRoleId());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating user failed, no rows affected.");
            }

            if (user.getId() == 0) {
                try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    public static User save(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (user.getId() != 0) {
            user = update(user);
        } else {
            user = insert(user);
        }
        return user;
    }

    public static void delete(User user) {

        String query = "DELETE from user where id=?";

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setLong(1, user.getId());
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getAll() {
        String query = "SELECT * from user";
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setFirstname(rs.getString("prenom"));
                user.setLastname(rs.getString("nom"));
                user.setAvatar(rs.getString("avatar"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("mail"));
                user.setPseudo(rs.getString("pseudo"));
                user.setId(rs.getInt("id"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static User getById(int user_id) throws SQLException {
        String query = "SELECT * from user WHERE id=? LIMIT 1";
        User user = null;

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setInt(1, user_id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setFirstname(rs.getString("prenom"));
                user.setLastname(rs.getString("nom"));
                user.setAvatar(rs.getString("avatar"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("mail"));
                user.setPseudo(rs.getString("pseudo"));
                user.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static User checkCredentials(String pseudo, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        String query = "SELECT * from user WHERE `pseudo` = ? AND `password` = ? LIMIT 1";
        User user = null;

        try {
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setString(1, pseudo);
            preparedStmt.setString(2, hash(password));
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setFirstname(rs.getString("prenom"));
                user.setLastname(rs.getString("nom"));
                user.setAvatar(rs.getString("avatar"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("mail"));
                user.setPseudo(rs.getString("pseudo"));
                user.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
