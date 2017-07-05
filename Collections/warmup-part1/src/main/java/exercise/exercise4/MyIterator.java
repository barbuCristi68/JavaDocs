package exercise.exercise4;

import java.util.Iterator;


/**
 * Created by Cristian.Barbu on 7/5/2017.
 */
public class MyIterator<E> implements Iterator<E> {
    int cursor = 0;
    MyImplementedList my;
    public MyIterator(MyImplementedList<E> my){
        this.my = my;
    }
    public boolean hasNext() {
        if(cursor < my.size())
            return true;

        return false;
    }

    public E next() {
        if (cursor < my.size()) {
            return (E) my.get(cursor++);
        }
            return null;
        }


    public void remove() {
        my.remove(cursor);
    }


}
