package recursion;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by srathi on 8/30/16.
 */
public class MaximumSubArray {

    /**
     * This is the brute force method. In this we compare each pair to find the mss.
     */
    public static int[] bruteforce(int[] arr)
    {
        int start=0 ,end =0, maxsum = Integer.MIN_VALUE, sum = 0;
        int[] mss = new int[arr.length];

        for (int i=0;i<arr.length;i++)
        {
            sum = 0;
            for (int j=i ; j<arr.length ;j++)
            {
                sum += arr[j];
                if (sum > maxsum) {
                    maxsum = sum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println(maxsum);
       System.arraycopy(arr, start, mss,0, end - start + 1);
        return mss;
    }


    /**
     * This is the divide and conquer method. In this we divide the problem.
     * into subproblem and solve the subproblem
     */

    // A utility funtion to find maximum of two integers
    public static int max(int a, int b) {
        return (a > b)? a : b; }

    // A utility funtion to find maximum of three integers
    public static int max(int a, int b, int c) { return max(max(a, b), c); }

    public static int dc(int[] arr, int low, int high)
    {
        int left_mss = 0 ;
        int right_mss = 0;
        int mid = (int) (low + high) / 2;
//        System.out.println("mid: " + mid);
//        System.out.println("low: " + low) ;
//        System.out.println("high: " + high);
        int leftmaxsum = Integer.MIN_VALUE, sum = 0 , rightmaxsum = Integer.MIN_VALUE;
        if ( new Integer(low).equals(high) ) {
//            System.out.println("Returning");
            return arr[0];
        }
        left_mss = dc(arr,low ,mid); //left mss
        right_mss = dc(arr , mid + 1, high); //right mss
        //calculate crossing sum
        //System.out.println("mid: " + mid);
        for (int i = mid ; i >=0 ; i--)
        {
            sum += arr[i];
           // System.out.println(sum);
            leftmaxsum = max(sum , leftmaxsum);
        }
        //System.out.println("left sum: " + leftmaxsum);
        sum = 0;
        for (int i = mid + 1  ; i <= high ; i++)
        {
            sum += arr[i];
            rightmaxsum = max(sum , rightmaxsum);
        }
        //System.out.println("right sum: " + rightmaxsum);

        //System.out.println(max(left_mss , right_mss, leftmaxsum + rightmaxsum ));
        return  max(left_mss , right_mss, leftmaxsum + rightmaxsum );
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = new int[]{13,-3,-25,20,3,-16,-23,18,20,-7,12,-5,-22,15,4,7};
        int mss [];
        int ans = 0;
        //mss = bruteforce(arr);
//        for (int k =0; k<mss.length; k++)
//            System.out.print(mss[k] + " ");
        ans = dc(arr,0,arr.length - 1);
        System.out.println(ans);
//        for (int k =0; k<mss.length; k++)
//            System.out.print(mss[k] + " ");
    }
}
