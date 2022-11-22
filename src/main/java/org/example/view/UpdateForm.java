package org.example.view;

import org.example.controler.UserController;
import org.example.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateForm extends JDialog {
    private JPanel contentPane;
    private JTextField id;
    private JTextField login;
    private JTextField pwd;
    private JTextField email;
    private JButton saveButton;
    private JTextField name;

    public int del_id;
    public User user;
    public UpdateForm() {
        setTitle("Update user");
        setContentPane(contentPane);
        setModal(true);
        setResizable(false);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
    }
    public void run(User user){
        this.del_id = user.getId();
        this.user = user;
        id.setText(""+user.getId());
        login.setText(user.getLogin());
        pwd.setText(user.getPwd());
        email.setText(user.getEmail());
        name.setText(user.getName());
        this.pack();
        this.setVisible(true);
    }
    public void save(ActionEvent e){
        this.user.setName(name.getText());
        this.user.setId(Integer.parseInt(id.getText()));
        this.user.setLogin(login.getText());
        this.user.setEmail(email.getText());
        this.user.setPwd(pwd.getText());
        System.out.println(this.user.toString());
        UserController.update(this.del_id,this.user);
    }
}
