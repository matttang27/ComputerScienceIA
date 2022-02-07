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
                ArrayList<Task> tempTasks = taskManager.cloneTasks();
                
                String sort = "alpha";
                Boolean ascending = true;
                //while sort can be a single string (there is only one way to sort at a time),
                //filter is more complicated because there can be multiple filters
                //and you have to be able to remove filters
                //i've given up on sanitizing inputs because the real thing will have sliders yk
                //index 0: alpha, 1: day, 2: priority
                //inside array:
                //index 0: -1: <=, 0: ==, 1: >=
                //index 1: actual value
                int chosen;
                String[][] filter = {{"",""},{"",""},{"",""}};
                while (!texit) {
                    System.out.println("\nTasks Page:\n1) View tasks\n2) Add Task\n3) Delete Task\n4) Change Sort\n5) Change Filter\n6) Edit Task\n7) Back to Nav");
                    switch (input.nextLine()) {
                        case "1":
                            System.out.println("Tasks:\n");
                            tempTasks = taskManager.cloneTasks();
                            tempTasks = TaskManager.taskSortFilter(sort, ascending, filter, tempTasks);

                            //while originally i had a seperate array that was edited
                            //program now manually generates the task copy and filter / sorts it.
                            System.out.println(TaskManager.printTasks(tempTasks));
                            break;
                        case "2":
                            System.out.println("Enter Task Name:");
                            String tname = input.nextLine();

                            System.out.println("Enter Due Time (yyyy-MM-dd HH:mm)");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                            LocalDateTime due = LocalDateTime.parse(input.nextLine(), formatter);

                            System.out.println("Enter Priority");
                            int priority = Integer.parseInt(input.nextLine());
                            Task newTask = new Task(tname,due,priority);
                            taskManager.addTask(newTask);
                            
                            System.out.println("A task has been added!");
                            break;
                        case "3":
                            //also generates a copy each time
                            if (taskManager.getTasks().size() == 0) {
                                System.out.println("No tasks");
                                break;
                            }
                            System.out.println("Choose the task you wish to delete: ");
                            //because i'm extra, lets have it keep the filter & sort when choosing
                            Task deleteTask = TaskManager.chooseTask(input,taskManager.getTasks());
                            
                            System.out.printf("Are you sure you want to delete %s? Type \"yes\" to confirm.\n",deleteTask.name);
                            
                            if (input.nextLine().toLowerCase().equals("yes")) {
                                taskManager.removeTask(deleteTask);
                                
                                System.out.println("Delete succesful.");
                            }
                            else {
                                System.out.println("Delete cancelled.");
                            }
                            break;
                        case "4":
                            System.out.println("Choose sort property: \n1) Alphabetical\n2) Due Date\n3) Priority");
                            chosen = Main.intInput(input,3);
                            System.out.println("1) Ascending\n2) Descending");
                            
                            ascending = (Main.intInput(input,2) == 1);
                            if (chosen == 1) {
                                sort = "alpha";

                            }
                            else if (chosen == 2) {
                                sort = "day";
                            }
                            else if (chosen == 3) {
                                sort = "priority";
                            }

                            //this is a goddamn lie but they'll never know
                            System.out.println("The tasks have been sorted.");
                            break;
                        case "5":
                            System.out.println("Choose filter property: \n1) Alphabetical\n2) Due Date\n3) Priority");
                            chosen = Main.intInput(input,3);

                            System.out.println("Choose compare function: \n1) <=\n2) ==\n3) >=\n4) Remove");
                            String cf = Integer.toString(Main.intInput(input,3) - 2);
                            if (cf.equals("2")) {
                                filter[chosen-1][0] = "";
                                filter[chosen-1][1] = "";
                                break;
                            }
                            else {
                                filter[chosen-1][0] = Integer.toString(Integer.parseInt(cf) - 2);
                                //It would be a great idea to sanitize this but 
                                System.out.println("Threshold:");
                                filter[chosen-1][1] = input.nextLine();
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