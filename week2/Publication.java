import javax.script.ScriptEngine;
import java.io.Serializable;

public class Publication implements Display {
    private  String title;
    private String language;
    private  double price;

    public Publication(String title, String language, double price) {
        this.title = title;
        this.language = language;
        this.price = price;
    }
    public  void print(){
        System.out.println(toString());
    }

    public Publication() {
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                '}';
    }
}
