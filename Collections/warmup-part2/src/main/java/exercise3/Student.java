package exercise3;

/**
 * Created by Cristian.Barbu on 7/7/2017.
 */
public class Student {
    private String FirstName;
    private String LastName;

    public Student(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
