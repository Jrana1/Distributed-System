

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/modify_subject")
public class ModifySubject extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String newSubject = request.getParameter("subject");
        PrintWriter out = response.getWriter();
        University university = (University) getServletContext().getAttribute("university");
        var st = university.getStudentByName(name);
        out.println("<html><body>");
        if(st!=null){
            String prevSubject = st.getSubject();
            st.setSubject(newSubject);
            out.println(String.format("<h1> subject has been changed from %s to %s !!</h1>",prevSubject,newSubject));
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
