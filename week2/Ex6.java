import java.io.*;
import java.util.List;

public class Ex6 {
    public static void main(String[] args)  {

        Car c = new Car("blue",12.3,123.3);
        Publication p = new Publication("new life","english",2323.2);
        Book b= new Book("old life","english",2334.3,"xyz","7323z4-1343");

        List<Display> ls=List.of(p,b,c);

        try {
            FileOutputStream fileOutputStream=new FileOutputStream("test.ser");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ls);

        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileInputStream fileInputStream=new FileInputStream("test.ser");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            List<Display>out= (List<Display>) objectInputStream.readObject();
            out.stream().forEach(e->e.print());

        }
        catch (ClassNotFoundException e){
            System.err.println(e.toString());
        }
        catch (IOException e){
            System.err.println(e.toString());
        }

    }
}
