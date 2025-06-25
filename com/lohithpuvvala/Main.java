package com.lohithpuvvala;

import java.util.*;

public class Main {
    
    //List to maintain all Student Objects
    static ArrayList<Student> students = new ArrayList<>();

    //Map to quickly access students by their ID
    static Map<Integer, Student> studentIdMap = new HashMap<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char exit;

        //Main Application Loop
        do {
            System.out.println("====== Welcome to the Student Management System ======");

            System.out.println("1. Add Student");
            System.out.println("2. Update Student Details");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students Details");
            System.out.println("5. View Student Details");

            //User's menu choice
            System.out.print("Please enter your choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1: {// Add Student
                    System.out.println("Enter Student ID: ");
                    int id = in.nextInt();

                    //Check for Duplicate ID
                    if (studentIdMap.containsKey(id)) {
                        System.out.println("Student Id: " + id + " already exists");
                    } else {
                        System.out.println("Enter Student Name: ");
                        in.nextLine();//consume newline
                        String name = in.nextLine();

                        //Validate non-blank name
                        while (name.trim().isEmpty()) {
                            System.out.println("Name cannot be blank. Please enter a valid name: ");
                            name = in.nextLine();
                        }

                        System.out.println("Enter Student Marks: ");
                        int marks = in.nextInt();

                        //Validate marks between 0 and 100
                        while (marks < 0 || marks > 100) {
                            System.out.println("Marks can only be within the range of 0 to 100. Please enter valid marks: ");
                            marks = in.nextInt();
                        }

                        //Create and Add new Student.
                        Student s = new Student(id, name, marks);
                        addStudent(s);
                    }
                    break;
                }
                case 2: {//Update Student
                    System.out.println("Enter Student ID: ");
                    int id = in.nextInt();

                    //Check if Student Exists.
                    if (studentIdMap.containsKey(id)) {
                        System.out.println("Current Student Details");
                        Student s = studentIdMap.get(id);
                        System.out.println(s);

                        //Get Updated Name
                        System.out.println("New Student Name: ");
                        in.nextLine();//consume line
                        String name = in.nextLine();

                        //Validate non-blank name
                        while (name.trim().isEmpty()) {
                            System.out.println("Name cannot be blank. Please enter a valid name: ");
                            name = in.nextLine();
                        }

                        System.out.println("New Student Marks: ");
                        int marks = in.nextInt();

                        //Validates marks between 0 and 100
                        while (marks < 0 || marks > 100) {
                            System.out.println("Marks can only be within the range of 0 to 100. Please enter valid marks: ");
                            marks = in.nextInt();
                        }

                        //Confirm Update
                        System.out.println("Are you sure you want to update Student Details ? (y/n)");
                        in.nextLine();//consume newline
                        char update = in.next().charAt(0);

                        if (update == 'y' || update == 'Y') {
                            updateStudent(s, name, marks);
                        } else {
                            System.out.println("Student Details are not updated...");
                        }
                    } else {
                        System.out.println("Student Id: " + id + " does not exist...");
                    }
                    break;
                }
                case 3: {//Delete Student
                    System.out.println("Enter Student ID: ");
                    int id = in.nextInt();

                    //Checks if Student Exists
                    if (studentIdMap.containsKey(id)) {
                        System.out.println("Student Details:");
                        System.out.println(studentIdMap.get(id));

                        //Confirm Deletion.
                        System.out.println("Are you sure you want to delete Student Details ? (y/n)");
                        in.nextLine();//consume newline
                        char delete = in.next().charAt(0);

                        if (delete == 'y' || delete == 'Y') {
                            deleteStudent(id);
                        } else {
                            System.out.println("Student Details are not Deleted...");
                        }
                    } else {
                        System.out.println("Student Id: " + id + " does not exist...");
                    }
                    break;
                }
                case 4:// View all Student Details
                    viewAllStudents();
                    break;
                case 5: {// View Specific Student Details
                    System.out.println("Enter Student ID: ");
                    int id = in.nextInt();
                    if (studentIdMap.containsKey(id)) {
                        viewStudent(id);
                    } else {
                        System.out.println("Student ID does not exist....");
                    }
                    break;
                }
            }

            //Prompt user to exit
            System.out.println("Want to exit the application? (y/n)");
            in.nextLine();
            exit = in.nextLine().charAt(0);

        } while (exit != 'y' && exit != 'Y'); // Loop until the user chooses to exit.
    }

    //Print details of all Students.
    private static void viewAllStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    //Add new Student to List and Map.
    static void addStudent(Student s) {
        studentIdMap.put(s.getId(), s);
        students.add(s);
        System.out.println(s);
    }

    //View a specific student's details
    static void viewStudent(int id) {
        Student s = studentIdMap.get(id);
        System.out.println(s);
    }

    //Update a student's name and marks.
    static void updateStudent(Student s, String name, int marks) {
        s.setName(name);
        s.setMarks(marks);
        System.out.println("Successfully updated Student Details...");
        System.out.println(s);
    }

    //Remove Student from Map and List
    static void deleteStudent(int id) {
        students.remove(studentIdMap.get(id));
        studentIdMap.remove(id);
        System.out.println("Student ID: " + id + " successfully deleted...");
    }
}
