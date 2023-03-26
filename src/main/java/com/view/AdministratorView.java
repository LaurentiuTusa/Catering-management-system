package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministratorView extends JFrame/* implements IView*/{
    private JPanel administratorPanel;
    private JButton addProductButton;
    private JButton deleteProductButton;
    private JButton modifyProductButton;
    private JButton createComposedProductButton;
    private JLabel msg;
    private JButton saveChangesButton;
    private JButton reportsButton;
    private JPanel TablePanel;
    private JTextField composedTextField;
    private JTable table;

    public String getComposedTextField() {
        return composedTextField.getText();
    }

    public void setComposedTextField(String txt) {
        this.composedTextField.setText(txt);
    }

    public AdministratorView(){
        this.setVisible(true);
        this.setContentPane(administratorPanel);
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void AddProduct(ActionListener action) {
        addProductButton.addActionListener(action);
    }

    public void DeleteProduct(ActionListener action) {
        deleteProductButton.addActionListener(action);
    }

    public void ModifyProduct(ActionListener action) {
        modifyProductButton.addActionListener(action);
    }

    public void CreateComposedProduct(ActionListener action) {
        createComposedProductButton.addActionListener(action);
    }

    public void SaveChanges(ActionListener action) {
        saveChangesButton.addActionListener(action);
    }

    public void GenerateReports(ActionListener action) {
        reportsButton.addActionListener(action);
    }

    public void setMsg(String txt) {
        this.msg.setText(txt);
        this.msg.setVisible(true);
    }

    public void displayTable(Object[][] data, String[] columnNames) {
        table = new JTable(data, columnNames);
        //table.updateUI();
        TablePanel.removeAll();
        table.setPreferredScrollableViewportSize(new Dimension(750, 470));
        table.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(table);
        TablePanel.add(sp);
        TablePanel.setVisible(true);
        TablePanel.updateUI();
    }

    public JTable getTable() {
        return this.table;
    }
}
