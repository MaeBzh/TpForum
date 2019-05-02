package beans;

import org.joda.time.DateTime;

public class Message {
    private long id;
    private String content;
    private DateTime date;
    private int authorId;
    private int threadId;

    public long getId() {
        return this.id;
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

//    public User author() {
//        return UserRepository.getById(this.getAuthorId());
//    }
//
//    public Thread thread() {
//        return ThreadRepository.getById(this.getThreadId());
//    }
}
