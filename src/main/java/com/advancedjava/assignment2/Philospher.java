/**
 * Created by srathi on 7/10/16.
 */
package com.advancedjava.assignment2;

/**
 * This is the Philospher class which is run in  multi threaded
 *
 */

public class Philospher implements Runnable {

    Fork leftFork;
    Fork rightFork;
    String position;
    private int noOfTurnsToEat = 0;
    /**
     *Constructor. Each philospher is intitalized with a left fork and a right fork that the philospher is going to use
     *@param  left - Fork
     *@param  right - Fork
     *@param position - String
     */

    public Philospher(Fork left, Fork right, String position) {
        this.leftFork = left;
        this.rightFork = right;
        this.position = position;

    }

    @Override
    public void run() {
        think(); //simulate thinking
        eat();
    };

    /**
     * * This is the getter that returns how many times each philospher has eaten
     * @return noOfTurnsToEat - int
     */

    public int getnoOfTurnsToEat() {
        return noOfTurnsToEat;
    }

    /**
     * * This is the eat method
     *
     */

    private void eat() {
        if (pickupForks()) {
            System.out.println("philospher " + position + "is eating");
        }
        //eating done release the forks
        leftFork.putDownFork();
        System.out.println("philospher " + position +  " released left fork");
        rightFork.putDownFork();
        System.out.println("philospher " + position +  " released right fork");
        //increment the eat counter
        noOfTurnsToEat++;

    }

    /**
     * * This is the method to pickupForks which the philospher calls before eating
     *
     *
     */

    private boolean pickupForks() {
        System.out.println("philospher " + position +  " is hungry and wants to eat");
        if (!leftFork.pickupFork()) {   //philospher first tries to pick up left fork
            return false;
        }

        System.out.println("philospher " + position +  " got left fork");

        if (!rightFork.pickupFork()) {
            //philospher then tried to pick up right fork - if it cannot pick up it will release the left fork to avoid deadlock
            System.out.println("philospher " + position +  " did not get right fork");
            leftFork.putDownFork();
            return false;
        }

        System.out.println("philospher " + position +  " got right fork");

        return true; //reached here means left and right fork are acquired
    }


    private void think() {
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
