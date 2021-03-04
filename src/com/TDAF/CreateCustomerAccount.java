package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CreateCustomerAccount {
    private static JFrame frame = new JFrame("Customer Creator");
    private JPanel CustomerCreation;
    private JTextField CustomerNameField;
    private JTextField AccountNumberField;
    private JTextField ContactNameField;
    private JTextField AddressField;
    private JTextField PhoneField;
    private JButton backButton;
    private JButton createCustomerButton;
    private JTextField AgreedDiscountField;
    private JComboBox ValueDropdown;
    private JTextArea textArea1;

    public void main(){
        int width = 550;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CreateCustomerAccount().CustomerCreation);
        frame.setVisible(true);
    }

    public CreateCustomerAccount() {
        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCustomer();
                JOptionPane.showMessageDialog(frame,"CUSTOMER CREATED");
                CustomerNameField.setText("");
                AccountNumberField.setText("");
                ContactNameField.setText("");
                AddressField.setText("");
                PhoneField.setText("");
                AgreedDiscountField.setText("");
                textArea1.setText("");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receptionist receptionist = new Receptionist();
                receptionist.main();
                frame.dispose();
            }
        });
    }

    public void saveCustomer(){
        try{
            FileWriter writer = new FileWriter("C:\\Users\\TDAF\\Desktop\\JAVA\\Team Project\\customer accounts.txt",true);
            writer.write(CustomerNameField.getText() + "," + AccountNumberField.getText()+","+ContactNameField.getText()+","+AddressField.getText()+","+PhoneField.getText()+","+AgreedDiscountField.getText()+","+ValueDropdown.getSelectedItem()+'\n');
            writer.close();
            System.out.println("Successfully wrote to the file.");
        }catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
