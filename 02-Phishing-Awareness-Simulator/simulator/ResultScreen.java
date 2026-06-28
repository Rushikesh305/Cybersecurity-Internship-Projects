package com.phishing.simulator;

import java.awt.Font;
import javax.swing.*;

public class ResultScreen extends JFrame {

    public ResultScreen(AnalysisResult result) {

        setTitle("PhishGuard - Analysis Report");
        setSize(650,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title =
                new JLabel("EMAIL ANALYSIS REPORT");

        title.setFont(new Font("Arial",Font.BOLD,24));
        title.setBounds(150,20,350,35);

        JLabel threat =
                new JLabel("Threat Level : "
                        + result.getThreatLevel());

        threat.setFont(new Font("Arial",Font.BOLD,18));
        threat.setBounds(40,80,300,30);

        JLabel score =
                new JLabel("Risk Score : "
                        + result.getRiskScore()
                        + "/100");

        score.setFont(new Font("Arial",Font.BOLD,18));
        score.setBounds(40,120,250,30);

        JTextArea findings = new JTextArea();

        findings.setEditable(false);

        findings.append("Indicators Found\n\n");

        for(String s : result.getIndicators()){

            findings.append("✔ " + s + "\n");

        }

        findings.append("\nRecommendation\n\n");

        findings.append("• Do not click suspicious links.\n");
        findings.append("• Verify sender identity.\n");
        findings.append("• Report phishing emails.\n");
        findings.append("• Enable Multi-Factor Authentication.\n");

        JScrollPane scroll =
                new JScrollPane(findings);

        scroll.setBounds(40,170,550,220);

        JButton again =
                new JButton("Analyze Another Email");

        again.setBounds(190,410,220,35);

        add(title);
        add(threat);
        add(score);
        add(scroll);
        add(again);

        again.addActionListener(e->{

            dispose();

            new HomeScreen().setVisible(true);

        });

    }

}