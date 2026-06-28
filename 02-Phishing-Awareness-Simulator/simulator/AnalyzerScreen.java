package com.phishing.simulator;

import java.awt.Font;
import javax.swing.*;

public class AnalyzerScreen extends JFrame {

    private JTextArea emailArea;

    public AnalyzerScreen(boolean loadSample) {

        setTitle("PhishGuard - Email Analyzer");
        setSize(700,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("Paste Email Below");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(240,20,250,30);

        emailArea = new JTextArea();

        JScrollPane scroll = new JScrollPane(emailArea);
        scroll.setBounds(40,70,600,300);

        JButton analyzeButton = new JButton("Analyze Email");
        analyzeButton.setBounds(240,400,180,40);

        add(title);
        add(scroll);
        add(analyzeButton);

        if(loadSample) {

            emailArea.setText(
                    "From: support@amaz0n-security.com\n\n"
                  + "Subject: Verify Your Account\n\n"
                  + "Dear Customer,\n\n"
                  + "Your account has been suspended.\n"
                  + "Verify immediately.\n\n"
                  + "Click here:\n"
                  + "http://bit.ly/login\n\n"
                  + "Enter your password to continue."
            );

        }

        analyzeButton.addActionListener(e -> analyzeEmail());

    }

    private void analyzeEmail() {

        String email = emailArea.getText();

        AnalysisResult result =
                EmailAnalyzer.analyze(email);

        StringBuilder report = new StringBuilder();

        report.append("Threat Level : ")
              .append(result.getThreatLevel())
              .append("\n\n");

        report.append("Risk Score : ")
              .append(result.getRiskScore())
              .append("/100\n\n");

        report.append("Indicators Found:\n\n");

        for(String indicator : result.getIndicators()) {

            report.append("• ")
                  .append(indicator)
                  .append("\n");

        }
        dispose();

        ResultScreen screen =
                new ResultScreen(result);

        screen.setVisible(true);

    }

}