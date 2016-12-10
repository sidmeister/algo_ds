package dynamicProgramming;

/**
 * Created by srathi on 12/6/16.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 *
 *
 */
public class MaxProdSubArray {

    public static int maxprod(int[] array)
    {
        int[] max = new int[array.length];
        int[] min = new int[array.length];
        max[0] = array[0];
        min[0] = array[0];
        int maxprod = array[0];
        for(int i =1; i<array.length; i++)
        {
            if(array[i] > 0)
            {
                max[i] = Math.max(array[i],max[i-1] * array[i]);
                min[i] = Math.min(array[i],min[i-1] * array[i]);
            }
            else
            {
                max[i] = Math.max(array[i],min[i-1] * array[i]);
                min[i] = Math.min(array[i],max[i-1] * array[i]);

            }
            maxprod = Math.max(maxprod,max[i]);

        }

        return maxprod;
    }

    public static void main(String[] args) {

        int[] array = new int[]{-1,3,-5,8};
        System.out.println(maxprod(array));

    }
}
