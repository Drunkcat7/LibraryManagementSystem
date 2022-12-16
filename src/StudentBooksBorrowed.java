import tools.JTextFieldHintListener;

import javax.swing.*;
import java.awt.*;

public class StudentBooksBorrowed extends JPanel {
    private Font bigFont = new Font("宋体", Font.BOLD, 40);
    private Font titleFont = new Font("宋体", Font.BOLD, 70);
    public StudentBooksBorrowed() {
        setLayout(null);
        JLabel jLabel = new JLabel("图书借还",JLabel.CENTER);
        jLabel.setFont(titleFont);
        jLabel.setBounds(0, 0, 1024,100);
        add(jLabel);

        // search
        JPanel searchJpanel = new JPanel();
        searchJpanel.setLayout(null);
        searchJpanel.setBounds(0, 140, 1024,60);
        JTextField searchJTextField  = new JTextField(10);
        searchJTextField.addFocusListener(new JTextFieldHintListener(searchJTextField, "输入要搜索的书编号"));
        searchJTextField.setFont(bigFont);
        searchJTextField.setBounds(137,0,500,60);
        searchJpanel.add(searchJTextField);
        JButton searchBtn = new JButton("搜索");
        searchBtn.setBounds(637,0,200,60);
        searchBtn.setFont(bigFont);
        searchJpanel.add(searchBtn);
        add(searchJpanel);

        JPanel bidJpanel = new JPanel();
        bidJpanel.setLayout(null);
        bidJpanel.setBounds(0, 220, 1024,60);
        JLabel bidJLabel = new JLabel("书号：");
        bidJLabel.setFont(bigFont);
        bidJLabel.setBounds(137,0,1024,60);
        bidJpanel.add(bidJLabel);
        JLabel bid = new JLabel("1");
        bid.setBounds(237,0,1024,60);
        bid.setFont(bigFont);
        bidJpanel.add(bid);
        add(bidJpanel);

        JPanel bookNameJpanel = new JPanel();
        bookNameJpanel.setLayout(null);
        bookNameJpanel.setBounds(0, 300, 1024,60);
        JLabel bookNameJLabel = new JLabel("书名：");
        bookNameJLabel.setFont(bigFont);
        bookNameJLabel.setBounds(137,0,1024,60);
        bookNameJpanel.add(bookNameJLabel);
        JLabel bookName = new JLabel("JAVA程序设计");
        bookName.setBounds(237,0,1024,60);
        bookName.setFont(bigFont);
        bookNameJpanel.add(bookName);
        add(bookNameJpanel);

        JPanel authorJpanel = new JPanel();
        authorJpanel.setLayout(null);
        authorJpanel.setBounds(0, 380, 1024,60);
        JLabel authorJLabel = new JLabel("作者：");
        authorJLabel.setFont(bigFont);
        authorJLabel.setBounds(137,0,1024,60);
        authorJpanel.add(authorJLabel);
        JLabel author = new JLabel("小明");
        author.setBounds(237,0,1024,60);
        author.setFont(bigFont);
        authorJpanel.add(author);
        add(authorJpanel);

        JPanel pressJpanel = new JPanel();
        pressJpanel.setLayout(null);
        pressJpanel.setBounds(0, 460, 1024,60);
        JLabel pressJLabel = new JLabel("出版：");
        pressJLabel.setFont(bigFont);
        pressJLabel.setBounds(137,0,1024,60);
        pressJpanel.add(pressJLabel);
        JLabel press = new JLabel("清华大学出版社");
        press.setBounds(237,0,1024,60);
        press.setFont(bigFont);
        pressJpanel.add(press);
        add(pressJpanel);

        JPanel allowanceJpanel = new JPanel();
        allowanceJpanel.setLayout(null);
        allowanceJpanel.setBounds(0, 540, 1024,60);
        JLabel allowanceJLabel = new JLabel("余量：");
        allowanceJLabel.setFont(bigFont);
        allowanceJLabel.setBounds(137,0,1024,60);
        allowanceJpanel.add(allowanceJLabel);
        JLabel allowance = new JLabel("20");
        allowance.setBounds(237,0,1024,60);
        allowance.setFont(bigFont);
        allowanceJpanel.add(allowance);
        add(allowanceJpanel);

        JPanel btnJpanel = new JPanel();
        btnJpanel.setLayout(null);
        btnJpanel.setBounds(0, 620, 1024,60);
        JButton returnBookBtn = new JButton("还书");
        returnBookBtn.setFont(bigFont);
        returnBookBtn.setBounds(137,0,200,60);
        btnJpanel.add(returnBookBtn);
        JButton borrowBooksBtn = new JButton("借书");
        borrowBooksBtn.setFont(bigFont);
        borrowBooksBtn.setBounds(337,0,200,60);
        btnJpanel.add(borrowBooksBtn);
        add(btnJpanel);

    }
}
