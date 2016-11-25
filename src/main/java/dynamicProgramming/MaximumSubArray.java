package dynamicProgramming;

/**
 * Created by srathi on 11/22/16.
 * Find the contiguous subarray within an array
 * (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubArray {

    public static int getMaximumSub(int[] arr)
    {
        int max = arr[0];
        int[] sum  = new int[arr.length + 1];
        sum[0]= arr[0];
        for (int i =1; i <arr.length; i++)
        {
            sum[i] = Math.max(sum[i-1] + arr[i], arr[i]);
            max = Math.max(max,sum[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{};
        getMaximumSub(arr);
    }
}
