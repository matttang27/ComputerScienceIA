import java.util.ArrayList;
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
    

    @Override
    public String toString() {
        return "{" +
            " tasks='" + getTasks() + "'" +
            "}";
    }
    
}
