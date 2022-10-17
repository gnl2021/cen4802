import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * <pre>
 * The ManageTask class. A class used to run simple database operations for the todoList app
 * The premise is to have an existing database todolist,
 * using the hibernate configuration file and the class Task hibernate configuration,
 * it will automatically create a table Task if not present on the database.
 * Various will help with simple operations like, add, update and delete a records.
 * There is a menu function with a demo choice that test the various choice

 * </pre>
 * @author Gregory Lauture
 * @version 1.0
 * @since 2022 -02-13
 */
public class ManageTask {
    private static SessionFactory factory;

    /**
     * Method to check  connection to the database
     */
    public ManageTask(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Simple menu interface for the various operations
     */
    public static void menu(){
        String choice;
        do {
            todoList MT = todoList.getInstance();
            ManageTask myDB=new ManageTask();
            System.out.println("::::::::::::::::::::::::::::::::::::::::");
            System.out.println("todoList DB operations");
            System.out.println("________________________________________");
            System.out.println("\t1.- add Record (a)");
            System.out.println("\t2.- Modify record / id(m)");
            System.out.println("\t2.- Modify record / string(u)");
            System.out.println("\t3.- Delete record (d)");
            System.out.println("\t4.- Display records (r)");
            System.out.println("\t5.- Run a demo (t)");
            System.out.println("\t6.- Quit the program (q)");
            System.out.println("________________________________________");

            System.out.println("::::::::::::::::::::::::::::::::::::::::");

            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);

            choice = sc.nextLine().toLowerCase();
            todoList mylist = todoList.getInstance();


            switch (choice) {
                case "a":
                    mylist.addTask(new Task());
                    for(Task t: mylist.getTasks()) {
                        String n = t.getName();
                        int i = t.getPrioID();
                        boolean d = t.isDone();
                        myDB.addTask(i, n, d);
                    }
                    break;
                case "m":
                    System.out.println("Updating record status using id...");
                    System.out.println("enter the record id");
                    int id2 =sc2.nextInt();
                    System.out.println("enter the new completion status(true/false)");
                    boolean d2 =sc2.nextBoolean();
                    myDB.updateTask(id2, d2);
                    break;
                case "u":
                    System.out.println("Updating record status using name...");
                    System.out.println("enter the record name");
                    String n2 =sc2.nextLine();
                    System.out.println("enter the new completion status(true/false)");
                    boolean d3 =sc2.nextBoolean();
                    myDB.updateTask(n2, d3);
                    break;

                case "d":
                    System.out.println("Deleting record using id...");
                    System.out.println("enter the record id");
                    int id3 =sc2.nextInt();
                    myDB.deleteTask(id3);
                    break;
                case "r":
                    myDB.listTasks();
                    break;
                case "t":

                    MT.addTask(1,"Wake up", false);
                    MT.addTask(2,"Shower", false);
                    MT.addTask(3,"Have breakfast", false);
                    MT.addTask(4, "Do Homework", false);
                    MT.addTask(5, "Take bus", false);
                    MT.addTask(1,"Go to class", false);
                    MT.addTask(2,"Go to Library", false);
                    MT.addTask(3,"Go to Study group", false);
                    MT.addTask(4, "Have Dinner", false);
                    MT.addTask(5, "Get back to class", false);
                    MT.addTask(1,"Take bus back", false);
                    MT.addTask(2,"Shower", false);
                    MT.addTask(3,"Have supper", false);
                    MT.addTask(4, "Do Homework", false);
                    MT.addTask(5, "Watch news", false);
                    MT.addTask(1,"Help with kitchen", false);
                    MT.addTask(2,"Talk with family", false);
                    MT.addTask(3,"Have break", false);
                    MT.addTask(4, "Planning for tomorrow", false);
                    MT.addTask(5, "Go to Bed", false);
                    System.out.println("Update list");
                    /* add all the tasks to the database */
                    updateTaskList(MT);
                    /* List down all the tasks */
                    myDB.listTasks();
                    /* Update a task status */
                    myDB.updateTask(2, true);
                    myDB.listTasks();
                    myDB.updateTask("Do Homework",true);
                    /* Delete a task from the database */
                    myDB.deleteTask(1);
                    myDB.listTasks();
                    /* List down new list of tasks */
                    break;
                case "q":
                    System.out.println("Goodbye...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid input");
                    break;


            }
        } while (!choice.equals("q"));
    }


    /**
     * Method to add a task to the database,
     * will return the unique id generated
     * @param pID
     * @param name
     * @param d
     * @return
     */
    public Integer addTask(int pID, String name, boolean d){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer taskID = null;

        try {
            tx = session.beginTransaction();
            Task task = new Task(pID, name, d);
            taskID = (Integer) session.save(task);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return taskID;
    }

    /**
     * Method to  READ all the tasks
     * @return
     */
    public List<Task> listTasks( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Task> tasks = null;

        try {
            tx = session.beginTransaction();
            tasks = session.createQuery("FROM Task").list();
            for (Iterator iterator = tasks.iterator(); iterator.hasNext();){
                Task task = (Task) iterator.next();
                System.out.print("Name: " + task.getName());
                System.out.print("  Priority: " + task.getPrioID());
                System.out.println("  Completion: " + task.isDone());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tasks;
    }

    /* Method to UPDATE task for a task */

    /**
     * Method to update a task status
     * by taking a string parameter as input for record
     * then update the boolean status
     * @param name
     * @param t
     * @return
     */

    public int updateTask(String name, Boolean t ){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Simple update");
        if (t){

        String hql = "UPDATE Task SET completion = 1 WHERE name ='"+name+"'";
            Query query;
            query = session.createQuery(hql);
            query.executeUpdate();
            tx.commit();
            session.close();}
        if (!t){

            String hql = "UPDATE Task SET completion = 0 WHERE name ='"+name+"'";
            Query query;
            query = session.createQuery(hql);
            query.executeUpdate();
            tx.commit();
            session.close();}

        return 1;
    }

    /**
     * Method to update a task status
     * by taking a integer to look  for record
     * then update the boolean status
     * @param TaskID
     * @param completion
     */
    public void updateTask(Integer TaskID, boolean completion ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Task task = session.get(Task.class, TaskID);
            task.setDone( completion );
            session.update(task);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Method to using in case of saving a list of records
     * @param t
     */
    public static void updateTaskList(todoList t){
        Session session = factory.openSession();
        // Reading complete Entity
        System.out.println("Update list");
        Transaction tx =  session.beginTransaction();
            for(Task ts : t.getTasks()) {
                session.save(ts);
            }
        tx.commit();
            session.close();

    }


    /**
     * Method that remove a record using an integer as query
     * @param TaskID
     * @return
     */
    public int deleteTask(Integer TaskID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Task task = session.get(Task.class, TaskID);
            session.delete(task);
            tx.commit();
            return TaskID;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return 0;

        } finally {
            session.close();
        }
    }
    public static void main(String[] args) {
        menu();
    }

    public int addTask(Task user) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer taskID = null;

        try {
            tx = session.beginTransaction();
            taskID = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return taskID;
    }

    public void updateTask(Task mytask) {
    }

    public int updateTask(int TaskID, Task t) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Task task = session.get(Task.class, TaskID);
            task.setName( t.getName() );
            task.setPrioID( t.getPrioID() );
            task.setDone( t.isDone() );
            System.out.println(task);
            session.update(task);
            tx.commit();
            return TaskID;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }
}
