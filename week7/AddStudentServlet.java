
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add_student")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String subject = request.getParameter("subject");
        PrintWriter out = response.getWriter();
        University university = (University) getServletContext().getAttribute("university");
        university.addStudent(name,subject,dob);
        out.println("<html><body>");
        out.println(String.format("<h1>A student with name %s has been added successfully!!</h1>",name));
        out.println("<form action=\"main.html\" >");
        out.println(" <input type=\"submit\" value=\"Go back to Menu\">");
        out.println("</form>");
        out.println("</body></html>");
    }
}
