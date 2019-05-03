package beans;

import repositories.MessageRepository;
import repositories.RoleRepository;
import repositories.ThreadRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String pseudo;
    private String email;
    private String password;
    private String avatar;
    private int roleId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public ArrayList<Message> messages() {
        return MessageRepository.getByAuthor(this.getId());
    }

    public ArrayList<Thread> thread() {
        return ThreadRepository.getByAuthor(this.getId());
    }

    public Role role() throws SQLException {
        return RoleRepository.getById(this.getRoleId());
    }

    public boolean isAdmin() {
        boolean isAdmin = false;
        if(this.getRoleId() == 1) {
            isAdmin = true;
        }
         return isAdmin;
    }
}
