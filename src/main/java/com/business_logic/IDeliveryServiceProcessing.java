package com.business_logic;

import com.view.AdministratorView;
import com.view.ClientView;
import com.view.ReportView;

/**
 * Interface DeliveryService
 * It holds all the accessible methods for admin and client types of users
 *
 */
public interface IDeliveryServiceProcessing {
    public void addProduct(AdministratorView adminView);
    public void modifyProduct(AdministratorView adminView);
    public void deleteProduct(AdministratorView adminView);
    public void serializeChanges(AdministratorView adminView);
    public void createCompoundProduct(AdministratorView adminView);
    public void reprot1(ReportView reportView);
    public void reprot2(ReportView reportView);
    public void reprot3(ReportView reportView);
    public void reprot4(ReportView reportView);
    public void searchProduct(ClientView clientView);
    public void createOrder(ClientView clientView, String username);
    public void addItemToOrder(ClientView clientView);
    public void viewOrder(ClientView clientView);
}
