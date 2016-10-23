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
        int left_start=0 ,left_end =0, maxsum = Integer.MIN_VALUE, sum = 0;
        int right_start=0, right_end =0;
        int start =0, end = 0;
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
        int left_start=0 ,left_end =0;
        int right_start=0, right_end =0;
        int start = 0 , end = 0, ans = 0;
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
        for (int i = mid ; i >=0 ; i--) {
            sum += arr[i];
            // System.out.println(sum);
            //leftmaxsum = max(sum , leftmaxsum);
            if (sum > leftmaxsum) {
                leftmaxsum = sum;
                left_end = i;
                left_start = left_end;
            }
        }
//            System.out.println("start:" + left_start);
//            System.out.println("end:" + left_end);
        sum = 0;
        for (int i = mid + 1  ; i <= high ; i++)
        {
            sum += arr[i];
            //rightmaxsum = max(sum , rightmaxsum);
            if (sum > rightmaxsum) {
                rightmaxsum = sum;
                right_start = i;
                right_end = right_start;
            }
        }

//        System.out.println("start:" + right_start);
//        System.out.println("end:" + right_end);
        //System.out.println("right sum: " + rightmaxsum);

        if (left_mss > right_mss)
        {
            start = left_start;
            end = left_end;
            ans = left_mss;
        }
        else
        {
            start = right_start;
            end = right_end;
            ans = right_mss;
        }


        if ((leftmaxsum + rightmaxsum) > ans)
        {
            start = left_start;
            end = right_end;
        }

        System.out.println("start:" + start);
        System.out.println("end:" + end);

        //System.out.println(max(left_mss , right_mss, leftmaxsum + rightmaxsum ));
        return  max(left_mss , right_mss, leftmaxsum + rightmaxsum );
    }


    /**
     * This is the kadane version
     */

    public static int[] kadane(int[] arr, int size)
    {
        int maxsum = Integer.MIN_VALUE, current_sum = 0;
        int[] mss = new int[arr.length];
        int start_index= 0,end_index=0;
        for (int i = 0; i < arr.length; i++)
        {
            if (new Integer(0).equals(current_sum)) start_index = i;
            current_sum += arr[i];
                if (current_sum > maxsum)
                {
                    maxsum = current_sum;
                    end_index = i;
                }
                if (current_sum < 0) {
                    current_sum = 0;
                }
        }
        System.arraycopy(arr, start_index, mss,0, end_index - start_index + 1);
        return mss;
    }


    public static void main(String[] args) {
        //int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = new int[]{13,-3,-25,20,3,-16,-23,18,20,-7,12,-5,-22,15,4,7};
        int mss [];
        mss = bruteforce(arr);
        for (int k =0; k<mss.length; k++)
            System.out.print(mss[k] + " ");
        System.out.print("\n");
        int ans = 0;
        ans = dc(arr,0,arr.length - 1);
        System.out.println(ans);
        int sum = 0;
        mss = kadane(arr , arr.length);
        for (int k =0; k<mss.length; k++)
            System.out.print(mss[k] + " ");

    }
}
