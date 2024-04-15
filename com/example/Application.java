package com.example;

import com.example.entity.Student;
import com.example.model.StudentList;

import java.util.Scanner;

public class Application {
    private static Scanner input = new Scanner(System.in);
    private static StudentList list;

    public static void menu(){
        System.out.println("1. Add a new student to the list");
        System.out.println("2. Delete a student from the list");
        System.out.println("3. Search by name");
        System.out.println("4. Search by id");
        System.out.println("5. Print student info in descending order of mark");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        list = new StudentList();
        int choice;

        do {
            menu();
            choice = input.nextInt();
            input.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    printSorted();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        input.close(); // close Scanner after use
    }

    public static void addStudent(){
        int id;
        String fn;
        String ln;
        double mark;
        System.out.println("Enter student ID: ");
        id = input.nextInt();
        input.nextLine(); // consume newline
        System.out.println("Enter first name: ");
        fn = input.nextLine();
        System.out.println("Enter last name: ");
        ln = input.nextLine();
        System.out.println("Enter mark: ");
        mark = input.nextDouble();
        Student s = new Student(id, fn, ln, mark);
        list.add(s);
        System.out.println("Student added successfully!");
    }

    public static void deleteStudent(){
        int id;
        System.out.println("Enter student id: ");
        id = input.nextInt();
        if (list.remove(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Can not find student with id " + id);
        }
    }

    public static void searchByName(){
        String name;
        System.out.println("Enter a name: ");
        name = input.nextLine();
        list.showList(list.findByName(name));
    }

    public static void searchById(){
        int id;
        System.out.println("Enter an Id: ");
        id = input.nextInt();
        Student s = list.findById(id);
        if(s == null){
            System.out.println("Not found");
        } else {
            s.printInfo();
        }
    }

    public static void printSorted(){
        list.sortByMarks();
        list.showList();
    }
}
