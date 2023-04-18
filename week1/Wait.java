import java.util.Scanner;

public class Wait {

       private  static  int counter=3;

       public  void  waiting(){
           Scanner sc = new Scanner(System.in);
           while (true){
               System.out.println("Enter any string or 'y' or 'Y' to stop: ");
                       if(sc.nextLine().strip().toLowerCase().equals("y")){
                           System.out.println("breaking");
                           break;
                       }
                       MyThread t = new MyThread(counter++);
                       t.start();
              }
           sc.close();
       }
}
