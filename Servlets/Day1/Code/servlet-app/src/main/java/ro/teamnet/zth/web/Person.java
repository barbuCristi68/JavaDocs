package ro.teamnet.zth.web;

/**
 * Created by Cristian.Barbu on 7/18/2017.
 */
public class Person implements  Comparable {
    public Person(String firstName, String lastName, Long age, boolean married) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
    }

    public String firstName;
    public String lastName;
    public Long age ;
    public boolean married;

    @Override
    public int compareTo(Object o) {
        Person x = (Person) o;
        if(this.age <= x.age )
            return -1;
        else if(this.age >= x.age)
            return 1;
        return 0;


    }
}
