import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 *     java class
 *     with the basic constructors
 *     to use with the todolist
 * </pre>
 * @author Gregory Lauture
 * @version 1.0
 * @since 2022 -01-17
 */

public class Task {


    private int prioID;
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public boolean isDone() {
        return Done;
    }

    public void setDone(boolean done) {
        this.Done = done;
    }

    private boolean Done;


    public int getPrioID() {
        return prioID;
    }

    public void setPrioID(int prioID) {
        this.prioID = prioID;
    }




    public Task(int id, String name, boolean d)  {
        super();
        this.prioID = id;
        this.name = name;
        this.Done = d;
    }

    public Task() {

    }


    @Override
    public String toString() {
        return "Task priority: " + prioID + ", name=" + name+ (Done ? ". Task complete." : ". Task active.");
    }





}