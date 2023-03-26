package com.view;

import javax.swing.*;

public class EmployeeView extends JFrame{
    private JPanel EmployeePanel;

    public EmployeeView(){
        this.setVisible(true);
        this.setContentPane(EmployeePanel);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
