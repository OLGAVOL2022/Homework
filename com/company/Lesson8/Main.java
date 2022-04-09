package com.company.Lesson8;

import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame {


    public Main() {
        setTitle("My first visual app");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 300);

        setLayout(null);
        JTextField jTextField = new JTextField();
        JButton jButton = new JButton();
        JLabel jLabel = new JLabel();


        jTextField.addActionListener(e -> jLabel.setText(jTextField.getText() + "Привет"));
        jButton.addActionListener(e -> jLabel.setText(jTextField.getText() + "Привет"));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("закрыто");
            }
        });

        jTextField.setBounds(50,50,200,50);
        jButton.setBounds(50,110,200,50);
        jLabel.setBounds(50,170,200,50);

        add(jTextField);
        add(jButton);
        add(jLabel);

        setVisible(true);

    }


    public static void main(String[] args) {
        new Main();
    }
}
