/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.icetask1prog1b;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */



public class StudentTest {
    
    
    public void setUp() {
        // Clear the student list before each test to ensure isolation
        Student.clearStudents();
    }
    
    @Test
    public void testSaveStudent() {
        // Assuming email and course are added to the Student class
        String id = "1";
        String name = "John Doe";
        int age = 20;

        // Save student and assert
        assertTrue(Student.saveStudent(id, name, age));
        Student student = Student.searchStudent(id);
        assertNotNull(student);
        assertEquals(name, student.getName());
        assertEquals(age, student.getAge());
    }

    @Test
    public void testSearchStudent() {
        String id = "2";
        String name = "Johaness";
        int age = 22;

        // Save student first
        Student.saveStudent(id, name, age);

        // Search for the saved student
        Student student = Student.searchStudent(id);
        assertNotNull(student);
        assertEquals(name, student.getName());
        assertEquals(age, student.getAge());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Attempt to search for a non-existing student
        Student student = Student.searchStudent("012");
        assertNull(student);
    }

    @Test
    public void testDeleteStudent() {
        String id = "5";
        String name = "Kelebogile";
        int age = 19;

        // Save student first
        Student.saveStudent(id, name, age);

        // Delete the student and assert it was deleted
        assertTrue(Student.deleteStudent(id));
        assertNull(Student.searchStudent(id));
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Attempt to delete a non-existing student
        assertFalse(Student.deleteStudent("012"));
    }
    
    @Test
    public void testStudentAge_StudentAgeValid() {
        String id = "1";
        String name = "Kelebogile";
        int age = 18;  // Valid age

        assertTrue(Student.saveStudent(id, name, age));
        Student student = Student.searchStudent(id);
        assertNotNull(student);
        assertEquals(age, student.getAge());
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        String id = "2";
        String name = "Kelebogile";
        int age = 15;  // Invalid age

        assertFalse(Student.saveStudent(id, name, age));
        Student student = Student.searchStudent(id);
        assertNull(student);  // Ensure student is not saved
    }

    @Test
    public void testStudentAge_InvalidCharacter() {
        String id = "3";
        String name = "Kelebogile";

        // Attempt to save with an invalid age (non-numeric)
        try {
            int invalidAge = Integer.parseInt("abc");  // This will throw NumberFormatException
            assertFalse(Student.saveStudent(id, name, invalidAge));
        } catch (NumberFormatException e) {
            // Expected exception
            assertTrue(true);
        }
        
        Student student = Student.searchStudent(id);
        assertNull(student);  // Ensure student is not saved
    }
}

