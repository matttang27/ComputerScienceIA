import java.util.ArrayList;
public class Manager {


    //currently this is so that everything can be connected to one spot, but not sure if I really need that
    TaskManager tasker;
    User user;
    ArrayList<Schedule> schedule;
    Manager() {
        tasker = new TaskManager();
        schedule = new ArrayList<Schedule>();
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Schedule> getSchedule() {
        return this.schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
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
