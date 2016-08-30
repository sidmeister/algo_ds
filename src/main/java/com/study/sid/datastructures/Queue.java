package com.study.sid.datastructures;

/**
 * Created by srathi on 8/9/16.
 */
public class Queue {
    private int numElems,front =0,rear=-1,size;
    private int[] arr;

    public Queue(int numElems) {
        this.numElems = 0;
        arr = new int[numElems];
        size = numElems;
    }

    public void insert(int elem)
    {
        arr[++rear] = elem;
        numElems ++;
    }

    public int remove ()
    {
        numElems --;
        return arr[front++];

    }

    public int peek()
    {
        return arr[front];
    }

    public boolean is_empty()
    {
        return (numElems ==0);
    }

    public boolean is_full()
    {
        return (numElems == size);
    }

    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.insert(0);
        q.insert(1);
        q.insert(4);
        q.remove();
        while( !q.is_empty() )
        {
            int n = q.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
    }  // end main()


}
