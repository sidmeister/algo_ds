package stack_queue;

/**
 * Created by srathi on 11/18/16.
 * priority queue implemented as an ordered array.
 *
 * Pro : removal is accomplished in fast O(1) time,
 * Con : insertion requires slow O(N) time, because an average of half the items in the array must be moved to insert the new one in order.
 *
 */

class PriorityQueue
{
    int nElems;
    int[] arr;

    public PriorityQueue(int size)
    {
        arr = new int[size];
        nElems = 0;

    }

    public boolean isEmpty() // true if queue is empty
    { return (nElems==0); }

    public void insert(int val)
    {
        int i;

        if (nElems == 0) {
            arr[nElems++] = val;

        }
        else {
            for (i= nElems -1; i >= 0; i--) {
                if (val > arr[i])
                {
                    arr[i+1] = arr[i];
                }
                else
                    break;
            }
            arr[i+1] = val;
            nElems ++;
        }
    }

    public void display()
    {
        for (int i = 0; i < nElems; i++)
            System.out.print(arr[i] + " " );
    }

    public int remove()
    {
        return arr[--nElems];
    }

    public int peek()
    {
        return arr[0];
    }

}

public class PriorityQueueApp {
    public static void main(String[] args) {

        PriorityQueue thePQ = new PriorityQueue(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        thePQ.display();
        System.out.print("\n");
        while( !thePQ.isEmpty() )
        {
            long item = thePQ.remove();
            System.out.print(item + " " ); // 10, 20, 30, 40, 50
        } // end while
        System.out.println("");
    } // end main()

}
