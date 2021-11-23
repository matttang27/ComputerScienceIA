import java.util.ArrayList;
import java.util.Date;
public class Team {
    ArrayList<AthleticProfile> players;
    ArrayList<AthleticProfile> coaches;
    ArrayList<Result> results;
    String name;
    Date dateStart;
    Date dateEnd;

    public Team(ArrayList<AthleticProfile> players, ArrayList<AthleticProfile> coaches, ArrayList<Result> results, String name, Date dateStart, Date dateEnd) {
        this.players = players;
        this.coaches = coaches;
        this.results = results;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public ArrayList<AthleticProfile> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<AthleticProfile> players) {
        this.players = players;
    }

    public ArrayList<AthleticProfile> getCoaches() {
        return this.coaches;
    }

    public void setCoaches(ArrayList<AthleticProfile> coaches) {
        this.coaches = coaches;
    }

    public ArrayList<Result> getResults() {
        return this.results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

}
