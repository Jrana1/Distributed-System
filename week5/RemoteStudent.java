import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteStudent extends Remote {

    public String getName() throws RemoteException;

    public void setName(String name) throws RemoteException;

    public String getSubject() throws RemoteException;

    public void setSubject(String subject) throws RemoteException;

    public String getDOB() throws RemoteException;

    public void setDOB(String DOB) throws RemoteException;

}
