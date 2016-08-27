package com.study.sid;

import java.util.Random;

/**
 * Created by srathi on 7/28/16.
 */
public class RandInt {


    public static void main(String[] args) {
        Random rand = new Random();

        int  n = rand.nextInt(20 + 1) + 30;
        System.out.println(n);
    }


}
