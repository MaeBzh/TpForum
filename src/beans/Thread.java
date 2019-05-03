package beans;

import repositories.MessageRepository;

import java.util.ArrayList;

public class Thread {
    private String title;
    private User author;
    private int id;

    public Thread(String title, User author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Message> messages() {
        return MessageRepository.getByThread(this.getId());
    }
}
