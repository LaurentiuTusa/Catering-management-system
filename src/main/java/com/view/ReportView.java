package com.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ReportView extends JFrame{
    private JPanel reportPanel;
    private JTextField time1;
    private JTextField time2;
    private JTextField moreThanTimes;
    private JTextField moreThanTimes_3;
    private JTextField valueHigher_3;
    private JTextField yy;
    private JTextArea textArea1;
    private JButton report1Button;
    private JButton report2Button;
    private JButton report3Button;
    private JButton report4Button;
    private JTextField mm;
    private JTextField dd;

    public ReportView(){
        this.setVisible(true);
        this.setContentPane(reportPanel);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void rep1(ActionListener action) {
        report1Button.addActionListener(action);
    }

    public void rep2(ActionListener action) {
        report2Button.addActionListener(action);
    }

    public void rep3(ActionListener action) {
        report3Button.addActionListener(action);
    }

    public void rep4(ActionListener action) {
        report4Button.addActionListener(action);
    }

    public String getTime1() {
        return time1.getText();
    }

    public void setTime1(JTextField time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2.getText();
    }

    public void setTime2(JTextField time2) {
        this.time2 = time2;
    }

    public String getMoreThanTimes() {
        return moreThanTimes.getText();
    }

    public void setMoreThanTimes(JTextField moreThanTimes) {
        this.moreThanTimes = moreThanTimes;
    }

    public String getMoreThanTimes_3() {
        return moreThanTimes_3.getText();
    }

    public void setMoreThanTimes_3(JTextField moreThanTimes_3) {
        this.moreThanTimes_3 = moreThanTimes_3;
    }

    public String getValueHigher_3() {
        return valueHigher_3.getText();
    }

    public void setValueHigher_3(JTextField valueHigher_3) {
        this.valueHigher_3 = valueHigher_3;
    }

    public String getYy() {
        return yy.getText();
    }

    public void setYy(JTextField yy) {
        this.yy = yy;
    }

    public String getTextArea1() {
        return textArea1.getText();
    }

    public void refreshTextArea1() {
        textArea1.setText(" ");
    }

    public void setTextArea1(String text) {
        textArea1.append(text);
    }

    public String getMm() {
        return mm.getText();
    }

    public void setMm(JTextField mm) {
        this.mm = mm;
    }

    public String getDd() {
        return dd.getText();
    }

    public void setDd(JTextField dd) {
        this.dd = dd;
    }

}
