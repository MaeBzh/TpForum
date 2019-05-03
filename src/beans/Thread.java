package beans;

import repositories.MessageRepository;

import java.util.ArrayList;

public class Thread {
    private long id;
    private String title;
    private int authorId;
    private int categoryId;
    //private User author;

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

//    public User getAuthor() {
//        return this.author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }

    public ArrayList<Message> messages() {
        return MessageRepository.getByThread(this.getId());
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
