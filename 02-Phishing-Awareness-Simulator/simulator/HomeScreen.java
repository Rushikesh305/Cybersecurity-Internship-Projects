package com.phishing.simulator;

import java.awt.Font;

import javax.swing.*;

public class HomeScreen extends JFrame {

    public HomeScreen() {

        setTitle("PhishGuard");
        setSize(700,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("PHISHGUARD");
        title.setFont(new Font("Arial",Font.BOLD,28));
        title.setBounds(235,40,250,40);

        JLabel subtitle = new JLabel("Rule-Based Email Phishing Analyzer");
        subtitle.setFont(new Font("Arial",Font.PLAIN,16));
        subtitle.setBounds(190,80,300,30);

        JButton sampleButton =
                new JButton("Load Sample Email");

        sampleButton.setBounds(235,180,210,45);

        JButton analyzeButton =
                new JButton("Analyze My Email");

        analyzeButton.setBounds(235,250,210,45);

        add(title);
        add(subtitle);
        add(sampleButton);
        add(analyzeButton);

        sampleButton.addActionListener(e->{

            dispose();

            AnalyzerScreen screen =
                    new AnalyzerScreen(true);

            screen.setVisible(true);

        });

        analyzeButton.addActionListener(e->{

            dispose();

            AnalyzerScreen screen =
                    new AnalyzerScreen(false);

            screen.setVisible(true);

        });

    }

}