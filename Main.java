import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Instant;
import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Main {
    public static final String BLOCK = "█";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\033[38;2;255;143;184m";
    public static void main(String args[]) {
        
        
        
        
        
        
        

        System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
        Scanner input = new Scanner(System.in);
        Manager manager = new Manager();
        TaskManager taskManager = manager.getTasker();
        
        while (true) {
            System.out.println("Commands:\n\n1) New Task\n\n2) View all tasks\n\n");
            switch (input.nextLine()) {
                case "1":
                    System.out.println("Enter Task Name:");
                    String name = input.nextLine();

                    System.out.println("Enter Due Time (yyyy-MM-dd HH:mm)");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime due = LocalDateTime.parse(input.nextLine(), formatter);

                    System.out.println("Enter Priority");
                    int priority = Integer.parseInt(input.nextLine());
                    taskManager.addTask(new Task(name, due, priority));

                    System.out.println("A task has been added!");
                    break;
                case "2":
                    System.out.println("Tasks:\n");
                    System.out.println(taskManager.printTasks());
                    break;
                    
            }
        }
    }
    public static String rgb(int r,int g,int b,String message) {
        return String.format("\033[38;2;{};{};{}m" + message + ANSI_RESET,r,g,b);
    }
}