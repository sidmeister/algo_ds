
/**
 * Created by srathi on 11/19/16.
 */

class HNode {

     public int data;
     public HNode leftChild; //leftchild
     public HNode rightChild; //rightChild
 }


public class Heap {

        private HNode[] heapArray;
        int nElems, maxSize;

        public Heap (int size)
        {
            heapArray = new HNode[size];
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
            HNode newNode = new HNode(); // make a new node
            newNode.data = key;
            heapArray[nElems] = newNode; // put it at the end
            trickleUp(nElems++); // trickle it up
            return true; // success
        }

    public boolean insertAt(int index, int key)
    {
        HNode newNode = new HNode(); // make a new node
        newNode.data = key;
        heapArray[index] = newNode; // put it at the end
        return true; // success
    }

    public void incrementsize()
    {
        nElems++;
    }


    /*
    heap operations all operate in O(logN) time.
    */


        public void trickleUp(int index)
        {

            HNode bottom = heapArray[index];
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

        public HNode remove()
        {
            HNode root = heapArray[0];
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

    /*
    heap operations all operate in O(logN) time.
    */

        public void trickleDown(int index)
        {
            int larger_child;
            HNode top = heapArray[index];
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

        public void displayHeapasArray()
        {
            System.out.print("heapArray: "); // array format
            for(int m=0; m<maxSize; m++)
                if(heapArray[m] != null)
                    System.out.print( heapArray[m].data + " ");
                else
                    System.out.print( "-- ");
            System.out.println();
        }

        public void displayHeap()
        {
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

         public static void main(String[] args) {

        }

}
