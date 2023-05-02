public class Main {

    public static void main(String[] args) {
        Student s = new Student("Rana","computer science","29-07-1995");
        University u = new University("FRA UAS");

        u.addStudent(s.getName(),s.getSubject(),s.getDOB());
        u.addStudent("Jewel","physic","20-03-1995");
        u.addStudent("John","computer science","20-03-1995");
        u.addStudent("Daniel","physic","20-03-1995");
        // search for a student with name John
        String name = "John3";
        Student student = u.getStudentByName(name);
        if(student!=null){
            System.out.println(student);
        }
        else{
            String str = String.format("student with name %s was not found!",name);
            System.out.println(str);
        }
        // find the number of students who study computer science.
        long count = u.getAllStudents().stream().filter(st->st.getSubject().equals("computer science")).count();
        System.out.println(count);

    }
}
