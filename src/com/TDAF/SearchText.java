package com.TDAF;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchText {
    private String path = "C:\\Users\\TDAF\\Desktop\\JAVA\\Team Project\\filename.txt";
    private File myFile = new File(path);
    private Scanner reader;
    private String data;
    private String[] datasplit;


    public SearchText(String path) {
        this.path = path;
    }

    public void Search(){
        try{
            reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                data = reader.nextLine();
                datasplit = data.split(",");

            }
            reader.reset();
            reader.close();
        }catch (FileNotFoundException e1){
            e1.printStackTrace();
            System.out.println("DATABASE NOT FOUND");
        }
    }

    public void LoginSearch(String username, String password){
        Search();
        if (datasplit[0].equals(username) && datasplit[1].equals(password)){
            if (datasplit[0].equals("Office Manager")){
                OfficeManager officeManager = new OfficeManager();
                officeManager.main();
            }
            if (datasplit[0].equals("Receptionist")){
                Receptionist receptionist = new Receptionist();
                receptionist.main();
            }
            if (datasplit[0].equals("Shift Manager")){
                ShiftManager shiftManager = new ShiftManager();
                shiftManager.main();
            }
            if (datasplit[0].equals("Technician")){
                Technician technician = new Technician();
                technician.main();
            }
        }
    }

    public void StaffSearch(String[] staffName, JFrame frame, JTextField CurrentRoleBar){
        Search();
        if (staffName[0].equals(datasplit[1]) && staffName[1].equals(datasplit[2])){
            JOptionPane.showMessageDialog(frame,"USER FOUND");
            CurrentRoleBar.setText(datasplit[0]);
        }
    }

    public void CustomerSearch(JTextField SearchBar, JFrame frame, JTextArea textArea1){
        Search();
        if (SearchBar.getText().equals(datasplit[0])){
            JOptionPane.showMessageDialog(frame,"USER FOUND");
            textArea1.setText("Customer Name: "+datasplit[0]+'\n'+"Account No: "+datasplit[1]+'\n'+"Contact Name: "+datasplit[2]+'\n'+"Address: "+datasplit[3]+" , "+datasplit[4]+'\n'+
                    "Phone: "+datasplit[5]+'\n'+"Agreed Discount: "+datasplit[6]+'\n'+"Is Valued Customer: "+datasplit[7]+'\n');
        }
    }
}
