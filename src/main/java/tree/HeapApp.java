package tree;

/**
 * Created by srathi on 11/18/16.
 */

/*
representing a tree as an  array. For a node at index x in the array,
        parent is (x-1) / 2.
        Its left child is 2*x + 1.
        Its right child is 2*x + 2.
*/



class priorityQueue
{
    private Heap theHeap;

    int nElems;

    public priorityQueue(int size)
    {
        theHeap = new Heap(size);
        nElems = 0;

    }

    public boolean insert(int key)
    {
        return theHeap.insert(key);
    }
    public Node remove()
    {
        return theHeap.remove();
    }
    public void displayQueue()
    {
        theHeap.displayHeap();
    }

    public boolean changePriority(int index, int newvalue)
    {
       return theHeap.change(index, newvalue);
    }
}

public class HeapApp {

    public static void main(String[] args) {
        priorityQueue pq = new priorityQueue(20);
        boolean is_success;
        pq.insert(70); // insert 10 items
        pq.insert(40);
        pq.insert(50);
        pq.insert(20);
        pq.insert(60);
        pq.insert(100);
        pq.insert(80);
        pq.insert(30);
        pq.insert(10);
        pq.insert(90);
        pq.displayQueue();
        is_success = pq.insert(110);
        pq.displayQueue();
        pq.remove();
        pq.displayQueue();
        pq.changePriority(0,5);
        pq.displayQueue();
    }


}
