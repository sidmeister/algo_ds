package dynamicProgramming;

import sun.nio.cs.ext.MacHebrew;

/**
 * Created by srathi on 9/1/16.
 * Objec­tive: Given a amount ‘A’ and n coins,   v1<v2<v3<.….……<vn .
 * Write a pro­gram to find out minimum numbers of coins required to make the change for the amount ‘A’.
 */
public class MinCoin {

    //recursion

    public static int rec_count(int sum,int [] coin, int size)
    {
        if (size <= 0 && sum >= 1 )
            return 0;

        if (sum < 0) return 0;

        if ( sum == 0 )
            return 1;
        //1 include the coin
        //2 exclude the coin

        return rec_count(sum - coin[size -1], coin, size) + rec_count(sum, coin,size -1);

    }



    public static void dp_count(int sum,int [] coin, int size)
    {
        /*
         We will create an array with the columns as the possible states
         and rows as the coin denominations
         */

        int[] table = new int[sum + 1];
        int[] R = new int[sum + 1];
        /*
            let us initialize the column 0 (state 0)
         */

        table[0] = 0;

        for (int i = 1; i <= sum ; i++) {
                table[i] = Integer.MAX_VALUE;
                R[i] = -1;
        }

        for (int j = 0; j < size; j ++)
        {
          //  System.out.print("\n");
            for (int i = 1; i < sum + 1 ; i++)
            {
                if (i >= coin[j])
                {
                    if ((table[i - coin[j]] + 1) < table[i])
                         {
                        table[i] = table[i - coin[j]] + 1;
                             R[i] = j;
                        }
                    }

            }
        }
        System.out.print("\n");

        for (int i = 1; i < sum + 1; i++) {
                System.out.print(R[i] + " ");
        }

        printCoinCombination(R, coin);
    }


    private static void  printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("\n");
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int sum = 30;
        int[] coin = new int[]{5,10,25};
        dp_count(sum,coin,coin.length);
    }
}
