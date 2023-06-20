package org.example;
import java.util.HashSet;
public class University {
    private String name;
    private HashSet<Student> students= new HashSet<Student>();

    public University(String name) {
        this.name = name;
    }

    public  void addStudent(String name, String DOB, String subject){

        students.add(new Student(name,DOB,subject));
    }
    public HashSet<Student> getAllStudents(){
        return  this.students;
    }
    public  String getUniName(){
        return  this.name;
    }
    public  Student getStudentByName(String name){

        return this.students.stream().filter(s->s.getName().equals(name)).findFirst().orElse(null);
    }
}
