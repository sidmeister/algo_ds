/*
 * Created by srathi on 7/10/16.
 */


package com.advancedjava.assignment2;


/**
 * This is the class to simulate the dining philospher application
 */

public class DiningPhilospher {

    /**
     * This is the main application
     * @param args - arguments
     * @throws InterruptedException - exception
     */

    public static void main(String[] args) throws InterruptedException {

        Philospher[] philosphers = new Philospher[5];

        Fork[] fork = new Fork[5];  //As many forks as Philosophers
        for (int i = 0; i < 5; i++) {
            fork[i] = new Fork();
        }

        philosphers[0] = new Philospher(fork[4], fork[0], "0");
        philosphers[1] = new Philospher(fork[0], fork[1], "1");
        philosphers[2] = new Philospher(fork[1], fork[2], "2");
        philosphers[3] = new Philospher(fork[2], fork[3], "3");
        philosphers[4] = new Philospher(fork[3], fork[4], "4");
        Runnable r = philosphers[0];
        Thread t = new Thread(r);
        Runnable r1 = philosphers[1];
        Thread t1 = new Thread(r1);
        Runnable r2 = philosphers[2];
        Thread t2 = new Thread(r2);
        Runnable r3 = philosphers[3];
        Thread t3 = new Thread(r3);
        Runnable r4 = philosphers[4];
        Thread t4 = new Thread(r4);
        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(1000); // Main thread sleeps till time of simulation

        for (int i = 0; i < 5; i++) {
            System.out.println("philospher " + i + " ate " + philosphers[i].getnoOfTurnsToEat() + " time");
        }


    }

}
