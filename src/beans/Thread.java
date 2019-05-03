package beans;

import repositories.MessageRepository;

import java.util.ArrayList;

public class Thread {
    private int id;
    private String title;
    private boolean isSolved;
    private boolean isValidate;
    private int authorId;
    private  int categoryId;

    public Thread() {};

    public Thread(int id, String title, boolean isSolved, boolean isValidate, int authorId, int categoryId) {
        this.id = id;
        this.title = title;
        this.isSolved = isSolved;
        this.isValidate = isValidate;
        this.authorId = authorId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public ArrayList<Message> messages() {
        return MessageRepository.getByThread(this.getId());
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public boolean isValidate() {
        return isValidate;
    }

    public void setValidate(boolean validate) {
        isValidate = validate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
