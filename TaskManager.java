import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    static ArrayList<Task> sortByDay(ArrayList<Task> tasks) {
        ArrayList<Task> sorted = tasks;
        Collections.sort(sorted,new Comparator<Task>(){
            public int compare(Task t1,Task t2) {
                LocalDate d1 = t1.getNextDue().toLocalDate();
                LocalDate d2 = t2.getNextDue().toLocalDate();
                return (int) ChronoUnit.DAYS.between(d1,d2);
            }
        });

        return sorted;

    }

    static ArrayList<Task> sortByPriority(ArrayList<Task> tasks) {
        ArrayList<Task> sorted = tasks;
        Collections.sort(sorted,new Comparator<Task>(){
            public int compare(Task t1,Task t2) {
                int p1 = t1.priority;
                int p2 = t2.priority;
                return p1-p2;
            }
        });

        return sorted;

    }

    @Override
    public String toString() {
        return "{" +
            " tasks='" + getTasks() + "'" +
            "}";
    }
    
}
