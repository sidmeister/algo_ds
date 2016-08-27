package com.study.sid.datastructures;


/**
 * Created by srathi on 8/1/16.
 */

class ArrayIns{

    private long[] a;
    private int numelem;

    public ArrayIns(int numelem) {
        a = new long[numelem];
        numelem = 0;
    }

    void insert(long i){
        a[numelem] = i;
        numelem ++;
    }

    public void display()             // displays array contents
    {
        for(int j=0; j<numelem; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    void insertionsort()
    {
        long temp;
        int inner,outer;
        for (outer=1; outer < numelem; outer++)
        {
            temp = a[outer];
            System.out.println(temp);
            inner = outer;
            while (inner > 0 && temp <= a[inner-1] ) {
                a[inner] = a[inner - 1];
                inner--;
            }
            a[inner] = temp;

            }

        }

    }


public class InsertionSort {

    public static void main(String[] args) {
        ArrayIns arr = new ArrayIns(10);
        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();                // display items
        arr.insertionsort();
        arr.display();

    }

}
