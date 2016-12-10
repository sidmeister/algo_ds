package dynamicProgramming;

/**
 * Created by srathi on 12/8/16.
 *
 * Given an array of positive integers.
 * Find the maximum sum of strictly increasing subarrays.
 * Note that this problem is different from maximum subarray sum and maximum sum increasing subsequence problems.

 Examples:

 Input  : arr[] = {1, 2, 3, 2, 5, 1, 7}
 Output : 8
 Explanation :  Some Strictly increasing subarrays are
 {1, 2, 3} sum = 6,
 {2, 5} sum = 7,
 {1, 7} sum 8
 Maximum Sum = 8

 Input : arr[] = {1, 2, 2, 4}
 Output: 6
 Explanation : Increasing subarray with maximum sum
 is 6.
 *
 */
public class MaxSumIncreasingSubArray {
    public static int mssincr(int[] arr, int start)
    {
        int current_sum = arr[start], max_sum = Integer.MIN_VALUE;
        for (int i = start+1;i < arr.length;i++) {
            if(arr[i] > arr[i -1]) {
                current_sum += arr[i];
            }
            else if(current_sum > max_sum)
            {
                max_sum = current_sum;
                current_sum = arr[i];
            }

        }
        return max_sum > current_sum ? max_sum : current_sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2,4};
        //System.out.println(arr.length);
        System.out.println(mssincr(arr,0));
    }
}
