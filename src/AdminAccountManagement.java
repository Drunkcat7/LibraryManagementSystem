import javax.swing.*;
import java.awt.*;

public class AdminAccountManagement extends JPanel {
    private Font bigFont = new Font("宋体", Font.BOLD, 40);
    private Font titleFont = new Font("宋体", Font.BOLD, 70);
    public AdminAccountManagement() {
        setLayout(null);
        JLabel jLabel = new JLabel("管理员账号管理", JLabel.CENTER);
        jLabel.setFont(titleFont);
        jLabel.setBounds(0, 0, 1024, 100);
        add(jLabel);


        JPanel usernameJpanel = new JPanel();
        usernameJpanel.setLayout(null);
        usernameJpanel.setBounds(0, 140, 1024, 60);
        JLabel usernameJLabel = new JLabel("账号：");
        usernameJLabel.setFont(bigFont);
        usernameJLabel.setBounds(300, 0, 1024, 60);
        usernameJpanel.add(usernameJLabel);
        JLabel username = new JLabel("admin");
        username.setBounds(400, 0, 1024, 60);
        username.setFont(bigFont);
        usernameJpanel.add(username);
        add(usernameJpanel);

        JPanel psdJpanel = new JPanel();
        psdJpanel.setLayout(null);
        psdJpanel.setBounds(0, 220, 1024, 60);
        JLabel psdJLabel = new JLabel("密码：");
        psdJLabel.setFont(bigFont);
        psdJLabel.setBounds(300, 0, 1024, 60);
        psdJpanel.add(psdJLabel);
        JTextField psd = new JTextField(10);
        psd.setText("123456");
        psd.setBounds(400, 0, 350, 60);
        psd.setFont(bigFont);
        psdJpanel.add(psd);
        add(psdJpanel);


        JButton resetPsd = new JButton("修改密码");
        resetPsd.setFont(bigFont);
        resetPsd.setBounds(300, 300, 450, 60);
        add(resetPsd);

        JButton logOut = new JButton("退出登陆");
        logOut.setFont(bigFont);
        logOut.setBounds(300, 380, 450, 60);
        add(logOut);
    }
}
