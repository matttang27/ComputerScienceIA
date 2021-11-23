import java.util.Date;
public class PersonalProfile {
    String firstName;
    String lastName;
    int age;
    Date birthday;
    int grade;
    PersonalProfile(String f,String l,int a,Date b) {
        firstName = f;
        lastName = l;
        age = a;
        birthday = b;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    void syncGrade() {
        grade = age - 6;
    }
    void syncAge() {
        //I need to read more on dates because I have no clue what's happening
        syncGrade();
    }
}
