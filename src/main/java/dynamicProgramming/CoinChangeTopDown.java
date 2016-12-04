package dynamicProgramming;

/**
 * Created by srathi on 12/3/16.
 */
public class CoinChangeTopDown {

    public static int minCoin(int sum,int[] coin, int[]s)
    {
        if (sum <= 0)
            return 0;

        if (s[sum] > 0)
         return s[sum];

        int min = Integer.MAX_VALUE;
            for(int i =0; i < coin.length;i++)
            {
               if(coin[i] > sum)
                   continue;

               int val = minCoin(sum-coin[i],coin,s);

                if (val < min)
                    min = val;
            }

        min = (min == Integer.MAX_VALUE ? min : min + 1);
        s[sum] = min;
        return min;
    }

    public static void main(String[] args) {
        //int amount = 10,cnt;
        //int[] coin_denom = new int[]{2,5,3,6};
        int sum = 6;
        int[] coin = new int[]{2,3,6,7};
        int[] s = new int[sum + 1];
        s[0] = 0;
        System.out.println(minCoin(sum,coin,s));
    }
}
