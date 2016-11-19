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

class Heap
{

    private Node[] heapArray;
    int nElems, maxSize;

    public Heap (int size)
    {
        heapArray = new Node[size];
        nElems = 0;
        maxSize = size;
    }

    public boolean isEmpty()
    {
        return nElems == 0;
    }

    /*

    Node to be inserted is placed at the end of the array
    new node will usually need to be
    trickled upward until it’s below a
    node with a larger key and above a node with a smaller key

    */

    public boolean insert(int key)
    {
        if(nElems==maxSize) // if array is full,
            return false; // failure
        Node newNode = new Node(); // make a new node
        newNode.data = key;
        heapArray[nElems] = newNode; // put it at the end
        trickleUp(nElems++); // trickle it up
        return true; // success
    }

    private void trickleUp(int index)
    {

        Node bottom = heapArray[index];
        int parent =  (index-1) / 2;
        while (index > 0 && heapArray[parent].data < bottom.data)
        {
            heapArray[index] = heapArray[parent];

            index = parent;
            parent =  (parent-1) / 2;
        }
        heapArray[index] = bottom;

    }
/*
    steps for removing the maximum node:
    Remove the root.
    Move the last node into the root.
    Trickle the last node down until it’s below a larger node and above a smaller one

    */

    public Node remove()
    {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--nElems];
        trickleDown(0);
        return root;
    }

    public boolean change(int index, int newvalue)
    {
        if (index < 0 || index >= nElems)
            return false;

        int oldvalue = heapArray[index].data;
        heapArray[index].data = newvalue;
        if (oldvalue < newvalue)
            trickleUp(index);
        else
            trickleDown(index);

        return true;
    }

    private void trickleDown(int index)
    {
        int larger_child;
        Node top = heapArray[index];
        while (index < nElems/2) //not at the bottom row i.e one child exists
        {
            int left_child =  2*index + 1;
            int right_child = 2*index + 2;
            if (right_child < nElems && heapArray[left_child].data < heapArray[right_child].data)
                larger_child = right_child;
            else
                larger_child = left_child;

            if (top.data >= heapArray[larger_child].data)
                break;

            heapArray[index] = heapArray[larger_child];
            index = larger_child;
        }
        heapArray[index] = top;

    }

    public void displayHeap()
    {
        System.out.print("heapArray: "); // array format
        for(int m=0; m<nElems; m++)
            if(heapArray[m] != null)
                System.out.print( heapArray[m].data + " ");
            else
                System.out.print( "-- ");
        System.out.println();

// heap format
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0; // current item
        String dots = "...............................";
        System.out.println(dots+dots); // dotted top line
        while(nElems > 0) // for each heap item
        {
            if(column == 0) // first item in row?
                for(int k=0; k<nBlanks; k++) // preceding blanks
                    System.out.print(' ');
            // display item
            System.out.print(heapArray[j].data);
            if(++j == nElems) // done?
                break;
            if(++column==itemsPerRow) // end of row?
            {
                nBlanks /= 2; // half the blanks
                itemsPerRow *= 2; // twice the items
                column = 0; // start over on
                System.out.println(); // new row
            }
            else // next item on row
                for(int k=0; k<nBlanks*2-2; k++)
                    System.out.print(' '); // interim blanks
        } // end for
        System.out.println("\n"+dots+dots); // dotted bottom line
    } // end displayHeap()

}

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
