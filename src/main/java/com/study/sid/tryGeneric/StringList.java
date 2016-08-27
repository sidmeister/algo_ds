package com.study.sid.tryGeneric;

/**
 * Created by srathi on 7/22/16.
 */
public class StringList<T> implements IList<T> {

    private T[] datastore;
    private int size;
    private int pos;


    @Override
    public void add(T element) {
        datastore[pos] = element;
        ++pos;

    }

    @Override
    public T get(int n) {
        return datastore[n];
    }
}
