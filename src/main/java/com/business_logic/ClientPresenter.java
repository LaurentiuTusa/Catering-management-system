package com.business_logic;

import com.data.ImportData;
import com.view.AdministratorView;
import com.view.ClientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ClientPresenter {
    ClientView clientView;
    DeliveryService deliveryService;
    String username;

    public ClientPresenter(ClientView clientView, DeliveryService deliveryService, String username) {
        this.clientView = clientView;
        this.deliveryService = deliveryService;
        this.username = username;

        clientView.search(new SearchAction());
        clientView.order(new OrderAction());
        clientView.addItem(new AddItemAction());
        clientView.viewOrder(new ViewOrderAction());
    }

    private class SearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.searchProduct(clientView);
        }
    }

    private class OrderAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.createOrder(clientView, username);
        }
    }

    private class AddItemAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.addItemToOrder(clientView);
        }
    }

    private class ViewOrderAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.viewOrder(clientView);
        }
    }
}
