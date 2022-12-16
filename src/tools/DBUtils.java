package tools;

import java.sql.*;

public class DBUtils {
    static final String DB_URL = "jdbc:mysql://localhost:3306/LibraryManagementSystem?&useSSL=false&serverTimezone=Asia/Shanghai";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "jet";
    Connection connection = null;
    Statement statement = null;


    //关闭链接
    public void close() {
        try {
            if (statement != null && !statement.isClosed())
                statement.close();
            if (connection != null && !connection.isClosed())
                connection.close();
            System.out.println("关闭数据库链接");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //链接数据库
    public Connection getConnection() {
        try {
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();//创建语句
        } catch (SQLException se) {
            return null;
        }
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
