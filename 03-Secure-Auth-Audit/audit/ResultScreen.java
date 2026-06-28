package com.secureauth.audit;

import java.awt.Font;
import javax.swing.*;

public class ResultScreen extends JFrame {

    public ResultScreen(AuditResult result) {

        setTitle("Secure Authentication Audit Report");
        setSize(750,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("SECURE AUTHENTICATION AUDIT REPORT");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(120,20,500,30);

        JLabel score = new JLabel("Security Score : " + result.getScore() + "/100");
        score.setFont(new Font("Arial", Font.BOLD,18));
        score.setBounds(40,70,250,30);

        JLabel risk = new JLabel("Risk Level : " + result.getRiskLevel());
        risk.setFont(new Font("Arial", Font.BOLD,18));
        risk.setBounds(40,105,250,30);

        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);

        reportArea.append("========== PASSED CHECKS ==========\n\n");

        for(String s : result.getPassedChecks()) {
            reportArea.append("✔ " + s + "\n");
        }

        reportArea.append("\n========== FAILED CHECKS ==========\n\n");

        for(String s : result.getFailedChecks()) {
            reportArea.append("✖ " + s + "\n");
        }

        reportArea.append("\n========== RECOMMENDATIONS ==========\n\n");

        for(String s : result.getRecommendations()) {
            reportArea.append("• " + s + "\n");
        }

        JScrollPane scroll = new JScrollPane(reportArea);
        scroll.setBounds(40,150,650,320);

        JButton homeButton = new JButton("Back to Home");
        homeButton.setBounds(270,500,170,35);

        add(title);
        add(score);
        add(risk);
        add(scroll);
        add(homeButton);

        homeButton.addActionListener(e -> {
            dispose();
            new HomeScreen().setVisible(true);
        });

    }

}