package exercise.exercise4;

import java.util.Comparator;

/**
 * Created by Cristian.Barbu on 7/5/2017.
 */
public class MyComparator<E> implements Comparator<E> {

    public int compare(Object o1, Object o2) {
        return o1.hashCode() - o2.hashCode();
    }
}
