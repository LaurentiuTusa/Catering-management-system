package com.business_logic;

import com.data.Client;
import com.data.ImportData;
import com.view.AdministratorView;
import com.view.ClientView;
import com.view.EmployeeView;
import com.view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * Class that handles the login
 * user can be admin, client or employee
 */
public class LoginPresenter {
    private final LoginView loginView;

    public LoginPresenter (LoginView loginView){
        this.loginView = loginView;

        loginView.logIn(new LoginAction());
        loginView.register(new RegisterAction());
    }

    private class LoginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //System.out.println(loginView.getUserNameField() +" "+ loginView.getPasswordField1());
            if(loginView.getUserNameField().equals("a") && loginView.getPasswordField1().equals("a")){
                try {//open for administrator
                    ImportData importData = new ImportData(new HashMap<String, MenuItem>(), new HashMap<Order, List<MenuItem>>());
                    DeliveryService deliveryService = new DeliveryService(importData.getMap(), importData.getOrderMap());

                    AdministratorPresenter adminPresenter = new AdministratorPresenter(new AdministratorView(), deliveryService);
                    loginView.dispose();
                } catch (IOException e) {
                    System.out.println("Error at data fetch");
                    e.printStackTrace();
                }
            }
            else{
                if(loginView.isEmployee()){
                    EmployeeView employeeView = new EmployeeView();//presenter, not view
                    loginView.dispose();
                } else {//deserialize in order to verify account
                    Client c = null;
                    try {
                        FileInputStream fileIn = new FileInputStream(loginView.getUserNameField() + ".ser");
                        ObjectInputStream in = new ObjectInputStream(fileIn);
                        c = (Client) in.readObject();
                        in.close();
                        fileIn.close();
                        if(c.getPassword().equals(loginView.getPasswordField1()) && !(loginView.getUserNameField().equals("a"))) {
                            ImportData importData = new ImportData(new HashMap<String, MenuItem>(), new HashMap<Order, List<MenuItem>>());
                            DeliveryService deliveryService = new DeliveryService(importData.getMap(), importData.getOrderMap());
                            ClientPresenter clientPresenter = new ClientPresenter(new ClientView(), deliveryService, c.getUsername());
                            loginView.dispose();
                        } else throw new FileNotFoundException();
                    } catch (FileNotFoundException e) {//nonexistent client
                        e.printStackTrace();
                        loginView.setErrorMsg(true);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private class RegisterAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //create new user or employee
            if(loginView.isEmployee()){
                //create new employee
                EmployeeView employeeView = new EmployeeView();//presenter, not view
                loginView.dispose();
            } else {
                //create new client
                try {
                    if(!(loginView.getUserNameField().equals("a")) && !(loginView.getPasswordField1().equals("a"))){
                        Client c = new Client(loginView.getUserNameField(), loginView.getPasswordField1());
                        FileOutputStream fileOut = new FileOutputStream(loginView.getUserNameField() + ".ser");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(c);
                        out.close();
                        fileOut.close();
                        ImportData importData = new ImportData(new HashMap<String, MenuItem>(), new HashMap<Order, List<MenuItem>>());
                        DeliveryService deliveryService = new DeliveryService(importData.getMap(), importData.getOrderMap());
                        ClientPresenter clientPresenter = new ClientPresenter(new ClientView(), deliveryService, c.getUsername());
                        loginView.dispose();
                    } else throw new IOException();
                } catch (IOException e) {
                    System.out.println("Unable to register Client");
                    loginView.setErrorReg(true);
                    e.printStackTrace();
                }
            }
        }
    }
}
