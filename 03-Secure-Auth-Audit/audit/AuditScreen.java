package com.secureauth.audit;

import java.awt.Font;
import javax.swing.*;

public class AuditScreen extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JTextField expiryField;
    JTextField attemptsField;

    JRadioButton passwordOnly;
    JRadioButton passwordMFA;

    JComboBox<String> lockoutBox;

    JButton generateButton;
    JButton backButton;

    public AuditScreen() {

        setTitle("Secure Authentication Audit");
        setSize(750,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("SECURITY AUTHENTICATION AUDIT");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(150,20,450,30);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(60,80,150,25);

        usernameField = new JTextField();
        usernameField.setBounds(250,80,350,25);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(60,130,150,25);

        passwordField = new JPasswordField();
        passwordField.setBounds(250,130,350,25);

        JLabel authLabel = new JLabel("Authentication Type");
        authLabel.setBounds(60,180,150,25);

        passwordOnly = new JRadioButton("Password Only");
        passwordOnly.setBounds(250,180,150,25);

        passwordMFA = new JRadioButton("Password + MFA");
        passwordMFA.setBounds(420,180,170,25);

        ButtonGroup group = new ButtonGroup();
        group.add(passwordOnly);
        group.add(passwordMFA);

        passwordOnly.setSelected(true);

        JLabel expiryLabel = new JLabel("Password Expiry (Days)");
        expiryLabel.setBounds(60,240,170,25);

        expiryField = new JTextField();
        expiryField.setBounds(250,240,100,25);

        JLabel attemptsLabel = new JLabel("Maximum Login Attempts");
        attemptsLabel.setBounds(60,290,180,25);

        attemptsField = new JTextField();
        attemptsField.setBounds(250,290,100,25);

        JLabel lockLabel = new JLabel("Account Lockout");
        lockLabel.setBounds(60,340,150,25);

        lockoutBox = new JComboBox<>();

        lockoutBox.addItem("Yes");
        lockoutBox.addItem("No");

        lockoutBox.setBounds(250,340,100,25);

        generateButton = new JButton("Generate Audit Report");
        generateButton.setBounds(210,430,250,40);

        backButton = new JButton("Back");
        backButton.setBounds(300,490,80,35);

        add(title);

        add(userLabel);
        add(usernameField);

        add(passLabel);
        add(passwordField);

        add(authLabel);
        add(passwordOnly);
        add(passwordMFA);

        add(expiryLabel);
        add(expiryField);

        add(attemptsLabel);
        add(attemptsField);

        add(lockLabel);
        add(lockoutBox);

        add(generateButton);
        add(backButton);
        add(backButton);
        
        generateButton.addActionListener(e -> {

            String password = new String(passwordField.getPassword());

            boolean mfaEnabled = passwordMFA.isSelected();

            int expiryDays;
            int loginAttempts;

            try {

                expiryDays = Integer.parseInt(expiryField.getText());
                loginAttempts = Integer.parseInt(attemptsField.getText());

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(this,
                        "Please enter valid numeric values.");

                return;

            }

            boolean lockoutEnabled =
                    lockoutBox.getSelectedItem().equals("Yes");

            AuditResult result = AuthAnalyzer.analyze(
                    password,
                    mfaEnabled,
                    expiryDays,
                    loginAttempts,
                    lockoutEnabled);

            dispose();

            new ResultScreen(result).setVisible(true);

        });
        
        backButton.addActionListener(e -> {

            dispose();

            new HomeScreen().setVisible(true);

        });

    }

}