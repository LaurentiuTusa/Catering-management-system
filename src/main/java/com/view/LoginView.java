package com.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame{
    private JPanel loginPanel;
    private JTextField userNameField;
    private JPasswordField passwordField1;
    private JButton submitButton;
    private JLabel errorMsg;
    private JCheckBox employeeCheckBox;
    private JButton registerButton;
    private JLabel errorReg;

    public LoginView(){
        this.setVisible(true);
        this.setContentPane(loginPanel);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.errorMsg.setVisible(false);
        this.errorReg.setVisible(false);
    }

    public void logIn(ActionListener action) {
        submitButton.addActionListener(action);
    }

    public void register(ActionListener action) {
        registerButton.addActionListener(action);
    }

    public String getUserNameField() {
        return userNameField.getText();
    }

    public String getPasswordField1() {
        return passwordField1.getText();
    }

    public boolean isEmployee(){
        return employeeCheckBox.isSelected();
    }

    public void setErrorReg(boolean a){
        errorReg.setVisible(a);
    }

    public void setErrorMsg(boolean a){
        errorMsg.setVisible(a);
    }
}
