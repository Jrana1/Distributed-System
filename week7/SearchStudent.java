

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search_student")
public class SearchStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        University university = (University) getServletContext().getAttribute("university");
        var st = university.getStudentByName(name);
        out.println("<html><body>");
        if(st!=null){
            out.println(String.format("<h1>student found with name: %s, dob: %s, subject: %s </h1>",st.getName(),st.getDOB(),st.getSubject()));
        }
        else{
            out.println(String.format("<h1>student with name %s has not been found!!</h1>",name));
        }
        out.println("<form action=\"main.html\" >");
        out.println(" <input type=\"submit\" value=\"Go back to Menu\">");
        out.println("</form>");
        out.println("</body></html>");
    }
}
