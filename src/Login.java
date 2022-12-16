import tools.DBUtils;
import tools.MyDialog;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Login extends JFrame {
    private Font bigFont = new Font("宋体", 18, 18);
    private Font smallFont = new Font("宋体", 13, 13);
    private final int WIDTH = 600;
    private final int HEIGHT = 290;


    public Login() {

        setTitle("图书管理系统");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setLayout(null);
        dispose();
        new Client();

    /*    JLabel title = new JLabel("图书管理系统", JLabel.CENTER);
        title.setFont(new Font("宋体", Font.BOLD, 26));
        title.setBounds(0, 30, WIDTH, 50);


        //账号
        JLabel userLabel = new JLabel("账号：", JLabel.RIGHT);
        userLabel.setFont(bigFont);
        JTextField userField = new JTextField(10);
        userField.setFont(bigFont);
        JPanel userJpanel = new JPanel();
        userJpanel.add(userLabel);
        userJpanel.add(userField);
        userJpanel.setOpaque(false);
        userJpanel.setBounds(0, 80, WIDTH, 40);

        //密码
        JLabel passwordLabel = new JLabel("密码：", JLabel.RIGHT);
        passwordLabel.setFont(bigFont);
        JTextField passwordField = new JTextField(10);
        passwordField.setFont(bigFont);
        JPanel passwordJpanel = new JPanel();
        passwordJpanel.add(passwordLabel);
        passwordJpanel.add(passwordField);
        passwordJpanel.setOpaque(false);
        passwordJpanel.setBounds(0, 120, WIDTH, 40);

        //单选框
        JPanel chooseJpanel = new JPanel();
        JRadioButton studentButton = new JRadioButton("普通用户");
        JRadioButton adminButton = new JRadioButton("管理员");
        ButtonGroup group = new ButtonGroup();
        group.add(studentButton);
        group.add(adminButton);
        chooseJpanel.add(studentButton);
        chooseJpanel.add(adminButton);
        chooseJpanel.setOpaque(false);
        chooseJpanel.setBounds(0, 160, WIDTH, 30);

        //登录
        JPanel buttonJpanel = new JPanel();
        JButton button = new JButton("Login");
        button.setPreferredSize(new Dimension(100, 40));
        buttonJpanel.add(button);
        buttonJpanel.setOpaque(false);
        buttonJpanel.setBounds(0, 190, WIDTH, 50);

        //录入结果集
        add(title);
        add(userJpanel);
        add(passwordJpanel);
        add(chooseJpanel);
        add(buttonJpanel);

        //背景图片
        ImageIcon imageIcon = new ImageIcon("src/image/loginBg.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, WIDTH, HEIGHT);
        add(imageLabel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        //登录事件
        button.addActionListener(e -> {
            String user = userField.getText();
            String password = passwordField.getText();
            if (user.length() == 0 || password.length() == 0) {
                System.out.println("不能为空");
                return;
            }
            //链接数据库
            DBUtils dbUtils = new DBUtils();
            dbUtils.getConnection();
            try {
                //追加判断是否为管理员
                String columnLabel;
                ResultSet resultSet = null;
                String sql;
                if (studentButton.isSelected()) {//普通用户
                    columnLabel = "student_id";
                    sql = "SELECT * FROM student WHERE student_id = " + user + " and password = " + password;
                    LibraryManagement.userLevel = 2;
                } else if (adminButton.isSelected()) {//管理员
                    columnLabel = "username";
                    sql = "SELECT * FROM admin WHERE username = '" + user + "' and password = " + password;
                    LibraryManagement.userLevel = 1;
                } else {
                    new MyDialog().init("请选择登录类型");
                    return;
                }

//                System.out.println(sql);
                resultSet = dbUtils.getStatement().executeQuery(sql);
                if (resultSet.next()) {
                    System.out.println("登录成功");
                    LibraryManagement.userID = resultSet.getString(columnLabel);
                    System.out.println(LibraryManagement.userLevel);
                    dispose();
                    new Client();
                    dbUtils.close();
                    resultSet.close();
                    return;
                }
                new MyDialog().init("登录失败");
                LibraryManagement.userLevel = 0;


            } catch (Exception ex) {
                new MyDialog().init("登录失败");
                LibraryManagement.userLevel = 0;
                throw new RuntimeException(ex);
            }
        });*/

    }
}
