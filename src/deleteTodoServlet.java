import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
/**
 * Java servlet to delete a record from the database using the showTodoServlet servlet
 */
public class deleteTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //link the bootstrap
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<meta charset="+"ISO-8859-1"+">");
        pw.println("<title>Insert title here</title>");
        pw.println("<link rel="+"stylesheet");
        pw.println("href="+"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css");
        pw.println("integrity="+"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm");
        pw.println("crossorigin="+"anonymous"+">");
        pw.println("<style>");
        pw.println("#div{");
        pw.println("width:600px;");
        pw.println("height:350px;");
        pw.println("margin:auto;");
        pw.println("margin-top:100px;");
        pw.println("}");
        pw.println("</style>");
        pw.println("</head>");
        //get the values
        int id = Integer.parseInt(req.getParameter("id"));
        ManageTask MT = new ManageTask();
        int count  = MT.deleteTask(id);
            if(count>0) {
                pw.println("<h2 class='bg-danger text-light text-center'>Todo Deleted Successfully</h2>");
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Todo Not Deleted</h2>");
            }

        pw.println("<a href='index.jsp'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("&nbsp; &nbsp;");
        
        //close the stream
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}


