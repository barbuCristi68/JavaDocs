package exercise4;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {

        // TODO Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>(BUCKET_ARRAY_SIZE);
        for(int i =0 ; i < 16 ; i++)
        {
            buckets.add(new LinkedList<MyEntry>());
        }
    }

    public int hash(String key){
        int result = 0;
        if(key != null)
            result = Math.abs(key.hashCode()) % 16;
        return result;
    }
    public String get(String key) {
        // TODO

        int index = hash(key);
        LinkedList<MyEntry> entryList = buckets.get(index);
        for(MyEntry entry: entryList)
            if(entry.getKey().equals(key))
                return entry.getValue();
        return null;
    }

    public void put(String key, String value) {
        // TODO
        int index = hash(key);
        boolean ok = false;
        LinkedList<MyEntry> entryList = buckets.get(index);
        for(MyEntry entry: entryList)
            if(entry.getKey().equals(key))
            {
                ok = true;
                entry.setValue(value);
            }else
                entryList.add(new MyEntry(key,value));
    }

    public Set<String> keySet() {
        // TODO
        Set<String> keys = new HashSet<String>();
        for(LinkedList<MyEntry> bucket:buckets) {
            for (MyEntry entry : bucket)
                keys.add(entry.getKey());

        }
        if (keys.size() > 0)
            return keys;
        return null;
    }

    public Collection<String> values() {
        // TODO

        Set<String> keys = new HashSet<String>();
        for(LinkedList<MyEntry> bucket:buckets) {
            for (MyEntry entry : bucket)
                keys.add(entry.getValue());

        }
        if (keys.size() > 0)
            return keys;
        return null;    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found

        int index = hash(key);
        LinkedList<MyEntry> entryList = buckets.get(index);
        for(MyEntry entry: entryList)
            if(entry.getKey().equals(key)) {
                entryList.remove(entry);
                return entry.getValue();
            }

        return null;
    }

    public boolean containsKey(String key) {
        // TODO

        int index = hash(key);
        LinkedList<MyEntry> entryList = buckets.get(index);
        for(MyEntry entry: entryList)
            if(entry.getKey().equals(key))
                return true;

        return false;
    }

    public boolean containsValue(String value) {
        // TODO
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry entry : bucket)
                if (entry.getValue().equals(value))
                    return true;
        }
        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        int count = 0;
        for (LinkedList<MyEntry> bucket : buckets) {
                    count+=bucket.size();
        }
        return count;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        return null;
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
