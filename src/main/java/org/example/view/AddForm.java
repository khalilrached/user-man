package org.example.view;

import org.example.controler.UserControler;
import org.example.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddForm extends JDialog {
    private JPanel contentPane;
    private JTextField id;
    private JTextField login;
    private JTextField email;
    private JTextField pwd;
    private JButton button1;
    private JTextField name;
    private JButton buttonOK;

    public AddForm() {
        setContentPane(contentPane);
        pack();
        setResizable(false);
        setModal(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
    }

    public void run(){
        id.setText("id");
        login.setText("login");
        email.setText("login");
        pwd.setText("email");
        name.setText("name");
        this.setVisible(true);
    }

    public void save(ActionEvent e){
        User user = new User();
        user.setName(name.getText());
        user.setId(Integer.parseInt(id.getText()));
        user.setLogin(login.getText());
        user.setEmail(email.getText());
        user.setPwd(pwd.getText());
        System.out.println(user.toString());
        if(new UserControler().create(user)){
            userList.refresh();
            this.setVisible(false);
        }
    }

}
