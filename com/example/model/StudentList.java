package com.example.model;

import com.example.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentList {
    private ArrayList<Student> list;

    public StudentList(){
        list = new ArrayList<>();
    }

    public ArrayList<Student> findByName(String name){
        ArrayList<Student> matches = new ArrayList<>();
        for(Student s : list){
            String fullName = s.getFirstName() + " " + s.getLastName();
            if(fullName.toLowerCase().contains(name.toLowerCase())){
                matches.add(s);
            }
        }
        if(matches.isEmpty()){
            System.out.println("Not found");
        }
        return matches;
    }

    public Student findById(int id){
        for(Student s : list){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public void add(Student s){
        list.add(s);
    }

    public boolean remove(int id){
        for(Student s : list){
            if(s.getId() == id){
                list.remove(s);
                return true;
            }
        }
        return false;
    }

    public void sortByMarks(){
        Collections.sort(list, Comparator.comparingDouble(Student::getMark).reversed());
    }

    public void showList(){
        for(Student s : list){
            s.printInfo();
        }
    }

    public void showList(ArrayList<Student> slist){
        for(Student s : slist){
            s.printInfo();
        }
    }
}
