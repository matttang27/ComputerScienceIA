import java.util.ArrayList;
public class Manager {


    //currently this is so that everything can be connected to one spot, but not sure if I really need that
    TaskManager tasker;
    GroupManager grouper;
    User user;

    public GroupManager getGrouper() {
        return this.grouper;
    }

    public void setGrouper(GroupManager grouper) {
        this.grouper = grouper;
    }

    public ArrayList<Schedule> getSchedule() {
        return this.schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }
    ArrayList<Schedule> schedule;
    Manager() {
        tasker = new TaskManager();
        grouper = new GroupManager();
        schedule = new ArrayList<Schedule>();
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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
