
import java.util.*;
import java.lang.*;

/**
 * <pre>
 *     A simple java console program
 *     will create a todo list from user input

 * </pre>
 * @author Gregory Lauture
 * @version 1.0
 * @since 2022 -01-23
 */

public class todoList {

    private String topic;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    private List<Task> tasks;

    private static todoList instance;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }



    private todoList() {
        tasks = new LinkedList<>();
    }

    /**
     * generate a Singleton
     * @return
     */
    public static todoList getInstance() {
        if (instance == null)
                instance = new todoList();

        return instance;
    }

    static boolean isInteger(int number){
        return Math.ceil(number)==Math.floor(number);

    }

    /**
     * Constructor method to add a new task
     * based on user input
     * it assume the existence of the list
     * @param task
     * @return
     */

    public Task addTask(Task task) {
        String choice;
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("do you want to add a task (y/n)");

            choice = input.nextLine().toLowerCase();
            switch (choice) {
                case "y":
                    System.out.println("Please enter task name");
                    String name = sc.nextLine();
                    boolean d;
                    while(true) {

                        Scanner keyboard = new Scanner(System.in);
                        System.out.println("Please enter the completion (true/false)");

                        if(keyboard.hasNextBoolean()){
                            d = keyboard.nextBoolean();
                            System.out.println();
                            break;
                        }

                    }

                    int ID = 0;
                    Scanner digit;
                    do {

                        try {
                            digit = new Scanner(System.in);
                            System.out.println("Please enter priority(1 to 5)");
                            ID = digit.nextInt();
                            break;

                        } catch (InputMismatchException | NumberFormatException ex) {
                            System.out.println("Please enter a valid integer\n");

                        }
                    }while(ID< 1 || ID >5);

                    Task t = new Task();
                    t.setName(name);
                    t.setDone(d);
                    t.setPrioID(ID);
                    tasks.add(t);
                    System.out.println("Task added successfully.");
                    break;
                case "n":
                    System.out.println("No more task.");
                    break;
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        } while (!choice.equals("n"));
        return task;
    }



    /**constructor method to add task
     * it will check the presence of an existing list
     * @param ID
     * @param name
     * @param d
     */
    public void addTask(int ID, String name, boolean d){

            Task t = new Task();
            t.setName(name);
            t.setDone(d);
            t.setPrioID(ID);
            tasks.add(t);
            System.out.println("Task added successfully.");

    }

    /**
     * method to remove a task
     * it will check for the presence of a list
     * also if the given task exist
     * @param task
     */
    public void removeTask(String task) {
        try {
            for (ListIterator<Task> itr = this.tasks.listIterator(); itr.hasNext();) {
                Task t = itr.next();
                if (t.getName().contains(task)) {
                    System.out.println("removing task " +t.getName());
                    itr.remove();
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No such task ");

        }
    }


    /** method to modify a given task
     * it will check for the presence of a list
     * also if the given task exist
     * @param task
     */
    public void modifyTask(String task) {
        if (this.tasks.isEmpty()) {
            System.out.println("You have no data");
        } else {
            try {
                for (Task t : tasks) {
                    if (Objects.equals(t.getName(), task)) {

                        System.out.println("modify task: " + task);
                        boolean d;
                        while (true) {

                            Scanner keyboard = new Scanner(System.in);
                            System.out.println("Please enter the completion (true/false)");

                            if (keyboard.hasNextBoolean()) {
                                d = keyboard.nextBoolean();
                                System.out.println();
                                break;
                            }

                        }

                        int ID = 0;
                        Scanner digit;
                        do {

                            try {
                                digit = new Scanner(System.in);
                                System.out.println("Please enter priority(1 to 5)");
                                ID = digit.nextInt();
                                break;

                            } catch (InputMismatchException | NumberFormatException ex) {
                                System.out.println("Please enter a valid integer\n");

                            }
                        } while (ID < 1 || ID > 5);

                        t.setPrioID(ID);
                        t.setDone(d);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No such task ");

            }
        }
    }

    public void modifyTask(String task, int ID, boolean d) {
        if (this.tasks.isEmpty()) {
            System.out.println("You have no data");
        } else {
            try {
                for (Task t : tasks) {
                    if (Objects.equals(t.getName(), task)) {
                        t.setPrioID(ID);
                        t.setDone(d);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No such task ");

            }
        }
    }


    /**
     * simple method to display the list of tasks
     */
    public void display() {
        if (this.tasks.isEmpty()) {
            System.out.println("You have no data");}


        else {
            String choice;


            do {
                Scanner ct = new Scanner(System.in);

                choice = ct.nextLine().toLowerCase();

                System.out.println("::::::::::::::::::::::::::::::::::::::::");
                System.out.println("My tasks list");
                System.out.println("________________________________________");
                System.out.println("\t1.- Display all tasks (a)");
                System.out.println("\t2.- Display completed tasks (c)");
                System.out.println("\t3.- Display task non completed (n)");
                System.out.println("\t7.- Quit the program (q)");
                System.out.println("________________________________________");

                System.out.println("::::::::::::::::::::::::::::::::::::::::");




                switch (choice) {
                    case "a":
                        System.out.println("All the tasks");
                        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
                        System.out.println(getTopic());
                        System.out.println("_____________________________________________________");

                        for (Task t : tasks) {
                            System.out.println(t);
                        }
                        System.out.println("_____________________________________________________");

                        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
                        break;
                    case "c":
                        System.out.println("Completed tasks");
                        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
                        System.out.println(getTopic());
                        System.out.println("_____________________________________________________");

                        for (Task t : tasks) {
                            if(t.isDone())
                            System.out.println(t);
                        }
                        System.out.println("_____________________________________________________");

                        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
                        break;
                    case "n":
                        System.out.println("All active tasks");
                        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
                        System.out.println(getTopic());
                        System.out.println("_____________________________________________________");

                        for (Task t : tasks) {
                            if(!t.isDone())
                            System.out.println(t);
                        }
                        System.out.println("_____________________________________________________");

                        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
                        break;

                    case "q":
                        System.out.println("Goodbye...");
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                        break;


                }
            } while (!choice.equals("q"));
        }

        }




}