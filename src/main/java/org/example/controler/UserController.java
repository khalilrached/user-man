/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controler;

import org.example.configs.MyConnexion;

import java.beans.JavaBean;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.example.model.User;

/**
 *
 * @author omrani
 */

public abstract class UserController {
    private static Statement st;

    public static boolean getDBConnection(){
         try {
            st = MyConnexion.getConnection().createStatement();
         } catch (SQLException ex) {
            System.err.println(ex.getMessage());
         }
         return st != null;
    }

    public static boolean create(User obj) {
        try {
            String sql ="INSERT INTO user(name,email,login,pwd) VALUES ( '"+ obj.getName()+"','"+obj.getEmail()+"', '"+ obj.getLogin()+"','"+ obj.getPwd()+"')";
            System.out.println(sql);
            return (st.executeUpdate(sql)==1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ! User not added", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return false;
        }
    }

    public static boolean connect(String login, String pwd) {
        try {
            String sql ="SELECT * FROM user WHERE login='"+ login +"' and pwd='"+pwd +"'";
            ResultSet rs = st.executeQuery(sql);
            return rs.next();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ! User not added", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return false;
        }
    }

    public static boolean delete(int id) {
        try{
            String sql = "DELETE FROM user WHERE id="+id;
            return (st.executeUpdate(sql)==1);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<User> retrieveAll()  {
        try {
            String sql = "SELECT * FROM user";
            ArrayList<User> arrayList = new ArrayList<>();
            ResultSet data = st.executeQuery(sql);
            while (data.next()){
                User u = new User();
                u.setId(data.getInt(1));
                u.setLogin(data.getString(2));
                u.setPwd(data.getString(3));
                u.setEmail(data.getString(4));
                u.setName(data.getString(5));
                arrayList.add(u);
            }
            return arrayList;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static User retrieveById(int id) {
        try {
            String sql = "SELECT * FROM user WHERE id=" + id;
            ResultSet data = st.executeQuery(sql);
            User u = new User();
            if (data.next()){
                u.setId(data.getInt(1));
                u.setLogin(data.getString(2));
                u.setPwd(data.getString(3));
                u.setEmail(data.getString(4));
                u.setName(data.getString(5));
            }
            return u;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList<User> retrieveByKeyWord(String key) {
        try {
            String sql = "SELECT * FROM user WHERE name LIKE '%"+key+"%' OR login like '%"+key+"%'";
            ArrayList<User> arrayList = new ArrayList<>();
            ResultSet data = st.executeQuery(sql);
            while (data.next()){
                User u = new User();
                u.setId(data.getInt(1));
                u.setLogin(data.getString(2));
                u.setPwd(data.getString(3));
                u.setEmail(data.getString(4));
                u.setName(data.getString(5));
                arrayList.add(u);
            }
            return arrayList;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean update(int id, User obj) {
        try {
            String sql = "UPDATE user SET id="+obj.getId()+",login='"+obj.getLogin()+"',pwd='"+obj.getPwd()+"',email='"+obj.getEmail()+"',name='"+obj.getName()+"' WHERE id="+id;
            return (st.executeUpdate(sql)==1);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
