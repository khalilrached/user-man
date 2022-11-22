/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.configs;

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

    private String url="jdbc:mysql://localhost:3306/db_polytech_gl4_2022?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String login="root";
    private String pwd="";

    private static Connection connection;

    private static MyConnexion instance =null;



    private MyConnexion() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url,this.login,this.pwd);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Serveur n'est pas démarrer !\n Merci de lancer le serveur", "Erreur de connection au serveur", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Serveur n'est pas démarrer !\n Merci de lancer le serveur", "Erreur de connection au serveur", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

    public static MyConnexion getInstance(){
        if(instance == null){
            instance = new MyConnexion();
        }
        return instance;
    }


    public static Connection getConnection() {
        return connection;
    }


}
