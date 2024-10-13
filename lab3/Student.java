package lab3;

import java.util.*;

public class Student {
    private String name;
    private String surname;
    private int age;
    private double gpa;

    public Student(String name, String surname, int age, double gpa) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gpa = gpa;
    }

    public void setNameSurname(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public double getGPA() {
        return gpa;
    }

    public ArrayList<String> getStudent() {
        ArrayList<String> studentInfo = new ArrayList<>();
        studentInfo.add(name);
        studentInfo.add(surname);
        studentInfo.add(Integer.toString(age));
        studentInfo.add(Double.toString(gpa));
        return studentInfo;
    }
}
