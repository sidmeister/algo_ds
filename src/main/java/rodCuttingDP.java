/**
 * Created by srathi on 8/30/16.
 */
public class rodCuttingDP {
    public static int[] arr = new int[]{0,1,5,8,9,10,17,17,20,24,30};

    //recursion
    public static int rec_cutrod(int[] price,  int length)
    {
        if(length == 0 )
            return 0;
        int max_price = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++ )
        {
          max_price =  max(max_price, arr[i] + rec_cutrod(arr, length -i));
        }
       // System.out.println(max_price);
        return max_price;
    }

    //memoization top down

    public static int memo_cutrod(int[] price, int[] r,  int length)
    {
        if(length < 0 )
            return 0;

        if(length == 0 )
            return 0;

        if (r[length] > 0)
            return r[length];

        int max_price = Integer.MIN_VALUE;

        for (int i = 1; i <= length; i++ )
        {
            max_price =  max(max_price, arr[i] + memo_cutrod(arr, r, length -i));
        }
        r[length] = max_price;
        return max_price;
    }

    public static int maxValue(int price[]){
        int max[] = new int[price.length+1];
        for(int i=1; i <= price.length; i++){
            for(int j=i; j <= price.length; j++){
                max[j] = Math.max(max[j], max[j-i] + price[i-1]);
            }
        }
        return max[price.length];
    }


    public static int max(int a, int b)
    {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        int price =   rec_cutrod(arr,9);
//        long endTimeMillis = System.currentTimeMillis();
//        System.out.println(endTimeMillis - startTimeMillis);
        System.out.println(price);
        int[] r = new int[arr.length];
        price =   memo_cutrod(arr,r,9);
//        System.out.println("memoization top down took:" + (endTimeMillis - startTimeMillis));
        System.out.println(price);
         price = maxValue(arr);
        System.out.println(price);

    }
}
