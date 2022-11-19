/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controler;

import org.example.configs.MyConnexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.example.model.User;

/**
 *
 * @author omrani
 */
public class UserControler implements I_CRUD<User>
{

    public  MyConnexion mc = MyConnexion.getInstance();
    public Statement st ;

    public UserControler (){
         try {
            st = MyConnexion.getConnection().createStatement();
         } catch (SQLException ex) {
            System.err.println(ex.getMessage());

         }

    }


    @Override
    public boolean create(User obj) {
        try {
            String sql ="INSERT INTO user VALUES ( name ='"+ obj.getName()+"',email ='"+obj.getEmail()+"', login ='"+ obj.getLogin()+"',pwd ='"+ obj.getPwd()+"')";
            return (st.executeUpdate(sql)==1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ! User not added", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return false;
        }
    }



    public boolean connect(String login, String pwd) {
      try {
            String sql ="SELECT * FROM user WHERE login='"+ login +"' and pwd='"+pwd +"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
                return true;
            else
                return false;
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ! User not added", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try{
            String sql = "DELETE FROM user WHERE id="+id;
            return (st.executeUpdate(sql)==1);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<User> retrieveAll()  {
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

    @Override
    public User retrieveById(int id) {
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

    @Override
    public ArrayList<User> retrieveByKeyWord(String key) {
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

    @Override
    public boolean update(int id, User obj) {
        try {
            String sql = "UPDATE user SET id="+obj.getId()+",login='"+obj.getLogin()+"',pwd='"+obj.getPwd()+"',email='"+obj.getEmail()+"',name='"+obj.getName()+"' WHERE id="+id;
            return (st.executeUpdate(sql)==1);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
