import entity.Book;
import tools.DBUtils;
import tools.JTextFieldHintListener;
import tools.MyDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StudentBooksBorrowed extends JPanel {
    private Font bigFont = new Font("宋体", Font.BOLD, 40);
    private Font titleFont = new Font("宋体", Font.BOLD, 70);
    private Book book = null;
    private DBUtils dbUtils;
    private ResultSet resultSet;

    //控件
    private JLabel bid;
    private JLabel bookName;
    private JLabel author;
    private JLabel press;
    private JLabel allowance;


    public StudentBooksBorrowed() {
        setLayout(null);
        JLabel jLabel = new JLabel("图书借还", JLabel.CENTER);
        jLabel.setFont(titleFont);
        jLabel.setBounds(0, 0, 1024, 100);
        add(jLabel);

        // search
        JPanel searchJpanel = new JPanel();
        searchJpanel.setLayout(null);
        searchJpanel.setBounds(0, 140, 1024, 60);
        JTextField searchJTextField = new JTextField(10);
        searchJTextField.addFocusListener(new JTextFieldHintListener(searchJTextField, "输入要搜索的书编号"));
        searchJTextField.setFont(bigFont);
        searchJTextField.setBounds(137, 0, 500, 60);
        searchJpanel.add(searchJTextField);
        JButton searchBtn = new JButton("搜索");
        searchBtn.setBounds(637, 0, 200, 60);
        searchBtn.setFont(bigFont);
        searchJpanel.add(searchBtn);
        add(searchJpanel);

        JPanel bidJpanel = new JPanel();
        bidJpanel.setLayout(null);
        bidJpanel.setBounds(0, 220, 1024, 60);
        JLabel bidJLabel = new JLabel("书号：");
        bidJLabel.setFont(bigFont);
        bidJLabel.setBounds(137, 0, 1024, 60);
        bidJpanel.add(bidJLabel);
        bid = new JLabel("null");
        bid.setBounds(237, 0, 1024, 60);
        bid.setFont(bigFont);
        bidJpanel.add(bid);
        add(bidJpanel);

        JPanel bookNameJpanel = new JPanel();
        bookNameJpanel.setLayout(null);
        bookNameJpanel.setBounds(0, 300, 1024, 60);
        JLabel bookNameJLabel = new JLabel("书名：");
        bookNameJLabel.setFont(bigFont);
        bookNameJLabel.setBounds(137, 0, 1024, 60);
        bookNameJpanel.add(bookNameJLabel);
        bookName = new JLabel("null");
        bookName.setBounds(237, 0, 1024, 60);
        bookName.setFont(bigFont);
        bookNameJpanel.add(bookName);
        add(bookNameJpanel);

        JPanel authorJpanel = new JPanel();
        authorJpanel.setLayout(null);
        authorJpanel.setBounds(0, 380, 1024, 60);
        JLabel authorJLabel = new JLabel("作者：");
        authorJLabel.setFont(bigFont);
        authorJLabel.setBounds(137, 0, 1024, 60);
        authorJpanel.add(authorJLabel);
        author = new JLabel("null");
        author.setBounds(237, 0, 1024, 60);
        author.setFont(bigFont);
        authorJpanel.add(author);
        add(authorJpanel);

        JPanel pressJpanel = new JPanel();
        pressJpanel.setLayout(null);
        pressJpanel.setBounds(0, 460, 1024, 60);
        JLabel pressJLabel = new JLabel("出版：");
        pressJLabel.setFont(bigFont);
        pressJLabel.setBounds(137, 0, 1024, 60);
        pressJpanel.add(pressJLabel);
        press = new JLabel("null");
        press.setBounds(237, 0, 1024, 60);
        press.setFont(bigFont);
        pressJpanel.add(press);
        add(pressJpanel);

        JPanel allowanceJpanel = new JPanel();
        allowanceJpanel.setLayout(null);
        allowanceJpanel.setBounds(0, 540, 1024, 60);
        JLabel allowanceJLabel = new JLabel("余量：");
        allowanceJLabel.setFont(bigFont);
        allowanceJLabel.setBounds(137, 0, 1024, 60);
        allowanceJpanel.add(allowanceJLabel);
        allowance = new JLabel("null");
        allowance.setBounds(237, 0, 1024, 60);
        allowance.setFont(bigFont);
        allowanceJpanel.add(allowance);
        add(allowanceJpanel);

        JPanel btnJpanel = new JPanel();
        btnJpanel.setLayout(null);
        btnJpanel.setBounds(0, 620, 1024, 60);
        JButton returnBookBtn = new JButton("还书");
        returnBookBtn.setFont(bigFont);
        returnBookBtn.setBounds(137, 0, 200, 60);
        btnJpanel.add(returnBookBtn);
        JButton borrowBooksBtn = new JButton("借书");
        borrowBooksBtn.setFont(bigFont);
        borrowBooksBtn.setBounds(337, 0, 200, 60);
        btnJpanel.add(borrowBooksBtn);
        add(btnJpanel);

        //搜索
        searchBtn.addActionListener(e -> {
            dbUtils = new DBUtils();
            dbUtils.getConnection();
            try {
                resultSet = dbUtils.getStatement().executeQuery("SELECT * FROM book WHERE book_id = " +
                        searchJTextField.getText().trim());
                if (resultSet.next()) {
                    book = new Book(
                            resultSet.getInt("book_id"), resultSet.getString("bookname")
                            , resultSet.getString("author"), resultSet.getString("press")
                            , resultSet.getInt("allowance")
                    );
                } else {
                    book = null;
                }
                setBook(book);
                repaint();
                revalidate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        //还书
        returnBookBtn.addActionListener(e -> {
            try {
                //检查是否有借过该书籍
                if (book == null || !checkBookStart(book.getBookId() + "")) {
                    new MyDialog().init("你还没借该书籍");
                    return;
                }
                dbUtils = new DBUtils();
                dbUtils.getConnection();
                dbUtils.getStatement()
                        .executeUpdate("update borrow set state = 1 where book_id = '" + book.getBookId()
                                + "' and student_id = '" + LibraryManagement.userID + "'");
                //余量加一
                book.setAllowance(book.getAllowance() + 1);
                dbUtils.getStatement()
                        .executeUpdate("update book set allowance = " + book.getAllowance()
                                + " where book_id = " + book.getBookId());
                allowance.setText(book.getAllowance() + "");
                new MyDialog().init(book.getBookName() + "书籍：归还成功");

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        //借书
        borrowBooksBtn.addActionListener(e -> {
            //检查是否借过该书籍
            //检查是否有借过该书籍
            try {
                if (book == null || checkBookStart(book.getBookId() + "")) {
                    new MyDialog().init("你已经借过该书籍了");
                    return;
                }
                //有修改，没则新增
                dbUtils = new DBUtils();
                dbUtils.getConnection();
                boolean checkBookBorrow = dbUtils.getStatement().executeQuery("SELECT * FROM borrow WHERE book_id = '" + book.getBookId() +
                        "' and student_id = '" + LibraryManagement.userID + "'").next();
                String sql;

                if (checkBookBorrow) {//借过修改
                    sql = "update borrow set state = 0 where book_id = '" + book.getBookId()
                            + "' and student_id = '" + LibraryManagement.userID + "'";
                } else {//新增
                    sql = "INSERT INTO borrow(`book_id`, `student_id`, `start_date`) " +
                            "VALUES (" + book.getBookId()
                            + ", " + LibraryManagement.userID + ", '" + getNowTime() + "');";
                    System.out.println(sql);
                }
                dbUtils.getStatement().executeUpdate(sql);
                //余量减一
                book.setAllowance(book.getAllowance() - 1);
                dbUtils.getStatement()
                        .executeUpdate("update book set allowance = " + book.getAllowance()
                                + " where book_id = " + book.getBookId());
                allowance.setText(book.getAllowance() + "");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    public String getNowTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String result = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return result;
    }

    public boolean checkBookStart(String bookId) throws SQLException {
        dbUtils = new DBUtils();
        dbUtils.getConnection();
        boolean b = false;
        String sql = "SELECT * FROM borrow WHERE book_id = '" + bookId +
                "' and student_id = '" + LibraryManagement.userID + "' and state = 0";
        b = dbUtils.getStatement().executeQuery(sql).next();
        dbUtils.close();
        return b;


    }

    public void setBook(Book book) {
        if (book == null) {
            bid.setText("null");
            bookName.setText("null");
            author.setText("null");
            press.setText("null");
            allowance.setText("null");
            return;
        }
        bid.setText(book.getBookId() + "");
        bookName.setText(book.getBookName());
        author.setText(book.getAuthor());
        press.setText(book.getPress());
        allowance.setText(book.getAllowance() + "");
    }
}
