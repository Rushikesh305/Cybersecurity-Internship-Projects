package com.secureauth.audit;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HomeScreen extends JFrame {

    public HomeScreen() {

        setTitle("SecureAuth Auditor");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("SecureAuth Auditor");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBounds(190,40,350,40);

        JLabel subtitle = new JLabel("Authentication Security Audit Tool");
        subtitle.setFont(new Font("Arial", Font.PLAIN,18));
        subtitle.setBounds(170,85,400,30);

        JLabel version = new JLabel("Version 1.0");
        version.setFont(new Font("Arial", Font.ITALIC,14));
        version.setBounds(300,120,120,20);

        JButton startButton = new JButton("Start Security Audit");
        startButton.setBounds(235,190,220,45);

        JButton aboutButton = new JButton("About");
        aboutButton.setBounds(235,255,220,45);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(235,320,220,45);

        add(title);
        add(subtitle);
        add(version);
        add(startButton);
        add(aboutButton);
        add(exitButton);

        startButton.addActionListener(e -> {

            dispose();

            AuditScreen screen = new AuditScreen();
            screen.setVisible(true);

        });

        aboutButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "SecureAuth Auditor\n\n"
                    + "Version 1.0\n\n"
                    + "This application performs a rule-based\n"
                    + "authentication security audit and\n"
                    + "provides recommendations based on\n"
                    + "security best practices."
            );

        });

        exitButton.addActionListener(e -> System.exit(0));

    }

}