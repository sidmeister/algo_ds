package com.study.sid.datastructures;

/**
 * Created by srathi on 8/1/16.
 */

class ArraySel{

    private long[] a;
    private int numelem;

    public ArraySel(int numelem) {
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

    void selectionsort()
    {
        int min;
        long temp;
        for (int outer= 0; outer < numelem - 1; outer++)
        {
            min = outer;
            for (int inner = outer +1; inner < numelem; inner++)
            {
                if (a[min] > a[inner])
                    min = inner;
            }
                temp = a[min];
                a[min] = a[outer];
                a[outer] = temp;

        }

    }

}

public class  SelectionSort {


        public static void main(String[] args) {
            ArraySel arr = new ArraySel(10);
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
            arr.selectionsort();
            arr.display();


    }
}
