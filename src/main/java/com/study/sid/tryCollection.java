package com.study.sid;

import java.util.*;

/**
 * Created by srathi on 7/5/16.
 */
public class tryCollection {

    public static void main(String[] args) {

        // Create some collections to work with.
         Collection<String> c = new HashSet<>(); // An empty set

// We'll see these utility methods later Be aware that there are // some subtleties to watch out for when using them
     Collection<String> d = Arrays.asList("one", "two");
     Collection<String> e = Collections.singleton("three");
// Add elements to a collection. These methods return true // if the collection changes, which is useful with Sets that // don't allow duplicates.
        c.add("zero"); // Add a single element c.addAll(d); // Add all of the elements in d
// Copy a collection: most implementations have a copy constructor
        Collection<String> copy = new ArrayList<String>(c);

        c.remove("zero");// Remove a single element
        c.removeAll(e);// Remove a collection of elements
        c.retainAll(d);// Remove all elements that are not in e
        c.clear();// Remove all elements from the collection
    }


}
