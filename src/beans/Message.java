package beans;

import org.joda.time.DateTime;
import repositories.ThreadRepository;
import repositories.UserRepository;

import java.sql.SQLException;

public class Message {
    private int id;
    private String content;
    private DateTime date;
    private int authorId;
    private int threadId;
    private User author;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateTime getDate() {
        return this.date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int author) {
        this.authorId = author;
    }

    public int getThreadId() {
        return this.threadId;
    }

    public void setThreadId(int thread) {
        this.threadId = thread;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User author() throws SQLException {
        return UserRepository.getById(this.getAuthorId());
    }

    public Thread thread() throws SQLException{
        return ThreadRepository.getById(this.getThreadId());
    }

    public User author(int id) throws SQLException {
        return UserRepository.getById(id);
    }
}
