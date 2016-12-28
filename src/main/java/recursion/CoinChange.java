package recursion;

/**
 * Created by srathi on 12/25/16.
 */
public class CoinChange {

    public static int minCoin(int sum,int[] coin)
    {
        if (sum <= 0)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int i =0; i < coin.length;i++)
        {
            if(coin[i] > sum)
                continue;

            int val = minCoin(sum-coin[i],coin);

            if (val < min)
                min = val;
        }

        min = (min == Integer.MAX_VALUE ? min : min + 1);
        return min;
    }

    public static void main(String[] args) {
        //int amount = 10,cnt;
        //int[] coin_denom = new int[]{2,5,3,6};
        int sum = 20;
        int[] coin = new int[]{3,5,10};
        System.out.println(minCoin(sum,coin));
    }
}

