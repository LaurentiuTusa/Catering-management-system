package com.view;

import com.business_logic.MenuItem;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ClientView extends JFrame/* implements IView*/{
    private JPanel ClientPanel;
    private JPanel ShowProductsPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton searchButton;
    private JScrollPane scrollPane;
    private JTextField textField7;
    private JButton orderButton;
    private JButton addItemButton;
    private JButton viewOrderButton;
    private JLabel msg;

    public ClientView(){
        this.setVisible(true);
        this.setContentPane(ClientPanel);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scrollPane.createVerticalScrollBar();
        ShowProductsPanel.setLayout(new BoxLayout(ShowProductsPanel,BoxLayout.Y_AXIS));

    }

    public JRadioButton showItem(String name){
        JRadioButton b = new JRadioButton(name);
        ShowProductsPanel.add(b);
        ShowProductsPanel.updateUI();
        return b;
    }

    public void showList(MenuItem b) {
        JLabel l = new JLabel(b.objToString());
        ShowProductsPanel.add(l);
        ShowProductsPanel.updateUI();
    }

    public void setMsg (String t) {
        msg.setText(t);
    }

    public void clearShowPanel(){
        ShowProductsPanel.removeAll();
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

    public void search(ActionListener action) {
        searchButton.addActionListener(action);
    }

    public void order(ActionListener action) {
        orderButton.addActionListener(action);
    }

    public void addItem(ActionListener action) {
        addItemButton.addActionListener(action);
    }

    public void viewOrder(ActionListener action) {
        viewOrderButton.addActionListener(action);
    }
}
