import java.time.LocalDateTime;
import java.awt.Color;
public class Task {
    String name;
    LocalDateTime created;
    LocalDateTime lastEdited;
    LocalDateTime nextDue;
    String cronJob;
    int priority;
    boolean done;
    Color color;
    String background;
    String icon;
    Task parent;
    String description;
    int id;

    public Task(String name, LocalDateTime created, LocalDateTime lastEdited, LocalDateTime nextDue, String cronJob, int priority, boolean done, Color color, String background, String icon, Task parent, String description, int id) {
        this.name = name;
        this.created = created;
        this.lastEdited = lastEdited;
        this.nextDue = nextDue;
        this.cronJob = cronJob;
        this.priority = priority;
        this.done = done;
        this.color = color;
        this.background = background;
        this.icon = icon;
        this.parent = parent;
        this.description = description;
        this.id = id;
    }
    public Task() {
        name="Blank Task";
        color=null;
        background="";
        icon="";
        description="";
        created = LocalDateTime.now();
        lastEdited = LocalDateTime.now();
        done = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastEdited() {
        return this.lastEdited;
    }

    public void setLastEdited(LocalDateTime lastEdited) {
        this.lastEdited = lastEdited;
    }

    public LocalDateTime getNextDue() {
        return this.nextDue;
    }

    public void setNextDue(LocalDateTime nextDue) {
        this.nextDue = nextDue;
    }

    public String getCronJob() {
        return this.cronJob;
    }

    public void setCronJob(String cronJob) {
        this.cronJob = cronJob;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return this.done;
    }

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getBackground() {
        return this.background;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", created='" + getCreated() + "'" +
            ", lastEdited='" + getLastEdited() + "'" +
            ", nextDue='" + getNextDue() + "'" +
            ", cronJob='" + getCronJob() + "'" +
            ", priority='" + getPriority() + "'" +
            ", done='" + isDone() + "'" +
            ", color='" + getColor() + "'" +
            ", background='" + getBackground() + "'" +
            ", icon='" + getIcon() + "'" +
            ", parent='" + getParent() + "'" +
            ", description='" + getDescription() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Task getParent() {
        return this.parent;
    }

    public void setParent(Task parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
