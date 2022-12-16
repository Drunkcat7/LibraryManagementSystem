import javax.swing.*;
import java.awt.*;

public class Welcome extends JPanel {
    private Font font = new Font("宋体", Font.BOLD, 70);
    public Welcome() {
        JLabel jLabel = new JLabel("欢迎登陆图书管理系统");
        jLabel.setFont(font);
        jLabel.setBounds(230, 50, 1000,200);
        add(jLabel);
    }
}
