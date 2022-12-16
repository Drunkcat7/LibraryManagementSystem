
import tools.DBUtils;
import tools.MyDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentAccountManagement extends JPanel {
    private Font bigFont = new Font("宋体", Font.BOLD, 40);
    private Font titleFont = new Font("宋体", Font.BOLD, 70);
    private String userName;
    private String userPassword;

    public StudentAccountManagement(JFrame jFrame) {
        init();
        setLayout(null);
        JLabel jLabel = new JLabel("账号管理", JLabel.CENTER);
        jLabel.setFont(titleFont);
        jLabel.setBounds(0, 0, 1024, 100);
        add(jLabel);

        JPanel nameJpanel = new JPanel();
        nameJpanel.setLayout(null);
        nameJpanel.setBounds(0, 140, 1024, 60);
        JLabel nameJLabel = new JLabel("姓名：");
        nameJLabel.setFont(bigFont);
        nameJLabel.setBounds(300, 0, 1024, 60);
        nameJpanel.add(nameJLabel);
        JLabel name = new JLabel(userName);
        name.setBounds(400, 0, 1024, 60);
        name.setFont(bigFont);
        nameJpanel.add(name);
        add(nameJpanel);

        JPanel sidJpanel = new JPanel();
        sidJpanel.setLayout(null);
        sidJpanel.setBounds(0, 220, 1024, 60);
        JLabel sidJLabel = new JLabel("学号：");
        sidJLabel.setFont(bigFont);
        sidJLabel.setBounds(300, 0, 1024, 60);
        sidJpanel.add(sidJLabel);
        JLabel sid = new JLabel(LibraryManagement.userID);
        sid.setBounds(400, 0, 1024, 60);
        sid.setFont(bigFont);
        sidJpanel.add(sid);
        add(sidJpanel);

        JPanel psdJpanel = new JPanel();
        psdJpanel.setLayout(null);
        psdJpanel.setBounds(0, 300, 1024, 60);
        JLabel psdJLabel = new JLabel("密码：");
        psdJLabel.setFont(bigFont);
        psdJLabel.setBounds(300, 0, 1024, 60);
        psdJpanel.add(psdJLabel);
        JTextField psd = new JTextField(10);
        psd.setText(userPassword);
        psd.setBounds(400, 0, 350, 60);
        psd.setFont(bigFont);
        psdJpanel.add(psd);
        add(psdJpanel);


        JButton resetPsd = new JButton("修改密码");
        resetPsd.setFont(bigFont);
        resetPsd.setBounds(300, 380, 450, 60);
        add(resetPsd);

        JButton logOut = new JButton("退出登陆");
        logOut.setFont(bigFont);
        logOut.setBounds(300, 460, 450, 60);
        add(logOut);

        //修改密码
        resetPsd.addActionListener(e -> {
            String password = psd.getText().trim();
            if (password.length() == 0) {
                new MyDialog().init("密码不能为空");
                return;
            }
            DBUtils dbUtils = new DBUtils();
            dbUtils.getConnection();
            try {
                String sql = "UPDATE student set password = " + password + " WHERE student_id = '" + LibraryManagement.userID + "'";
                int i = dbUtils.getStatement().executeUpdate(sql);
                if (i != 0) {
                    new MyDialog().init("修改密码成功");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            dbUtils.close();
        });

        //退出登录
        logOut.addActionListener(e -> {
            this.setVisible(false);
            jFrame.dispose();
            new Login();
        });
    }

    public void init() {
        DBUtils dbUtils = new DBUtils();
        dbUtils.getConnection();
        try {
            ResultSet resultSet = dbUtils.getStatement().executeQuery("SELECT  * FROM student WHERE student_id = '"
                    + LibraryManagement.userID + "'");
            if (resultSet.next()) {
                userName = resultSet.getString("name");
                userPassword = resultSet.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbUtils.close();
    }
}
