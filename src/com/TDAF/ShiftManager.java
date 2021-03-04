package com.TDAF;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ShiftManager {
    private static JFrame frame = new JFrame("SHIFT MANAGER");
    private JButton createReportButton;
    private JButton setAutomaticReportButton;
    private JPanel shiftManagerPanel;
    private JButton logOutButton;
    private JButton receptionistButton;
    private JButton technicianButton;
    Login login = new Login();
    OfficeManager officeManager = new OfficeManager();

    public ShiftManager() {

        setAutomaticReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetAutomaticReport setAutomaticReport = new SetAutomaticReport();
                setAutomaticReport.main();
                frame.dispose();
            }
        });
        createReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateReport createReport = new CreateReport();
                createReport.main();
                frame.dispose();
            }
        });

        logOutButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (login.getLoggedIn().toString()=="Office Manager"){
                    logOutButton.setText("Back");
                }else{
                    logOutButton.setText("Log Out");
                }
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logOutButton.getText().equals("Back")){
                    officeManager.main();
                }
                if (logOutButton.getText().equals("Log Out")){
                    Login.start();
                }
                frame.dispose();
            }
        });

        receptionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receptionist receptionist = new Receptionist();
                receptionist.main();
                frame.dispose();
            }
        });
        technicianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Technician technician = new Technician();
                technician.main();
                frame.dispose();
            }
        });

    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ShiftManager().shiftManagerPanel);
        frame.setVisible(true);


       //Off logOutButton.setVisible(true);
    }


}
