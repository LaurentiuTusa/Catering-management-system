package com.business_logic;

import com.view.AdministratorView;
import com.view.ReportView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportsPresenter {
    ReportView reportView;
    DeliveryService deliveryService;

    public ReportsPresenter(ReportView reportView, DeliveryService deliveryService) {
        this.reportView = reportView;
        this.deliveryService = deliveryService;

        reportView.rep1(new Report1Action());
        reportView.rep2(new Report2Action());
        reportView.rep3(new Report3Action());
        reportView.rep4(new Report4Action());
    }

    private class Report1Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.reprot1(reportView);
        }
    }

    private class Report2Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.reprot2(reportView);
        }
    }

    private class Report3Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.reprot3(reportView);
        }
    }

    private class Report4Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deliveryService.reprot4(reportView);
        }
    }

}
