package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    private JLabel titleLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private static JFrame frame = new JFrame("BAPERS");
    private JPanel loginPanel;
    private String path = "C:\\Users\\TDAF\\Desktop\\JAVA\\Team Project\\filename.txt";
    private File myFile = new File(path);
    private Scanner reader;
    private String data;
    private String[] staff;
    private static int width = 550;
    private static int height = 400;
    public static String loggedIn;

    public String getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(String loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                try{
                    reader = new Scanner(myFile);
                    while (reader.hasNextLine()){
                        data = reader.nextLine();
                        staff = data.split(",");
                        if (staff[1].equals(username) && staff[2].equals(password)){
                            if (staff[0].equals("Office Manager")){
                                OfficeManager officeManager = new OfficeManager();
                                officeManager.main();
                            }
                            if (staff[0].equals("Receptionist")){
                                Receptionist receptionist = new Receptionist();
                                receptionist.main();
                            }
                            if (staff[0].equals("Shift Manager")){
                                ShiftManager shiftManager = new ShiftManager();
                                shiftManager.main();
                            }
                            if (staff[0].equals("Technician")){
                                Technician technician = new Technician();
                                technician.main();
                            }
                            loggedIn=staff[0];
                            setLoggedIn(staff[0]);
                            frame.dispose();
                            break;
                        }
                        if (reader.hasNextLine() == false){
                            JOptionPane.showMessageDialog(frame,"INVALID USERNAME OR PASSWORD");
                        }
                    }
                    reader.reset();
                    reader.close();
                }catch (FileNotFoundException e1){
                    e1.printStackTrace();
                    System.out.println("DATABASE NOT FOUND");
                }
            }
        });
    }

    public static void start(){
        frame.setContentPane(new Login().loginPanel);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        start();
    }
}
