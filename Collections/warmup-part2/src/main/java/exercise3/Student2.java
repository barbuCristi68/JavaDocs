package exercise3;

/**
 * Created by Cristian.Barbu on 7/7/2017.
 */
public class Student2 extends  Student {
    public Student2(String firstName, String lastName) {
        super(firstName, lastName);
    }
    public boolean equals(Object o) {

        if( this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Student newStudent = (Student) o;
        if(!this.getFirstName().equals(newStudent.getFirstName())) return false;
        if(!this.getLastName().equals(newStudent.getLastName())) return false;


        return true;

    }

    public int hashCode(){
        int result =this.getFirstName().hashCode();
        return result;
    }
}
