package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateReport {
    private static JFrame frame = new JFrame("CREATE REPORT");
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton printReportButton;
    private JButton backButton;
    private JComboBox comboBox3;
    private JPanel CreateReportPanel;

    public CreateReport() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShiftManager shiftManager = new ShiftManager();
                shiftManager.main();
                frame.dispose();
            }
        });
        printReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CreateReport().CreateReportPanel);
        frame.setVisible(true);
    }
}
