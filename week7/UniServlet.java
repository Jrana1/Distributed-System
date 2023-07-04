
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;

@WebServlet("/root")
public class UniServlet extends HttpServlet {
    private University university;

    @Override
    public void init() throws ServletException {
        university = new University("FRA-UAS");
        university.addStudent("John", "Math", "22-07-2003");
        university.addStudent("Max", "Music", "23-08-2003");
        getServletContext().setAttribute("university", university);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String option = request.getParameter("option");

        if (option.equals("get all student")) {

            var it = university.getAllStudents().iterator();
            out.println("<html><body>");
            while (it.hasNext()) {
                var s = it.next();
                out.println(String.format("<h1>name: %s, dob: %s, subject: %s</h1>", s.getName(), s.getDOB(),
                        s.getSubject()));
            }
            out.println("<form action=\"main.html\" >");
            out.println(" <input type=\"submit\" value=\"Go back to Menu\">");
            out.println("</form>");
            out.println("</body></html>");
        }
        if (option.equals("add student")) {
            response.sendRedirect("addStudent.html");

        }
        if (option.equals("modify subject")) {
            response.sendRedirect("modify_subject.html");
        }
        if (option.equals("search student")) {
            response.sendRedirect("search_student.html");
        }
    }
}
