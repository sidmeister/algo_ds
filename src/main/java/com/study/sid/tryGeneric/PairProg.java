package com.study.sid.tryGeneric;

/**
 * Created by srathi on 7/22/16.
 */
public class PairProg {

    public static void main(String[] args) {
        Pair<String,Integer> grade1 = new Pair<String, Integer>("williams",90);
        Pair<String,Integer> grade2 = new Pair<String, Integer>("brown",40);
        System.out.println(grade1.getFirstItem());
        System.out.println(grade1.getSecondItem());

    }
}
