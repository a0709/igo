package com.blb.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static InputStream is = null;
    private static Properties properties = null;
    static {
        is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties = new Properties();
        try {
            properties.load(is);
            Class.forName(properties.getProperty("classname"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //获取连接
    public static Connection getConnection() throws ClassNotFoundException {
        Connection conn=null;
        String url=properties.getProperty("url");
        String username=properties.getProperty("user");
        String password=properties.getProperty("password");
        try {
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("JDBCUtil创建数据库连接报错");
        }
        return conn;

    }
   /* public static Connection getConnection() {
        Connection conn=null;
        String username = properties.getProperty("user");
        String url=properties.getProperty("url");
        String password=properties.getProperty("password");
        try {
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("JDBCUtil创建数据库连接报错");
        }
        return conn;

    }*/
    //关流
    public static void closere(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
