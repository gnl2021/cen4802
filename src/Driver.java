import java.io.IOException;
import java.util.Scanner;


public class Driver {


    public static void menu(){
        String choice;
        do {
            System.out.println("::::::::::::::::::::::::::::::::::::::::");
            System.out.println("Simple todoList");
            System.out.println("________________________________________");
            System.out.println("\t1.- Create a todoList (c)");
            System.out.println("\t2.- Add task to the todoList (a)");
            System.out.println("\t3.- Modify a task (m)");
            System.out.println("\t4.- Remove a task (r)");
            System.out.println("\t5.- Display your todoList (d)");
            System.out.println("\t6.- Run a demo (t)");
            System.out.println("\t7.- Quit the program (q)");
            System.out.println("________________________________________");

            System.out.println("::::::::::::::::::::::::::::::::::::::::");

            Scanner inp = new Scanner(System.in);
            Scanner sc = new Scanner(System.in);


            choice = sc.nextLine().toLowerCase();
            todoList mylist = todoList.getInstance();


            switch (choice) {
                case "c":
                    System.out.println("Please enter your list name");
                    String listname = inp.nextLine();
                    mylist.setTopic(listname);
                    break;
                case "a":
                    mylist.addTask(new Task());
                    break;
                case "m":
                    System.out.println("Please enter task to modify");
                    String mtask = inp.nextLine();
                    mylist.modifyTask(mtask);
                    break;
                case "r":
                    System.out.println("Please enter task to remove");
                    String rtask = inp.next();
                    mylist.removeTask(rtask);
                    break;
                case "d":
                    mylist.display();
                    break;
                case "t":
                    mylist.setTopic("MY DAILY TASKS");
                    mylist.addTask(1,"Wake up", false);
                    mylist.addTask(2,"Shower", false);
                    mylist.addTask(3,"Have breakfast", false);
                    mylist.addTask(4, "Do Homework", false);
                    mylist.addTask(5, "Go to Class", false);
                    mylist.modifyTask("Do Homework", 5, true);

                    mylist.display();
                    mylist.removeTask("Wake up");
                    mylist.removeTask("Have breakfast");
                    mylist.display();

                    mylist.modifyTask("Shower", 3, true);
                    mylist.display();
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

    public static void main(String[] args)  {
        menu();

    }

}