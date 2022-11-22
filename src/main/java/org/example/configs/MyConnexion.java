/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.configs;

import java.beans.JavaBean;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author omrani
 */
public class MyConnexion {
    
    private static String url = "jdbc:mysql://localhost:3306/db_polytech_gl4_2022";
    private static String login = "root";
    private static String pwd = "";
    
    private static Connection connection;
    
    
    
    public static void init() {
        try {
          
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,login,pwd);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Serveur n'est pas démarrer !\n Merci de lancer le serveur", "Erreur de connection au serveur", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public static Connection getConnection() {
        if(connection == null) init();
        return connection;
    }    

}
