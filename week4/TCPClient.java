import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {;

    public static void main(String[] args) throws IOException, ClassNotFoundException {


            int serverPort = 8080;
            Socket s = new Socket(args[1],serverPort);

        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        String[]inputMsg = args[0].split(" ");
        if(inputMsg.length>2) {
            out.writeObject(new Message(inputMsg[0], inputMsg[1], inputMsg[2], inputMsg[3], inputMsg[4], "null"));
        }
        if(inputMsg.length==2){
            out.writeObject(new Message(inputMsg[0], inputMsg[1], "null", "null", "null", "null"));
        }
        // Message(String requestType, String uniName, String SName, String BOD, String subject,String responseMsg)
        Message responseObj = (Message)in.readObject();
        System.out.println("Response from Server: "+responseObj.getResponseMsg());
        s.close();

    }

}