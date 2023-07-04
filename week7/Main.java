import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/count")
public class Main extends HttpServlet {
    private int x=3;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int y=9;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(String.format("<h1>x=%d, y=%d</h1>",2*(x++),y++));
        out.println("</html></body>");
    }
}
