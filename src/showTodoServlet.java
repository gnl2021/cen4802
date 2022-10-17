import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showdata")
public class showTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManageTask MT = new ManageTask();
        List<Task> todo = MT.listTasks();
        //get PrintWriter
        PrintWriter pw = resp.getWriter();
        //set content type
        resp.setContentType("text/html");
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
        pw.println("<marquee><h2 class='text-primary'>Todo List</h2></marquee>");
        pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
        pw.println("<table class='table table-hover table-striped'>");
        pw.println("<tr>");
        pw.println("<th>ID</th>");
        pw.println("<th>Name</th>");
        pw.println("<th>Priority</th>");
        pw.println("<th>Completion</th>");
        pw.println("<th>Edit</th>");
        pw.println("<th>Delete</th>");
        pw.println("</tr>");
        for (ListIterator<Task> itr = todo.listIterator(); itr.hasNext(); ) {
            Task t = itr.next();
                pw.println("<tr>");
                pw.println("<td>" + t.getID() + "</td>");
                pw.println("<td>" + t.getName() + "</td>");
                pw.println("<td>" + t.getPrioID() + "</td>");
                pw.println("<td>" + t.isDone() + "</td>");
                pw.println("<td><a href='edit.jsp?id=" + t.getID() + "'>Edit</a></td>");
                pw.println("<td><a href='delete?id=" + t.getID() + "'>Delete</a></td>");
                pw.println("</tr>");

        }
            pw.println("</table>");
            pw.println("<button class='btn btn-outline-success d-block'><a href='index.jsp'>Home</a></button>");
            pw.println("</div>");
            //close the stream
            pw.close();
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}







