package com.blb.jdbc;

import com.blb.User;
import com.blb.Utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcTest {
    Connection cn = null;
    PreparedStatement statement=null;
    ResultSet resultSet=null;
    //查询单个
    public User foundone(String username) throws SQLException, ClassNotFoundException {
        User user=new User();
        cn= JDBCUtils.getConnection();
        statement=cn.prepareStatement("select * from `db_12-30`.t_user where username=?");
        statement.setString(1,username);
        return getUser(user);
    }
    //用id查询单个
    public User foundoneById(Long id) throws SQLException, ClassNotFoundException {
        User user=new User();
        cn= JDBCUtils.getConnection();
        statement=cn.prepareStatement("select * from `db_12-30`.t_user where id="+id);
        return getUser(user);
    }

    private User getUser(User user) throws SQLException {
        resultSet=statement.executeQuery();
        while (resultSet.next()){
            user.setId(resultSet.getLong("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getInt("age"));
        }
        JDBCUtils.closere(resultSet,statement,cn);
        return user;
    }

    //查询所有
    public List<User> foundAll(){

        List<User> list = new ArrayList<User>();
        User user =null;
        ResultSet rs = null;
        Statement st = null;
        Connection cn = null;
        try {
            cn=JDBCUtils.getConnection();
            //获取语句对象
            st = cn.createStatement();
            rs = st.executeQuery("select * from t_user ");
            while(rs.next()){
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closere(rs,st,cn);
        }

        return list;
    }
//修改
    public void update(Long id, String username, String password,int age) {
        try {
            cn=JDBCUtils.getConnection();
            //获取语句对象
            statement = cn.prepareStatement("update `db_12-30`.t_user set username='"+username+"',password='"+password+"',age='"+age+"' where  id="+id);
            statement.executeUpdate();
            System.out.println("修改成功");
    } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.closere(null,statement,cn);
        }
    }

    //添加用户
    public void add(String username,String password,int age){
        try {
            cn=JDBCUtils.getConnection();
            statement=cn.prepareStatement("insert into `db_12-30`.t_user(username, password, age) values (?,?,?)");
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setInt(3,age);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closere(null,statement,cn);
        }


    }
//删除
    public void delete(Long id) throws ClassNotFoundException {
        cn=JDBCUtils.getConnection();
        try {
            statement=cn.prepareStatement("delete from t_user where id="+id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.closere(null,statement,cn);
        }
    }
}
