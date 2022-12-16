import entity.Book;
import tools.DBUtils;
import tools.JTextFieldHintListener;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBookInquiry extends JPanel {
    private Font bigFont = new Font("宋体", Font.BOLD, 40);
    private Font smallFont = new Font("宋体", Font.BOLD, 20);
    private Font titleFont = new Font("宋体", Font.BOLD, 70);
    private JButton searchBtn;
    private JTextField searchJTextField;
    private List<Book> bookList = new ArrayList<>();
    private int y = 220;
    private DBUtils dbUtils;

    public StudentBookInquiry(JFrame frame) {
        init();
        dbUtils = new DBUtils();
        dbUtils.getConnection();
        try {
            ResultSet resultSet = dbUtils.getStatement().executeQuery("SELECT * FROM book");
            while (resultSet.next()) {
                bookList.add(new Book(
                        resultSet.getInt("book_id"), resultSet.getString("bookname")
                        , resultSet.getString("author"), resultSet.getString("press")
                        , resultSet.getInt("allowance")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbUtils.close();
        //循环结束---------------------------------------------------
        for (Book book : bookList) {
            addJPanel(book);
            y += 60;
        }
        //循环结束---------------------------------------------------
        //搜索书籍
        searchBtn.addActionListener(e -> {
            bookList.clear();
            dbUtils = new DBUtils();
            dbUtils.getConnection();
            String book = searchJTextField.getText().trim();
            try {
                ResultSet resultSet = dbUtils.getStatement()
                        .executeQuery("SELECT * FROM book WHERE bookname LIKE '%" + book + "%'");
                while (resultSet.next()) {
                    bookList.add(new Book(
                            resultSet.getInt("book_id"), resultSet.getString("bookname")
                            , resultSet.getString("author"), resultSet.getString("press")
                            , resultSet.getInt("allowance")
                    ));
                }
                System.out.println(bookList);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            dbUtils.close();
        });
    }

    public void addJPanel(Book book) {
        JPanel bidJpanel = new JPanel();
        bidJpanel.setLayout(null);
        bidJpanel.setBounds(0, y, 1024, 60); //这个高 循环要加上60

        JLabel bid = new JLabel("|" + book.getBookId());
        bid.setFont(smallFont);
        bid.setBounds(137, 0, 150, 60);
        bidJpanel.add(bid);

        JLabel bookName = new JLabel("|" + book.getBookName());
        bookName.setBounds(287, 0, 150, 60);
        bookName.setFont(smallFont);
        bidJpanel.add(bookName);

        JLabel author = new JLabel("|" + book.getAuthor());
        author.setBounds(437, 0, 150, 60);
        author.setFont(smallFont);
        bidJpanel.add(author);

        JLabel press = new JLabel("|" + book.getPress());
        press.setBounds(587, 0, 150, 60);
        press.setFont(smallFont);
        bidJpanel.add(press);

        JLabel allowance = new JLabel("|" + book.getAllowance());
        allowance.setBounds(737, 0, 150, 60);
        allowance.setFont(smallFont);
        bidJpanel.add(allowance);
        add(bidJpanel);
    }

    public void init() {//初始化
        setLayout(null);
        JLabel jLabel = new JLabel("图书查询", JLabel.CENTER);
        jLabel.setFont(titleFont);
        jLabel.setBounds(0, 0, 1024, 100);
        add(jLabel);
        // search
        JPanel searchJpanel = new JPanel();
        searchJpanel.setLayout(null);
        searchJpanel.setBounds(0, 140, 1024, 60);
        searchJTextField = new JTextField(10);
        searchJTextField.setFont(bigFont);
        searchJTextField.addFocusListener(new JTextFieldHintListener(searchJTextField, "输入要搜索的书名"));
        searchJTextField.setBounds(137, 0, 500, 60);
        searchJpanel.add(searchJTextField);
        searchBtn = new JButton("搜索");
        searchBtn.setBounds(637, 0, 200, 60);
        searchBtn.setFont(bigFont);
        searchJpanel.add(searchBtn);
        add(searchJpanel);
        
        JPanel bidJpanel = new JPanel();
        bidJpanel.setLayout(null);
        bidJpanel.setBounds(0, y, 1024, 60); //这个高 循环要加上60

        JLabel bid = new JLabel("|书籍编号");
        bid.setFont(smallFont);
        bid.setBounds(137, 0, 150, 60);
        bidJpanel.add(bid);

        JLabel bookName = new JLabel("|书籍名称");
        bookName.setBounds(287, 0, 150, 60);
        bookName.setFont(smallFont);
        bidJpanel.add(bookName);

        JLabel author = new JLabel("|书籍作者");
        author.setBounds(437, 0, 150, 60);
        author.setFont(smallFont);
        bidJpanel.add(author);

        JLabel press = new JLabel("|出版社名");
        press.setBounds(587, 0, 150, 60);
        press.setFont(smallFont);
        bidJpanel.add(press);

        JLabel allowance = new JLabel("|书籍余量");
        allowance.setBounds(737, 0, 150, 60);
        allowance.setFont(smallFont);
        bidJpanel.add(allowance);
        add(bidJpanel);
        y += 60;
    }
}
