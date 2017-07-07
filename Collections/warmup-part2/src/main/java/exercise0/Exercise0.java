package exercise0;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        //  Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        //  Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map
        Map<Integer, String> myMap = new HashMap<Integer, String>();
        myMap.put(2,"Ion");
        myMap.put(3,"Vasile");
        myMap.put(5,"Costel");
        myMap.put(12,"George");
        //  Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        //  Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]
        Set<Integer> mySet = myMap.keySet();
        Iterator it = mySet.iterator();
        while (it.hasNext()) {
            Object x = it.next();
            System.out.println( x + " =" + " " + myMap.get(x));
        }
        System.out.println(myMap);
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
