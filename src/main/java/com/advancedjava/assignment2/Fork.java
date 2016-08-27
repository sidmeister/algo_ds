/**
 * Created by srathi on 7/10/16.
 */
package com.advancedjava.assignment2;


import java.util.concurrent.locks.ReentrantLock;

/**
 * This is the Fork resource class which is provides the locking for the critical section
 *
 */

public class Fork {

    ReentrantLock getForkLock;


    /**
     * Constructor
     *
     */

    public Fork() {

        getForkLock = new ReentrantLock();
    }

    /**
     * This is the method which the philospher calls to pick up the fork.
     * Here it tries to lock the resource so that other threads don't
     * acquire the same resource
     * @return boolean - true if lock acquired
     */

    public boolean pickupFork() {
        System.out.println(Thread.currentThread() + " is tyring to acquire a lock");
        return getForkLock.tryLock(); //acquire the lock
    }

    /**
     * This is the method which the philospher calls to put down the fork.
     * Here it tries to unlock the resource for  other threads to
     * acquire. Before releasing it makes sure it has unlocked it
     */

    public void putDownFork() {
        System.out.println(Thread.currentThread() + " is tyring to release a lock");
        //not sure but if I don't add the below if I get the  java.lang.IllegalMonitorStateException
        if (getForkLock.isHeldByCurrentThread()) {
            getForkLock.unlock(); //release the lock
        }
    }

}
