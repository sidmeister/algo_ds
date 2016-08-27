package com.study.sid.tryGeneric;

/**
 * Created by srathi on 7/22/16.
 */
public class Node<T> {

    private T data;
    public Node next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public T getData() {
        return data;
    }
}
