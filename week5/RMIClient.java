import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

    public static void main(String[] args) {
            try {
                  RemoteUniversity uni1 = (RemoteUniversity) Naming.lookup("rmi://localhost/obj1");
                  RemoteUniversity uni2 = (RemoteUniversity) Naming.lookup("rmi://localhost/obj2");
                  // get 1st uniName
                  System.out.println("name of first uni" + uni1.getUniName());
                  // add students in uni 1
                uni1.addStudent("John","CSE","22-03-2000");
                uni1.addStudent("Melli","CSE","23-03-2000");
                uni1.addStudent("Max","EEE","25-03-2000");
                // get 2nd uniName
                System.out.println("name of second uni" + uni2.getUniName());
                // add students in uni 2
                uni2.addStudent("ARI","EEE","22-03-2000");
                uni2.addStudent("Josh","IT","23-03-2000");
                uni2.addStudent("Elias","EEE","25-03-2000");
                uni2.addStudent("maya","CSE","25-03-2000");
                uni2.addStudent("abc","CSE","25-03-2000");

                // get student with name elias
                RemoteStudent remoteStudent= (RemoteStudent) uni2.getStudentByName("Elias");
                if(remoteStudent!=null){
                    System.out.println("student found from uni1 : "+remoteStudent.getName()+", "+remoteStudent.getDOB()+", "+remoteStudent.getSubject());
                }
                else{
                    System.out.println("not found!!");
                }
                RemoteStudent remoteStudent2= (RemoteStudent) uni1.getStudentByName("Max");
                if(remoteStudent!=null){
                    System.out.println("student found from uni2 : "+remoteStudent2.getName()+", "+remoteStudent2.getDOB()+", "+remoteStudent2.getSubject());
                }
                else{
                    System.out.println("not found!!");
                }
                System.out.println("List of all students in Uni1: ");
                var it1 = uni1.getAllStudents().iterator();
                while (it1.hasNext()){

                    RemoteStudent s = it1.next();;
                    System.out.println(String.format("Name: %s, Sub: %s, BOD: %s",s.getName(),s.getSubject(),s.getDOB()));
                }
                System.out.println("List of all students in Uni2: ");
                var it2 = uni2.getAllStudents().iterator();
                while (it2.hasNext()){

                    RemoteStudent s = it2.next();;
                    System.out.println(String.format("Name: %s, Sub: %s, BOD: %s",s.getName(),s.getSubject(),s.getDOB()));
                }

                int cntCSE=0;
                var it = uni1.getAllStudents().iterator();
                while (it.hasNext()){
                   if(it.next().getSubject().equals("CSE")){
                       cntCSE++;
                   }
                    //RemoteStudent st = it.next();
                   // System.out.println(st.getSubject()+" "+st.getDOB());
                }
                System.out.println("Number of CSE students in uni 1 : "+cntCSE);

                 cntCSE=0;
                var it3 = uni2.getAllStudents().iterator();
                while (it3.hasNext()){
                    if(it3.next().getSubject().equals("CSE")){
                        cntCSE++;
                    }
                    //RemoteStudent st = it.next();
                    // System.out.println(st.getSubject()+" "+st.getDOB());
                }
                System.out.println("Number of CSE students in uni 2 : "+cntCSE);

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
    }
}
