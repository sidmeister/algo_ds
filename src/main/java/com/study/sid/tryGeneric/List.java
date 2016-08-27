package com.study.sid.tryGeneric;

import java.util.Arrays;

/**
 * Created by srathi on 7/22/16.
 */
public class List <T> {

    private T[] datastore;
    private int size;
    private int pos;


    public List(int numElements) {
        size = numElements;
        pos = 0;
        datastore = (T[]) new Object[size];
    }

    public void add(T element)
    {
        datastore[pos] = element;
        ++pos;
    }

    @Override
    public String toString() {
        return "List{" +
                "datastore=" + Arrays.toString(datastore) +
                '}';
    }
}
