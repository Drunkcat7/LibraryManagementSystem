package entity;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String press;
    private int allowance;

    public Book(int bookId, String bookName, String author, String press, int allowance) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.allowance = allowance;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
}
