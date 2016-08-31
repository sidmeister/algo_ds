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
       System.arraycopy(arr, start, mss,0, end - start + 1);
        return mss;
    }

    /**
     * This is the divide and conquer method. In this we divide the problem.
     * into subproblem and solve the subproblem
     */

    public static int[] dc(int[] arr, int low, int high)
    {
        int mid = (int) (high - low) / 2;
        int maxsum = Integer.MIN_VALUE, sum = 0;
        System.out.println("low:" + low);
        System.out.println("high: " + high);
        //System.out.println(mid);
        if (new Integer(1).equals((int) (high - low ))) {
            System.out.println("high - low = 1");
            return arr;
        }
        arr = dc(arr,low ,mid); //left mss
            for (int i = high; i > low; i--) {
                sum += arr[i];
                if (sum > maxsum) sum = maxsum;
            }

        //arr = dc(arr,mid+1,high); //right mss
        return  arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13,-3,-25,20,3,-16,-23,18,20,-7,12,-5,-22,15,4,7};
        int mss [];
        mss = bruteforce(arr);
//        for (int k =0; k<mss.length; k++)
//            System.out.print(mss[k] + " ");
        mss = dc(arr,0,arr.length);
        for (int k =0; k<mss.length; k++)
            System.out.print(mss[k] + " ");
    }
}
