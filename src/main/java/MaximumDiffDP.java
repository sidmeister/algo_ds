/**
 * Created by srathi on 12/9/16.
 * Maximum difference between two elements such that larger element appears after the smaller number
 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2).
 * If array is [ 7, 9, 5, 6, 3, 2 ]
 * then returned value should be 2 (Diff between 7 and 9)
 *
 * Can be reworded as  Best Time to Buy and Sell Stock
 *
 */
public class MaximumDiffDP {

    public static int maxdiff(int[] arr)
    {

        int min = arr[0];
        int max_diff = 0;


        for(int i=1; i<arr.length;i++) {
            if(arr[i] > arr[i-1]) {
                max_diff = Math.max(max_diff, arr[i] - arr[i - 1]);
                max_diff = Math.max(max_diff, arr[i] -min);
            }
            if(arr[i] < min)
                min = arr[i];
        }
        return max_diff ;
    }

    public static void main(String[] args) {

        //int[] arr = new int[]{2, 3, 10, 6, 4, 8, 1};
        int[] arr = new int[]{ 7, 9, 5, 6, 3, 2};
        System.out.println(maxdiff(arr));

    }
}
