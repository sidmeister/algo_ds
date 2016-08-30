package com.sid.algorithms;

/**
 * Created by srathi on 8/22/16.
 */
public class TowerofHanoi {

    static int num_of_disks = 4;

    public static void move_disks(int num_of_disks,char from,char inter,char to)
    {
        if (num_of_disks == 1)
        {
            System.out.println("disk 1 from " + from + " to " + to);
        }
        else
        {
            move_disks(num_of_disks -1,from, to,inter);
            System.out.println("disk " + num_of_disks + " from " + from + " to " + to );
            move_disks(num_of_disks -1, inter, from,to );
        }

    }

    public static void main(String[] args) {

        char from = 'A';
        char inter = 'B';
        char to = 'C';
        move_disks(num_of_disks,from,inter,to);
    }



}
