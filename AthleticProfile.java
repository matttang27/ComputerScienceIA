import java.util.ArrayList;
import java.util.HashMap;

public class AthleticProfile {
    
    int id;
    //all profiles are tracked by the id (either student # or teacher #)
    
    PersonalProfile personalProfile;
    ArrayList<Player> teams;
    HashMap<String,Info> otherInfo;
    ArrayList<Result> results;

    AthleticProfile(PersonalProfile personalProfile,ArrayList<Player> teams,HashMap<String,Info> otherInfo,ArrayList<Result> results) {
        this.personalProfile = personalProfile;
        this.teams = teams;
        this.otherInfo = otherInfo;
        this.results = results;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonalProfile getPersonalProfile() {
        return this.personalProfile;
    }

    public void setPersonalProfile(PersonalProfile personalProfile) {
        this.personalProfile = personalProfile;
    }

    

    public ArrayList<Player> getTeams() {
        return this.teams;
    }

    public void setTeams(ArrayList<Player> teams) {
        this.teams = teams;
    }

    public HashMap<String,Info> getOtherInfo() {
        return this.otherInfo;
    }

    public void setOtherInfo(HashMap<String,Info> otherInfo) {
        this.otherInfo = otherInfo;
    }

    public ArrayList<Result> getResults() {
        return this.results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public String toString() {
        return String.format("Name: %s %s",personalProfile.firstName,personalProfile.lastName);
    }
    

}
