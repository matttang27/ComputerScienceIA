import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class TaskManager {
    ArrayList<Task> tasks;
    TaskManager() {
        tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Task blankTask() {
        Task t = new Task();
        t.setId(tasks.size());
        tasks.add(t);
        return t;
    }
    static ArrayList<Task> filterByDay(ArrayList<Task> tasks, int day) {
        if (day == 0) {return tasks;};
        LocalDate now = LocalDate.now();
        ArrayList<Task> filtered = new ArrayList<Task>();
        tasks.forEach((task) -> {
            LocalDate taskDay = task.getNextDue().toLocalDate();
            int dayDiff = (int) ChronoUnit.DAYS.between(now,taskDay);
            if (dayDiff <= day) {
                filtered.add(task);
            }
        });
        return filtered;

    }
    static ArrayList<Task> filterByPriority(ArrayList<Task> tasks, int priority) {
        if (priority == 0) {return tasks;};
        ArrayList<Task> filtered = new ArrayList<Task>();
        tasks.forEach((task) -> {
            if (task.priority >= priority) {
                filtered.add(task);
            }
        });
        return filtered;

    }
    /*
    TODO: Implement Groups
    static ArrayList<Task> filterByGroup(ArrayList<Task> tasks, ArrayList<String> groups) {
        if (groups.equals("")) {return tasks;};
        ArrayList<Task> filtered = new ArrayList<Task>();
        tasks.forEach((task) -> {
            if (groups.contains(task.group)) {
                filtered.add(task);
            }
        });
        return filtered;

    }
    */
    

    @Override
    public String toString() {
        return "{" +
            " tasks='" + getTasks() + "'" +
            "}";
    }
    
}
