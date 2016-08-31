package com.study.sid.datastructures.stack;

/**
 * Created by Siddharth on 8/27/2016.
 */
public class StackApp {

    public static void main(String[] args) {
        Stack a  = new Stack(2);
        a.push(10);
        a.push(20);
        System.out.println(a.is_full());
        while (!a.is_empty())
        {
            int b = (int)a.pop();
            System.out.println(b);
        }

        Stack b  = new Stack(2);
        b.push('b');
        b.push('c');
        System.out.println(b.is_full());
        while (!b.is_empty())
        {
            char c = (char)b.pop();
            System.out.println(c);
        }

    }
}
