/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icetask1prog1b;
import java.util.ArrayList;
/**
 *
 * @author RC_Student_lab
 */

public class Student {

    static void clearStudents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String id;
    private String name;
    private int age;

    private static ArrayList<Student> studentList = new ArrayList<>();

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static boolean saveStudent(String id, String name, int age) {
        if (age < 16 || age < 0) { // invalid age check
            return false;
        }
        studentList.add(new Student(id, name, age));
        return true;
    }

    public static Student searchStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null; // not found
    }

    public static boolean deleteStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                return true;
            }
        }
        return false; // not found
    }

    public static String studentReport() {
        StringBuilder report = new StringBuilder();
        for (Student student : studentList) {
            report.append("ID: ").append(student.getId())
                  .append(", Name: ").append(student.getName())
                  .append(", Age: ").append(student.getAge())
                  .append("\n");
        }
        return report.toString();
    }
}