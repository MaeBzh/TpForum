package beans;

import org.joda.time.DateTime;

public class Message {
    private long id;
    private String content;
    private DateTime date;
    private int author;
    private int thread;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getAuthor() {
        return this.author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getThread() {
        return this.thread;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }
}
