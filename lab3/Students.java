package lab3;

import java.util.*;

public class Students {    
    public static void main(String[] args) {
        Student first = new Student("Anna", "Smith", 21, 4.6);
        Student second = new Student("Julia", "Kennedy", 20, 4.2);
        Student third = new Student("Jane", "West", 21, 4.0);
        HashMap <Integer, Student> students = new HashMap<>();

        System.out.println("Insert task");
        students.put(1000, first);
        students.put(1001, second);
        students.put(1010, third);
        for (Integer i: students.keySet()) {
            System.out.println(students.get(i).getStudent());
        }
        
        System.out.println("Get task");
        System.out.println(students.get(1010).getStudent());        
        
        System.out.println("Delete task");
        students.remove(1001);
        for (Integer i: students.keySet()) {
            System.out.println(students.get(i).getStudent());
        }
    }
}
