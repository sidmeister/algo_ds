package sorting;

import tree.Heap.Heap;
import tree.Node;

/**
 * Created by srathi on 11/19/16.
 */
public class HeapSort {

    public static void main(String[] args) {
        int size = 10;
        Heap heap = new Heap(size);
        for (int i = 0; i < size; i++) {
            int random = (int) (java.lang.Math.random() * 100);
            heap.insertAt(i,random);
            heap.incrementsize();
        }
        System.out.print("Unsorted:");
        heap.displayHeapasArray(); //display
        heap.displayHeap();


        for (int j = (size -1)/2 ; j >= 0 ; j--)
            heap.trickleDown(j);

        System.out.print("Heapify:");
        heap.displayHeapasArray(); //display

        for (int j = size -1; j >=0; j--)
        {
            Node biggest = heap.remove();
            heap.insertAt(j,biggest.data);
        }

        System.out.print("Sorted:");
        heap.displayHeapasArray(); //display
    }
}
