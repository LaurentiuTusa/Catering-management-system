package com.business_logic;

import com.data.ImportData;
import com.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AdministratorPresenter {
    AdministratorView adminView;
    DeliveryService deliveryService;

    public AdministratorPresenter(AdministratorView adminView, DeliveryService deliveryService) {
        this.adminView = adminView;
        this.deliveryService = deliveryService;

        adminView.AddProduct(new AddAction());
        adminView.DeleteProduct(new DeleteAction());
        adminView.ModifyProduct(new ModifyAction());
        adminView.CreateComposedProduct(new CreateComposedAction());
        adminView.SaveChanges(new SerializeDataAction());
        adminView.GenerateReports(new ReportsAction());
        deliveryService.showTable(adminView);
    }


    private class AddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.addProduct(adminView);
        }
    }

    private class DeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.deleteProduct(adminView);
        }
    }

    private class ModifyAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.modifyProduct(adminView);
        }
    }

    private class CreateComposedAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.createCompoundProduct(adminView);
        }
    }

    private class SerializeDataAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.serializeChanges(adminView);
        }
    }

    private class ReportsAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ReportsPresenter reportPresenter = new ReportsPresenter(new ReportView(), deliveryService);
            //deliveryService.generateReports(new ReportView());
        }
    }
}
