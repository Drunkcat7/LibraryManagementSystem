import tools.JTextFieldHintListener;

import javax.swing.*;
import java.awt.*;

public class AdminAccountManagement extends JPanel {
    private Font smallFont = new Font("宋体", Font.BOLD, 20);
    private Font bigFont = new Font("宋体", Font.BOLD, 40);
    private Font titleFont = new Font("宋体", Font.BOLD, 70);
    public AdminAccountManagement() {
        setLayout(null);
        JLabel jLabel = new JLabel("管理员账号管理", JLabel.CENTER);
        jLabel.setFont(titleFont);
        jLabel.setBounds(0, 0, 1024, 100);
        add(jLabel);

        JPanel topJpanel = new JPanel();
        topJpanel.setLayout(null);
        topJpanel.setBounds(0, 100, 1024, 60);

        JLabel sid = new JLabel("|学生学号");
        sid.setBounds(195, 0, 254, 60);
        sid.setFont(smallFont);
        topJpanel.add(sid);

        JLabel sName = new JLabel("|学生姓名");
        sName.setBounds(449, 0, 254, 60);
        sName.setFont(smallFont);
        topJpanel.add(sName);

        JLabel psd = new JLabel("|学生密码");
        psd.setBounds(703, 0, 254, 60);
        psd.setFont(smallFont);
        topJpanel.add(psd);
        add(topJpanel);

        JPanel userJpanel = new JPanel(); //下面大的框框
        userJpanel.setLayout(null);
        userJpanel.setBounds(0, 160, 1024, 360);
//        userJpanel.setBackground(Color.BLACK);


        // 测试数据 （循环）-————————-——————————————————————————————————
        int y = 0;
        for (int i= 0; i < 10; i++){
            setLayout(null);
            JLabel resultSid = new JLabel("|学生学号");
            resultSid.setBounds(195, y, 254, 60);
            resultSid.setFont(smallFont);
            userJpanel.add(resultSid);

            JLabel resultSName = new JLabel("|学生姓名");
            resultSName.setBounds(449, y, 254, 60);
            resultSName.setFont(smallFont);
            userJpanel.add(resultSName);

            JLabel resultPsd = new JLabel("|学生密码");
            resultPsd.setBounds(703, y, 254, 60);
            resultPsd.setFont(smallFont);
            userJpanel.add(resultPsd);
            y += 60;
        }
        add(userJpanel);


//        520
        JPanel inputJPanel = new JPanel();
        inputJPanel.setLayout(null);
        inputJPanel.setBounds(0, 520, 1024, 60);
//        inputJPanel.setBackground(Color.BLACK);

        JTextField sidJTextField = new JTextField(10);
        sidJTextField.setBounds(195, 0, 200, 60);
        sidJTextField.addFocusListener(new JTextFieldHintListener(sidJTextField, "请输入学号"));
        sidJTextField.setFont(smallFont);

        JTextField sNameJTextField = new JTextField(10);
        sNameJTextField.setBounds(405, 0, 200, 60);
        sNameJTextField.addFocusListener(new JTextFieldHintListener(sNameJTextField, "请输入姓名"));
        sNameJTextField.setFont(smallFont);

        JTextField psdJTextField = new JTextField(10);
        psdJTextField.setBounds(615, 0, 200, 60);
        psdJTextField.addFocusListener(new JTextFieldHintListener(psdJTextField, "请输入密码"));
        psdJTextField.setFont(smallFont);

        inputJPanel.add(sidJTextField);
        inputJPanel.add(sNameJTextField);
        inputJPanel.add(psdJTextField);
        add(inputJPanel);


        JPanel btnJPanel = new JPanel();
        btnJPanel.setLayout(null);
        btnJPanel.setBounds(0, 580, 1024, 60);
//        inputJPanel.setBackground(Color.BLACK);

        JButton insertBtn = new JButton("新增");
        insertBtn.setBounds(195, 0, 200, 60);
        insertBtn.setFont(smallFont);

        JButton resetBtn = new JButton("修改");
        resetBtn.setBounds(405, 0, 200, 60);
        resetBtn.setFont(smallFont);

        JButton deleteBtn = new JButton("通过学号删除");
        deleteBtn.setBounds(615, 0, 200, 60);
        deleteBtn.setFont(smallFont);

        btnJPanel.add(insertBtn);
        btnJPanel.add(resetBtn);
        btnJPanel.add(deleteBtn);
        add(btnJPanel);


    }
}
