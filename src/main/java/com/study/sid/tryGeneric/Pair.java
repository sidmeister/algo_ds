package com.study.sid.tryGeneric;

/**
 * Created by srathi on 7/22/16.
 */
public class Pair<T1,T2> {

    private T1 firstItem;
    private T2 secondItem;


    public Pair(T1 firstItem, T2 secondItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
    }

    public T1 getFirstItem() {
        return firstItem;
    }

    public T2 getSecondItem() {
        return secondItem;
    }
}
