/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandloginpoepart1;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RegistrationAndLoginPOEPart1 {
     public static String[][] users = new String[10][4]; // Storing user data: [username, password, first name, last name]
    public static int userCount = 0;

    public static void main(String[] args) {
        boolean loggedIn = false;
        while (!loggedIn) {
            String choice = JOptionPane.showInputDialog("Choose an option:\n1. Register\n2. Login");
            switch (choice) {
                case "1" -> register();
                case "2" -> loggedIn = login();
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
        JOptionPane.showMessageDialog(null, "Login successful!");
    }

    public static void register() {
    String username = JOptionPane.showInputDialog("Enter username (username must contain an underscore):");

    // Validate username
    if (username == null || username.length() > 5 || !username.contains("_")) {
        JOptionPane.showMessageDialog(null, "Invalid username! Username must contain an underscore and not more than 5 characters.");
        return;
    } else {
        JOptionPane.showMessageDialog(null, "Username successfully captured");
    }
     // Validate password
    String password = JOptionPane.showInputDialog("Enter password:");
   
    if (password == null || password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*") || !password.matches(".*[!@#$%^&*()].*")) {
        JOptionPane.showMessageDialog(null, "Invalid password! Password must be at least 8 characters and contain at least one uppercase letter, one number, and one special character.");
        return;
    } else {
        JOptionPane.showMessageDialog(null, "Password successfully captured");
    }

    String firstName = JOptionPane.showInputDialog("Enter first name:");
    String lastName = JOptionPane.showInputDialog("Enter last name:");

    // Check if username already exists
    for (int i = 0; i < userCount; i++) {
        if (username.equals(users[i][0])) {
            JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different one.");
            return;
        }
    }

    // Add user to the array
    users[userCount][0] = username;
    users[userCount][1] = password;
    users[userCount][2] = firstName;
    users[userCount][3] = lastName;
    userCount++;

    JOptionPane.showMessageDialog(null, "Registration successful!");
}


    public static boolean login() {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        // Check if username and password match
        for (int i = 0; i < userCount; i++) {
            if (username.equals(users[i][0]) && password.equals(users[i][1])) {
                JOptionPane.showMessageDialog(null, "Welcome " + users[i][2] + " " + users[i][3] + ", It is great to see you again.");
                return true; // Login successful
            }
        }

        JOptionPane.showMessageDialog(null, "Username or password incorrect, Please try again.");
        return false; // Login failed
    }
}

