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
        if (day == 0) {return tasks};
        LocalDate now = LocalDate.now();
        ArrayList<Task> filtered = new ArrayList<Task>();
        tasks.forEach((task) -> {
            LocalDate taskDay = task.getNextDue().toLocalDate();
            int dayDiff = (int) ChronoUnit.DAYS.between(now,taskDay);
            if (dayDiff <= day)
        });

    }
    

    @Override
    public String toString() {
        return "{" +
            " tasks='" + getTasks() + "'" +
            "}";
    }
    
}
