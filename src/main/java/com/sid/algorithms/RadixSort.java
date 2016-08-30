package com.sid.algorithms;

/**
 * Created by srathi on 8/23/16.
 */
class RadixSortApp {


    public static void main(String[] args) {
        int[] unsorted_Array = new int[100]{100,65,87,54,523,56,76};
        for (int n=0;n<unsorted_Array.length;n++)
        {
            System.out.print(unsorted_Array[n] + " ");
        }
        System.out.println("\n");
        //radix_sort(unsorted_Array);
        int base = 10;
        int temp = 1;
        DequeLinkList[] LinkList = new DequeLinkList[base];
        for (int i=0 ; i <base; i++)
            LinkList[i]= new DequeLinkList();
        for (int j = 0; j<3; j++) {

            for (int k = 0; k < unsorted_Array.length; k++) {
                temp = unsorted_Array[k];
                for (int l = 0; l < j; l ++ ) temp /= base;
                temp %= base;
                LinkList[temp].insertFirst(unsorted_Array[k]);
            }
            int array_counter = 0;
            //copy back to Array
            for (int m = 0; m<base; m++)
            {
                //LinkList[m].displayList();
                while (!LinkList[m].is_empty())
                {
                    unsorted_Array[array_counter] = LinkList[m].removeRight();
                    array_counter ++;
                }
            }

        }
        for (int n=0;n<unsorted_Array.length;n++)
        {
            System.out.print(unsorted_Array[n] + " ");
        }
    }
}