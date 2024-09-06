/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.icetask1prog1b;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author RC_Student_lab
 */

public class StudentManagementApp {
    private JFrame frame;
    private JTextField idField, nameField, ageField;
    private JTextArea reportArea;

    public StudentManagementApp() {
        frame = new JFrame("ABC College Student Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new FlowLayout());
        
        JButton saveButton = new JButton("Save Student");
        JButton searchButton = new JButton("Search Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton reportButton = new JButton("View Student Report");
        JButton exitButton = new JButton("Exit");

        idField = new JTextField(15);
        nameField = new JTextField(15);
        ageField = new JTextField(15);
        reportArea = new JTextArea(15, 30);
        reportArea.setEditable(false);

        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Age:"));
        frame.add(ageField);
        
        frame.add(saveButton);
        frame.add(searchButton);
        frame.add(deleteButton);
        frame.add(reportButton);
        frame.add(exitButton);
        frame.add(new JScrollPane(reportArea));

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                int age = 0;
                try {
                    age = Integer.parseInt(ageField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid Age Entered. Please Enter a Number.");
                    return;
                }

                if (Student.saveStudent(id, name, age)) {
                    JOptionPane.showMessageDialog(frame, "Student details saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid age. Age must be 16 or older.");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                Student student = Student.searchStudent(id);
                if (student != null) {
                    JOptionPane.showMessageDialog(frame, "Found Student: " + student.getName() + ", Age: " + student.getAge());
                } else {
                    JOptionPane.showMessageDialog(frame, "Student not found.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete the student with ID: " + id + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (Student.deleteStudent(id)) {
                        JOptionPane.showMessageDialog(frame, "Student deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Student not found.");
                    }
                }
            }
        });

        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reportArea.setText(Student.studentReport());
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentManagementApp();
    }
}
