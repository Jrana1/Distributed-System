import java.util.List;

public class Ex5Main {

    public static void main(String[] args) {
        var c = new Car("blue",12.3,123.3);
        var p = new Publication("new life","english",2323.2);
        var b= new Book("old life","english",2334.3,"xyz","7323z4-1343");

        List<Display>ls=List.of(p,b,c);

        ls.stream().forEach(e->e.print());

    }
}
