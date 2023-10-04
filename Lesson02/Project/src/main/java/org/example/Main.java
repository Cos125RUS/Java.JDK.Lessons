package org.example;

import org.example.TestException.Exceptional;
import org.example.bricks.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        new org.example.circle.MainWindow();
//        new MainWindow();
//        new Driver().test();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new org.example.circle.MainWindow();
            }
        });
    }
}