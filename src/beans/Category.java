package beans;

import repositories.ThreadRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class Category {
    private String title;
    private int id;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Thread> threads() throws SQLException {
        return ThreadRepository.getByCategory(this.getId());
    }
}
