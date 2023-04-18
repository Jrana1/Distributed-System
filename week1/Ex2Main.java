import java.util.List;

public class Ex2Main {
    public static void main(String[] args) {
             Publication p1 = new Publication("green life","english",12.3);
             Publication b1 = new Book("blue life","english",123.92,"xyz","1111-23");
            Publication p2 = new Publication("green life3","english",16.3);
            Book b2 = new Book("blue life4","english",1023.92,"xyz","1111-23");

            List<Publication>ls=List.of(p1,p2,b1,b2);
            ls.stream().forEach(e->e.print());

    }
}
