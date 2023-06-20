package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

@XmlRootElement
public class Student {


    private  String name;
    private  String subject;
    private  String DOB;
    public Student(String name, String DOB, String subject) {
        this.name = name;
        this.subject = subject;
        this.DOB = DOB;
    }
    public  Student(){}

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @XmlElement
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", DOB='" + DOB + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getName(), student.getName()) && Objects.equals(getSubject(), student.getSubject()) && Objects.equals(getDOB(), student.getDOB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSubject(), getDOB());
    }
}
