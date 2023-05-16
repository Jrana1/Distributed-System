import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class TCPServer {

    public static void main(String[] args)throws Exception {
        HashMap<String,University> universities = new HashMap<>();
        universities.put("uni1",new University("uni1"));
        universities.put("uni2",new University("uni2"));
        int serverPort = 8080;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("server has started at port 8080...");
        while (true){
            Socket clientSocket = serverSocket.accept();
            Connection c = new Connection();
            c.connect(clientSocket,universities);
        }
    }
}
// Message(String requestType, String uniName, String SName, String BOD, String subject,String responseMsg)
class Connection extends Thread{
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket clientSocket;
    private HashMap<String,University>unis=new HashMap<>();
    public  void connect(Socket clientSocket,HashMap<String,University>unis) throws IOException {
        this.in = new ObjectInputStream(clientSocket.getInputStream());
        this.out=new ObjectOutputStream(clientSocket.getOutputStream());
        this.unis=unis;
        this.clientSocket=clientSocket;
        this.start();
    }
    public void run(){

        try {
            Message requestObj = (Message) in.readObject();
            if(requestObj.getRequestType().equals("add")){
                handlePostRequest(requestObj);
            }
            else if(requestObj.getRequestType().equals("get")){
                handleGetRequest(requestObj);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void handlePostRequest(Message msgObj) throws IOException {
          University uni = this.unis.get(msgObj.getUniName());
          if(uni==null){
              this.out.writeObject(new Message("null","null","null","null","null",String.format("Uni with name %s has not been found!",msgObj.getUniName())));
              return;
          }
          uni.addStudent(msgObj.getSName(),msgObj.getSubject(),msgObj.getBOD());
          this.out.writeObject(new Message("null","null","null","null","null",String.format("A Student with name %s has been added to Uni %s!",msgObj.getSName(),msgObj.getUniName())));

    }
    private void handleGetRequest(Message msgObj) throws IOException {
        University uni = this.unis.get(msgObj.getUniName());
        if(uni==null){
            this.out.writeObject(new Message("null","null","null","null","null",String.format("Uni with name %s has not been found!",msgObj.getUniName())));
            return;
        }
        var it = uni.getAllStudents().iterator();

        String responseMsg = String.format("\nList of names of student in Uni %s: \n",msgObj.getUniName());
        int i=1;
        while (it.hasNext()){
            responseMsg+=(i++) + "."+it.next().getName()+"\n";
        }
        this.out.writeObject(new Message("null","null","null","null","null",responseMsg));


    }


}