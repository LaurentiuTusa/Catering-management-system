package com.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NewProductView extends JFrame{
    private JPanel newProductPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton submitButton;

    public NewProductView(){
        this.setVisible(true);
        this.setContentPane(newProductPanel);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Execute(ActionListener action) {
        submitButton.addActionListener(action);
    }

    public String getTextField1() {
        return textField1.getText();
    }

    public String getTextField2() {
        return textField2.getText();
    }

    public String getTextField3() {
        return textField3.getText();
    }

    public String getTextField4() {
        return textField4.getText();
    }

    public String getTextField5() {
        return textField5.getText();
    }

    public String getTextField6() {
        return textField6.getText();
    }

    public String getTextField7() {
        return textField7.getText();
    }
}
