import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
/**
 * Java servlet to add a record to the database using the index.jsp page
 */
public class addTodoServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get the printWriter
        PrintWriter pw = resp.getWriter();
        //set Content Type
        resp.setContentType("text/html");
        //read the form dat
        String name = req.getParameter("name");
        String prioId = req.getParameter("prioID");
        String completion = req.getParameter("Done");

        Task mytask = new Task();
        ManageTask MT = new ManageTask();
        mytask.setName(name);
        mytask.setPrioID(Integer.parseInt(prioId));
        mytask.setDone(Boolean.parseBoolean(completion));

        int count = MT.addTask(mytask);

        if(count==0) {
            pw.println("<h2>Todo not added</h2>");
            pw.println("<a href='index.jsp'>Home</a>");
        }else {
            pw.println("<h2>Todo added successfully</h2>");
            pw.println("<a href='index.jsp'>Home</a>");
        }
        //close the stream
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}







