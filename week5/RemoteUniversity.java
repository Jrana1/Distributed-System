import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;

public interface RemoteUniversity extends Remote {

    public  void addStudent(String name, String subject, String DOB)throws RemoteException;
    public HashSet<RemoteStudent> getAllStudents() throws RemoteException;
    public  String getUniName()throws RemoteException;
    public  RemoteStudent getStudentByName(String name)throws RemoteException;
}
