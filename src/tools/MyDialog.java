package tools;

import javax.swing.*;

public class MyDialog extends JDialog {
    public void init(String msg) {
        setVisible(true);
        setBounds(0, 0, 200, 200);
        JLabel label = new JLabel(msg);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
        setLocationRelativeTo(null);
    }
}
