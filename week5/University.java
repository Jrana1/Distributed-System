import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;

public class University extends UnicastRemoteObject implements RemoteUniversity {
    private String name;
    private HashSet<RemoteStudent> students= new HashSet<RemoteStudent>();
    public University(String name) throws RemoteException {
        super();
        this.name = name;
    }

    public  void addStudent(String name, String subject, String DOB) throws RemoteException {

        students.add(new Student(name,subject,DOB));
    }
    public HashSet<RemoteStudent> getAllStudents() throws RemoteException{
        return  this.students;
    }
    public  String getUniName(){
        return  this.name;
    }
    public  RemoteStudent getStudentByName(String name){

        return this.students.stream().filter(s-> {
            try {
                return s.getName().equals(name);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }).findFirst().orElse(null);
    }
}
