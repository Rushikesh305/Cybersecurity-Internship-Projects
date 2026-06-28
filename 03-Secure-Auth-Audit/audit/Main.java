package com.secureauth.audit;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            HomeScreen home = new HomeScreen();
            home.setVisible(true);

        });

    }

}