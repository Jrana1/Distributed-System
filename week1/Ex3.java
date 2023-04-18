import java.util.Arrays;
import java.util.HashSet;

public class Ex3 {
    public static void main(String[] args) {

        HashSet<String> st = new HashSet<>();
        Arrays.stream(args).forEach(str->st.add(str));
        st.stream().forEach(System.out::println);
    }
}
