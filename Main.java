import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class Main {
    public static void main(String args[]) {
        

        
        Scanner input = new Scanner(System.in);
        Manager manager = new Manager();
        TaskManager taskManager = manager.getTasker();
        System.out.println("Commands:\n\n1) New Task\n\n2) View all tasks\n\n");
        while (true) {
            switch (input.nextLine()) {
                case "1":
                    System.out.println("Enter Task Name:");
                    String name = input.nextLine();
                    
                    
            }
        }
    }
}