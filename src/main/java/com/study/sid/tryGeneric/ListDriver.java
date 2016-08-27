package com.study.sid.tryGeneric;

/**
 * Created by srathi on 7/22/16.
 */
public class ListDriver {


    public static void main(String[] args) {
    List<String> glist =  new List<String>(10);
    glist.add("milk");
    glist.add("egg");
    System.out.println("grocery list" + glist.toString());

    List<Integer> numbers =  new List<Integer>(10);
    numbers.add(1);
    numbers.add(2);
    System.out.println("number list" + numbers.toString());


    }
}
