import javax.swing.*;
import java.awt.*;

public class AdminBookInsert extends JPanel {
    /**
     * 未改动！！！！先别写
     * */
    private Font bigFont = new Font("宋体", Font.BOLD, 40);
    private Font titleFont = new Font("宋体", Font.BOLD, 70);

    public AdminBookInsert() {

        setLayout(null);
        JLabel jLabel = new JLabel("图书新增", JLabel.CENTER);
        jLabel.setFont(titleFont);
        jLabel.setBounds(0, 0, 1024, 100);
        add(jLabel);

        JPanel bookNameJpanel = new JPanel();
        bookNameJpanel.setLayout(null);
        bookNameJpanel.setBounds(0, 140, 1024, 60);
        JLabel bookNameJLabel = new JLabel("书名：");
        bookNameJLabel.setFont(bigFont);
        bookNameJLabel.setBounds(137, 0, 1024, 60);
        bookNameJpanel.add(bookNameJLabel);
        JTextField bookName = new JTextField("JAVA程序设计");
        bookName.setBounds(237, 0, 606, 60);
        bookName.setFont(bigFont);
        bookNameJpanel.add(bookName);
        add(bookNameJpanel);

        JPanel authorJpanel = new JPanel();
        authorJpanel.setLayout(null);
        authorJpanel.setBounds(0, 220, 1024,60);
        JLabel authorJLabel = new JLabel("作者：");
        authorJLabel.setFont(bigFont);
        authorJLabel.setBounds(137,0,1024,60);
        authorJpanel.add(authorJLabel);
        JTextField author = new JTextField("小明");
        author.setBounds(237,0,606,60);
        author.setFont(bigFont);
        authorJpanel.add(author);
        add(authorJpanel);

        JPanel pressJpanel = new JPanel();
        pressJpanel.setLayout(null);
        pressJpanel.setBounds(0, 300, 1024, 60);
        JLabel pressJLabel = new JLabel("出版：");
        pressJLabel.setFont(bigFont);
        pressJLabel.setBounds(137, 0, 1024, 60);
        pressJpanel.add(pressJLabel);
        JTextField press = new JTextField("清华大学出版社");
        press.setBounds(237, 0, 606, 60);
        press.setFont(bigFont);
        pressJpanel.add(press);
        add(pressJpanel);

        JPanel allowanceJpanel = new JPanel();
        allowanceJpanel.setLayout(null);
        allowanceJpanel.setBounds(0, 380, 1024, 60);
        JLabel allowanceJLabel = new JLabel("余量：");
        allowanceJLabel.setFont(bigFont);
        allowanceJLabel.setBounds(137, 0, 1024, 60);
        allowanceJpanel.add(allowanceJLabel);
        JTextField allowance = new JTextField("20");
        allowance.setBounds(237, 0, 606, 60);
        allowance.setFont(bigFont);
        allowanceJpanel.add(allowance);
        add(allowanceJpanel);

        JPanel btnJpanel = new JPanel();
        btnJpanel.setLayout(null);
        btnJpanel.setBounds(0, 460, 1024, 60);
        JButton returnBookBtn = new JButton("添加");
        returnBookBtn.setFont(bigFont);
        returnBookBtn.setBounds(137, 0, 200, 60);
        btnJpanel.add(returnBookBtn);
        add(btnJpanel);

    }
}
