import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMIServer {

    public static void main(String[] args) {

           try {
                  University university1 = new University("fra-uas");
                  Naming.rebind("obj1",university1);
                  University university2 = new University("FH Frankfurt");
                  Naming.rebind("obj2",university2);
                  System.out.println("server has started...");

           } catch (RemoteException e) {
               throw new RuntimeException(e);
           } catch (MalformedURLException e) {
               throw new RuntimeException(e);
           }
    }
}
