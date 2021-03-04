package com.TDAF;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Technician {
    private static JFrame frame = new JFrame("TECHNICIAN");
    private JButton createTaskButton;
    private JButton viewTaskButton;
    private JButton deleteTaskButton;
    private JPanel technicianPanel;
    private JButton logOutButton;
    Login login = new Login();
    OfficeManager officeManager = new OfficeManager();

    public Technician() {
        createTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateTask createTask = new CreateTask();
                createTask.main();
                frame.dispose();
            }
        });
        viewTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTasks viewTasks = new ViewTasks();
                viewTasks.main();
                frame.dispose();
            }
        });
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTask deleteTask = new DeleteTask();
                deleteTask.main();
                frame.dispose();
            }
        });
        /*logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"LATE PAYMENT FOR JOB ID: ACC0001 ");
                Login login = new Login();
                login.start();
                frame.dispose();
            }
        });*/
        logOutButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (login.getLoggedIn().equals("Office Manager")){
                    logOutButton.setText("Back");
                    JOptionPane.showMessageDialog(frame,"HERE1");

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
    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        logOutButton.setText("Back");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Technician().technicianPanel);
        frame.setVisible(true);
    }
}
