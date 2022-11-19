/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.example.controler;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author omrani
 */
public interface I_CRUD<T> {
    
    boolean create ( T obj);
    boolean update (int id, T obj);
    boolean delete (int id);
    ArrayList<T> retrieveAll () throws SQLException;
    T retrieveById (int id);
    ArrayList<T> retrieveByKeyWord (String key);
}
