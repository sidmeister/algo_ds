package dynamicProgramming;

/**
 * Created by srathi on 12/10/16.
 *
 * Minimum number of jumps to reach end
 Given an array of integers where each element represents the max number of steps that can be made forward from that element.
 Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
 If an element is 0, then cannot move through that element.

 Example:

 Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 Output: 3 (1-> 3 -> 8 ->9)
 First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.
 */
public class jumpsStep {



    static int minJumpsrec(int arr[], int l, int h)
    {
        // Base case: when source and destination are same
        if (h == l)
            return 0;

        // When nothing is reachable from the given source
        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        // Traverse through all the points reachable from arr[l]. Recursively
        // get the minimum number of jumps needed to reach arr[h] from these
        // reachable points.
        int min = Integer.MAX_VALUE;
        for (int i = l+1; i <= h && i <= l + arr[l]; i++)
        {
            int jumps = minJumpsrec(arr, i, h);
            if(jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }

        return min;
    }

    static int minJumpsdp(int arr[], int n)
    {
        int[] jumps = new int[n];  // jumps[n-1] will hold the result
        int i, j;

        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++)
        {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++)
            {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
                {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Minimum number of jumps to reach end is: " + minJumpsrec(arr, 0, arr.length));
        System.out.println("Minimum number of jumps to reach end is: " + minJumpsdp(arr, arr.length));

    }
}
