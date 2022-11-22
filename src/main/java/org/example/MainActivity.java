package org.example;

import org.example.controler.UserController;
import org.example.view.auth;

public class MainActivity {
    public static void main(String[] args) {
        UserController.getDBConnection();
        auth.main(null);
    }
}