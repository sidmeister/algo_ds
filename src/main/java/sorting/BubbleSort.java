package sorting;

/**
 * Created by srathi on 8/1/16.
 */

class ArraySub{

    private long[] a;
    private int numelem;

    public ArraySub(int numelem) {
        a = new long[numelem];
        numelem = 0;
    }

    void insert(long i){
        a[numelem] = i;
        numelem ++;
    }

    public int length()
    {
        return numelem;
    }

    public void display()             // displays array contents
    {
        for(int j=0; j<numelem; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    void bubblesort()
    {
        long temp;
        for (int outer=numelem -1; outer > 1; outer--)
        {
            for (int inner =0; inner < outer; inner++)
            {
                if (a[inner] > a[inner+1])
                {
                    temp = a[inner];
                    a[inner] = a[inner + 1];
                    a[inner + 1] = temp;
                }
            }
        }

    }

}

public class BubbleSort {

    public static void main(String[] args) {
        ArraySub arr = new ArraySub(10);
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
        arr.bubblesort();
        arr.display();

    }

}
