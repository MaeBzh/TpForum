package beans;

import repositories.MessageRepository;

import java.util.ArrayList;

public class Thread {
    private long id;
    private String title;
    private User author;

    public Thread(String title, User author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
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

    public ArrayList<Message> messages() {
        return MessageRepository.getByThread(this.getId());   

    public void setId(int id) {
        this.id = id;
    }
}
