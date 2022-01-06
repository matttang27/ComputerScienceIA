import java.util.ArrayList;
public class Manager {
    TaskManager tasker;
    Manager() {
        tasker = new TaskManager();
    }

    public TaskManager getTasker() {
        return this.tasker;
    }

    public void setTasker(TaskManager tasker) {
        this.tasker = tasker;
    }
    
    @Override
    public String toString() {
        return "{" +
            " tasker='" + getTasker() + "'" +
            "}";
    }

}
