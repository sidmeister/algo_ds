package com.study.sid.tryGeneric;

/**
 * Created by srathi on 7/22/16.
 */
public class LinkedList {

    public static void main(String[] args) {

        Node<String> node1= new Node("David");
        Node<String> node2= new Node("Raymond");
        Node<String> node3= new Node("Cynthia");
        Node<String> footer= new Node("Footer");
        node1.next = node2;
        node2.next = node3;
        node3.next = footer;
        footer.next = null;
        Node<String> dummy = node1;
        while (dummy.next!=null)
        {
            System.out.println(dummy.getData());
            dummy = dummy.next;
        }

    }


}
