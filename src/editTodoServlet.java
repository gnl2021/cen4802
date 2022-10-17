import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/edit")
/**
 * Java servlet to modify a record from the database using the edit.jsp page and the showTodoServlet servlet    -
 */
public class editTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");

        String name = req.getParameter("name");
        String prioId = req.getParameter("prioID");
        String completion = req.getParameter("Done");

        Task mytask = new Task();
        ManageTask MT = new ManageTask();
        mytask.setName(name);
        mytask.setPrioID(Integer.parseInt(prioId));
        mytask.setDone(Boolean.parseBoolean(completion));
        int ID = Integer.parseInt(req.getParameter("id"));
        System.out.println("TaskID is"+ID);
        int count  = MT.updateTask(ID,mytask);
        if(count==0) {
            pw.println("<h2>Todo not modified</h2>");
        }else {
            pw.println("<h2>Todo modified successfully</h2>");
        }
        pw.println("<a href='index.jsp'>Home</a>");
        //close the stream
        pw.close();


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}
