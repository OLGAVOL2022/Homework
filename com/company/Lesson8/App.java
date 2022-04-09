package com.company.Lesson8;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    int count = 0;

    public App () {

        setBounds(300,300,500,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Counter");
        setResizable(false);

        JLabel counter = new JLabel("0");
        JButton leftButton = new JButton("<");
        JButton rightButton = new JButton(">");

        Font font = new Font("Arial",Font.BOLD,35);

        counter.setFont(font);
        counter.setHorizontalAlignment(SwingConstants.CENTER);

        leftButton.addActionListener(e -> {
            count--;
            counter.setText(String.valueOf(count));

        });

        rightButton.addActionListener(e -> {
            count++;
            counter.setText(String.valueOf(count));

        });

        setVisible(true);

        add(rightButton, BorderLayout.EAST);
        add(leftButton, BorderLayout.WEST);
        add(counter, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new App();
    }
}