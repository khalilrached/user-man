package org.example.utils;

import org.example.model.User;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableParser {
    public static DefaultTableModel parse(ArrayList<User> users){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Login");
        model.addColumn("Password");
        for (User u : users) {
            Object[] row = new Object[]{u.getId(), u.getName(), u.getEmail(), u.getLogin(), u.getPwd() };
            model.addRow(row);
        }
        return model;
    }
}
