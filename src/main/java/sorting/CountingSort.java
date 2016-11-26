package sorting;

/**
 * Created by srathi on 11/25/16.
 */
public class CountingSort {

    public static int[] countsort(int[] A,int n)
    {
        int k = 20;
        int[] count = new int[k];
        int[]B = new int[n];
        for (int i =0; i < k; i++)
            count[i] = 0;

        for (int i=0; i <n; i++)
            count[A[i]] = count[A[i]] + 1;



        for (int i =1; i < k ; i++)
            count[i] = count[i] + count[i-1];

        for (int i =0 ;i <n; i++)
        {
            B[count[A[i]] -1] = A[i];
            count[A[i]]= count[A[i]] -1;
        }

        return B;

    }


    public static void main(String[] args) {
        int[] arr = new int[7];
        arr[0] = 1;               // insert 10 items
        arr[1] = 4;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 7;
        arr[5] = 5;
        arr[6] = 2;
        for (int i =0 ;i < arr.length; i ++)
            System.out.print(arr[i] + " ");
        System.out.print("\n");
        arr = countsort(arr,arr.length);
        for (int i =0 ;i < arr.length; i ++)
            System.out.print(arr[i] + " ");

    }
}
