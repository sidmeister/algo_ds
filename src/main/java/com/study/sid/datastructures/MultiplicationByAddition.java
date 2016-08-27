package com.study.sid.datastructures;

/**
 * Created by srathi on 8/23/16.
 */
public class MultiplicationByAddition {

    static double prod;

    public static double  multiply(double x, double y)
    {
        if (y == 1)
            return x;
        x = x + multiply(x, y -1);
        return x;
    }

    public static void main(String[] args) {
        double x = 2.5 ,y = 5;
        prod = multiply(x,y);
        System.out.println(prod);
    }
}
