package com.TDAF;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Receptionist {
    private static JFrame frame = new JFrame("RECEPTIONIST");
    private JButton createCustomerAccountButton;
    private JButton viewCustomerAccountButton;
    private JButton createJobButton;
    private JButton recordPaymentButton;
    private JPanel receptionistPanel;
    private JButton button1;

    public void setButton1(String button1) {
        this.button1.setText(button1);
    }

    public Receptionist() {
        createCustomerAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateCustomerAccount createCustomerAccount = new CreateCustomerAccount();
                createCustomerAccount.main();
                frame.dispose();
            }
        });
        viewCustomerAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCustomerAccount viewCustomerAccount = new ViewCustomerAccount();
                viewCustomerAccount.main();
                frame.dispose();
            }
        });
        createJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JobCreation jobCreation = new JobCreation();
                jobCreation.main();
                frame.dispose();
            }
        });
        recordPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordPayment recordPayment = new RecordPayment();
                recordPayment.main();
                frame.dispose();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                OfficeManager officeManager = new OfficeManager();
                if (button1.getText().equals("Back")){
                    officeManager.main();
                }else{
                    login.start();
                }
                frame.dispose();
            }
        });


    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Receptionist().receptionistPanel);
        frame.setVisible(true);
    }
}
