import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.Instant;
import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
class Main {
    
    public static final String BLOCK = "█";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\033[38;2;255;143;184m";
    public static final ArrayList<String> PAGE_LIST = new ArrayList<>(Arrays.asList("home","tasks","exit"));
    public static void main(String args[]) {
        Boolean invalid = false;
        Boolean exit = false;
        Scanner input = new Scanner(System.in);
        
        //Sign-in not implemented yet
        // System.out.println("Create an Account:");
        // System.out.println("Enter name:");
        // String name = input.nextLine();
        // System.out.println("Creating account...");
        String name = "Matthew";
        User user = new User(name);
        //might change how this works...do i even need a manager?
        //I'll change it if it ever inconveniences me >:D
        Manager manager = new Manager();
        TaskManager taskManager = manager.getTasker();
        manager.setUser(user);


        String page = "home";

        while (!exit) {
            if (page.equals("home")) {
                System.out.printf("Welcome to your homepage, %s!\n\n",user.getName());

                System.out.println("1) Nav\n2) Exit");
                int op = intInput(input,2);
                if (op == 1) {
                    page = "nav";
                }
                else if (op == 2) {
                    page = "exit";
                }
                
            }
            else if (page.equals("tasks")) {
                Boolean texit = false;
                //otasks - original tasks (do not edit), etasks - edited tasks (edit)
                ArrayList<Task> otasks = taskManager.getTasks();
                ArrayList<Task> etasks = taskManager.getTasks();
                
                String sort = "";
                //while sort can be a single string (there is only one way to sort at a time),
                //filter is more complicated because there can be multiple filters
                //and you have to be able to remove filters
                //i've given up on sanitizing inputs because the real thing will have sliders yk
                //index 0: alpha, 1: day, 2: priority
                //-1: <=, 0: ==, 1: >=
                String[][] filter = {{"",""},{"",""},{"",""}};
                while (!texit) {
                    System.out.println("\nTasks Page:\n1) View tasks\n2) Add Task\n3) Delete Task\n4) Change Sort\n5) Change Filter\n6) Edit Task\n7) Back to Nav");
                    switch (input.nextLine()) {
                        case "1":
                            System.out.println("Tasks:\n");
                            System.out.println(TaskManager.printTasks(etasks));
                            break;
                        case "2":
                            System.out.println("Enter Task Name:");
                            String tname = input.nextLine();

                            System.out.println("Enter Due Time (yyyy-MM-dd HH:mm)");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                            LocalDateTime due = LocalDateTime.parse(input.nextLine(), formatter);

                            System.out.println("Enter Priority");
                            int priority = Integer.parseInt(input.nextLine());
                            taskManager.addTask(new Task(tname, due, priority));

                            System.out.println("A task has been added!");
                            break;
                        case "3":
                            System.out.println("Choose the task you wish to delete: ");
                            //because i'm extra, lets have it keep the filter & sort when choosing
                            Task deleteTask = TaskManager.chooseTask(input,etasks);

                            System.out.printf("Are you sure you want to delete %s? Type \"yes\" to confirm.\n",deleteTask.name);
                            
                            if (input.nextLine().toLowerCase() == "yes") {
                                taskManager.removeTask(deleteTask);
                                otasks.remove(deleteTask);
                                etasks.remove(deleteTask);
                                System.out.println("Delete succesful.");
                            }
                            else {
                                System.out.println("Delete cancelled.");
                            }
                            break;
                            
                            
                            

                        case "7":
                            page = "nav";
                            texit = true;
                            break;
                    }
                }
            
                        
            }
            else if (page.equals("nav")) {
                invalid = true;
                System.out.println("\nWhat would you like to do?\n\n1) Home\n2) Tasks\n3) Exit\n");
                
                int tpage = intInput(input,3);
                page = PAGE_LIST.get(tpage-1);

                
            }
            else if (page.equals("exit")) {
                exit = true;
                System.out.println("Exiting...");
            }
        }
    } 
    public static String rgb(int r,int g,int b,String message) {
        return String.format("\033[38;2;{};{};{}m" + message + ANSI_RESET,r,g,b);
    }

    //makes inputting ints for the option selection much easier
    //note max is inclusive
    //NOTE TO SELF: NEVER MAKE A NEW SCANNER JUST REUSE
    public static int intInput(Scanner input,int max) {
        Boolean invalid = true;
        int intInput = 0;
        while (invalid) { 
            invalid = false;
            intInput = Integer.parseInt(input.nextLine());
            if (intInput <= 0 || intInput > max) {
                System.out.println("Invalid input. Please try again:");
                invalid = true;
            }
            else {
                break;
            }
        }
        
        return intInput;
    }
}