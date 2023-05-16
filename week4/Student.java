import java.util.Objects;

public class Student {


      private  String name;
      private  String subject;
      private  String DOB;
    public Student(String name, String subject, String DOB) {
        this.name = name;
        this.subject = subject;
        this.DOB = DOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

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
