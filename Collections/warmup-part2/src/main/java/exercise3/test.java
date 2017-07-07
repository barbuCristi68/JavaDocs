package exercise3;


import java.util.*;

/**
 * Created by Cristian.Barbu on 7/7/2017.
 */
public class test {
    public static void main(String[] args) {

        Map<Student, Integer> map1 = new HashMap<Student, Integer>();
        Map<Student, Integer> map2 = new HashMap<Student, Integer>();
        Map<Student, Integer> map3 = new HashMap<Student, Integer>();
        Map<Student, Integer> map4 = new HashMap<Student, Integer>();


        Student[] students = {new Student("Popescu", "Mihai"),
                new Student1( "Ionescu", "Ion"),
                new Student( "Popa", "Cristina"),
                new Student( "Barbu", "Mihai"),
                new Student( "Popescu", "Mihai"),
                new Student( "Serban", "Alin"),
                new Student( "Georgescu", "Andreea"),
                new Student( "Popa", "Cristina"),
                new Student( "Popescu", "Mihai"),};

        List<Student> studentList;

        studentList = new ArrayList<Student>(Arrays.asList(students));

        for(Student s:studentList){
           map1.put(s,1);
           map2.put(s,2);
           map3.put(s,45);
           map4.put(s,44);
        }

    }
}
