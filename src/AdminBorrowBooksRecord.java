import org.w3c.dom.css.RGBColor;
import tools.DBUtils;
import tools.JTextFieldHintListener;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminBorrowBooksRecord extends JPanel {
    private Font bigFont = new Font("宋体", Font.BOLD, 40);
    private Font smallFont = new Font("宋体", Font.BOLD, 20);
    private Font titleFont = new Font("宋体", Font.BOLD, 70);

    public AdminBorrowBooksRecord() {
        setLayout(null);
        JLabel jLabel = new JLabel("借书记录", JLabel.CENTER);
        jLabel.setFont(titleFont);
        jLabel.setBounds(0, 0, 1024, 100);
        add(jLabel);
        // search
        JPanel searchJpanel = new JPanel();
        searchJpanel.setLayout(null);
        searchJpanel.setBounds(0, 140, 1024, 60);
        JTextField searchJTextField = new JTextField(10);
        searchJTextField.setFont(bigFont);
        searchJTextField.addFocusListener(new JTextFieldHintListener(searchJTextField, "输入要搜索的书名"));
        searchJTextField.setBounds(137, 0, 500, 60);
        searchJpanel.add(searchJTextField);
        JButton searchBtn = new JButton("搜索");
        searchBtn.setBounds(637, 0, 200, 60);
        searchBtn.setFont(bigFont);
        searchJpanel.add(searchBtn);
        add(searchJpanel);

        //循环结束---------------------------------------------------
        JPanel bidJpanel = new JPanel();
        bidJpanel.setLayout(null);
        bidJpanel.setBounds(0, 220, 1024, 60); //这个高 循环要加上60

        JLabel bid = new JLabel("|书籍编号");
        bid.setFont(smallFont);
        bid.setBounds(68, 0, 108, 60);
        bidJpanel.add(bid);

        JLabel bookName = new JLabel("|书籍名称");
        bookName.setBounds(195, 0, 127, 60);
        bookName.setFont(smallFont);
        bidJpanel.add(bookName);

        JLabel sid = new JLabel("|学生学号");
        sid.setBounds(322, 0, 127, 60);
        sid.setFont(smallFont);
        bidJpanel.add(sid);

        JLabel studentName = new JLabel("|学生姓名");
        studentName.setBounds(449, 0, 127, 60);
        studentName.setFont(smallFont);
        bidJpanel.add(studentName);

        JLabel state = new JLabel("|是否归还");
        state.setBounds(576, 0, 127, 60);
        state.setFont(smallFont);
        bidJpanel.add(state);

        JLabel startDate = new JLabel("|借出时间");
        startDate.setBounds(703, 0, 127, 60);
        startDate.setFont(smallFont);
        bidJpanel.add(startDate);

        JLabel endDate = new JLabel("|归还时间");
        endDate.setBounds(830, 0, 127, 60);
        endDate.setFont(smallFont);
        bidJpanel.add(endDate);

        add(bidJpanel);
        //循环结束---------------------------------------------------


        JPanel bigResultJPanel = new JPanel();
        bigResultJPanel.setLayout(null);
        bigResultJPanel.setBounds(0, 280, 1024, 400); //这个高 循环要加上60
//        resultJPanel1.setBackground(Color.gray);
        int y = 0;
        for (int i = 0; i < 10; i++) {
            JPanel resultJPanel = new JPanel();
            resultJPanel.setLayout(null);
            resultJPanel.setBounds(0, y, 1024, 60); //这个高 循环要加上60

            JLabel resultBid = new JLabel("|书籍编号" + i);
            resultBid.setFont(smallFont);
            resultBid.setBounds(68, 0, 108, 60);
            resultJPanel.add(resultBid);

            JLabel resultBookName = new JLabel("|书籍名称");
            resultBookName.setBounds(195, 0, 127, 60);
            resultBookName.setFont(smallFont);
            resultJPanel.add(resultBookName);

            JLabel resultSid = new JLabel("|学生学号");
            resultSid.setBounds(322, 0, 127, 60);
            resultSid.setFont(smallFont);
            resultJPanel.add(resultSid);

            JLabel resultStudentName = new JLabel("|学生姓名");
            resultStudentName.setBounds(449, 0, 127, 60);
            resultStudentName.setFont(smallFont);
            resultJPanel.add(resultStudentName);

            JLabel resultState = new JLabel("|是否归还");
            resultState.setBounds(576, 0, 127, 60);
            resultState.setFont(smallFont);
            resultJPanel.add(resultState);

            JLabel resultStartDate = new JLabel("|借出时间");
            resultStartDate.setBounds(703, 0, 127, 60);
            resultStartDate.setFont(smallFont);
            resultJPanel.add(resultStartDate);

            JLabel resultEndDate = new JLabel("|归还时间");
            resultEndDate.setBounds(830, 0, 127, 60);
            resultEndDate.setFont(smallFont);
            resultJPanel.add(resultEndDate);

            resultJPanel.revalidate();
            bigResultJPanel.add(resultJPanel);
            bigResultJPanel.revalidate();

            y += 60;
        }
        add(bigResultJPanel);

        y = 0;
        bigResultJPanel.removeAll();
        for (int i = 0; i < 10; i++) {
            JPanel resultJPanel = new JPanel();
            resultJPanel.setLayout(null);
            resultJPanel.setBounds(0, y, 1024, 60); //这个高 循环要加上60

            JLabel resultBid = new JLabel("|书籍编号" + 2);
            resultBid.setFont(smallFont);
            resultBid.setBounds(68, 0, 108, 60);
            resultJPanel.add(resultBid);

            JLabel resultBookName = new JLabel("|书籍名称");
            resultBookName.setBounds(195, 0, 127, 60);
            resultBookName.setFont(smallFont);
            resultJPanel.add(resultBookName);

            JLabel resultSid = new JLabel("|学生学号");
            resultSid.setBounds(322, 0, 127, 60);
            resultSid.setFont(smallFont);
            resultJPanel.add(resultSid);

            JLabel resultStudentName = new JLabel("|学生姓名");
            resultStudentName.setBounds(449, 0, 127, 60);
            resultStudentName.setFont(smallFont);
            resultJPanel.add(resultStudentName);

            JLabel resultState = new JLabel("|是否归还");
            resultState.setBounds(576, 0, 127, 60);
            resultState.setFont(smallFont);
            resultJPanel.add(resultState);

            JLabel resultStartDate = new JLabel("|借出时间");
            resultStartDate.setBounds(703, 0, 127, 60);
            resultStartDate.setFont(smallFont);
            resultJPanel.add(resultStartDate);

            JLabel resultEndDate = new JLabel("|归还时间");
            resultEndDate.setBounds(830, 0, 127, 60);
            resultEndDate.setFont(smallFont);
            resultJPanel.add(resultEndDate);

            bigResultJPanel.add(resultJPanel);
            y += 60;
        }
        add(bigResultJPanel);
        revalidate();




        DBUtils dbUtils = new DBUtils();
        dbUtils.getConnection();
        searchBtn.addActionListener(e -> {
            String book = searchJTextField.getText().trim();
            try {
                ResultSet resultSet = dbUtils.getStatement().executeQuery("SELECT * FROM book WHERE bookname LIKE '%" + book + "%'");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("bookname"));
                    System.out.println(resultSet.getString("author"));
                    System.out.println(resultSet.getString("allowance"));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });
    }
}
