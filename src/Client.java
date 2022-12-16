import entity.MenuData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Client extends JFrame {
    public List<MenuData> serial = new ArrayList<>();
    private Font font = new Font("宋体", Font.BOLD, 20);

    //菜单跳转
    public static void Show(JMenu item, JFrame frame, String s) {
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    @SuppressWarnings("deprecation")
                    Object object = Class.forName(s).newInstance();//forName(String className)根据类名返回类的对象
                    frame.getContentPane().removeAll();
                    frame.add((Component) object);
                    frame.revalidate();
                    frame.repaint();
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public Client() {
        getSerial();//获取菜单
        setTitle("图书管理系统");
        setSize(1024, 768);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();//菜单栏
        setJMenuBar(menuBar);//设置为窗体的菜单栏
        for (MenuData menuData : serial) {
            JMenu menu = new JMenu(menuData.getTitle());
            menu.setFont(font);
            menuBar.add(menu);
            Show(menu, this, menuData.getClassName());

        }
        add(new Welcome());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void getSerial() {
        //0=空；1=管理员；2=普通用户
        if (LibraryManagement.userLevel == 2) {
            serial.add(new MenuData("主界面","Welcome"));
            serial.add(new MenuData("图书查询","StudentBookInquiry"));
            serial.add(new MenuData("图书借还","StudentBooksBorrowed"));
            serial.add(new MenuData("账号管理","StudentAccountManagement"));
        } else if (LibraryManagement.userLevel == 1) {
            serial.add(new MenuData("借书记录","AdminBorrowBooksRecord"));
            serial.add(new MenuData("图书新增","AdminBookInsert"));
            serial.add(new MenuData("图书删改","AdminBookRevised"));
            serial.add(new MenuData("账户管理","AdminAccountManagement"));
        }
    }
}
