package dynamicProgramming;

import sun.nio.cs.ext.MacHebrew;

/**
 * Created by srathi on 9/1/16.
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



    public static int dp_count(int sum,int [] coin, int size)
    {
        /*
         We will create an array with the columns as the possible states
         and rows as the coin denominations
         */

        int[][] table = new int[size][sum + 1];

        /*
            let us initialize the column 0 (state 0)
         */



        for (int i =0; i < size ; i++)
            table[i][0] = 0;

        for (int j =0; j < size ; j++) {
            for (int i = 1; i <= sum ; i++) {
                table[j][i] = Integer.MAX_VALUE;
            }
        }


        int[] R = new int[sum + 1];
        for (int j = 0; j < size; j ++)
        {
          //  System.out.print("\n");
            for (int i = 1; i < sum + 1 ; i++)
            {
                if (i >= coin[j])
                {
                    if (j == 0)
                        table[j][i] = Math.min(table[j][i], table[j][i - coin[j]] + 1);
                    else {
                        table[j][i] = Math.min(table[j - 1][i], table[j][i - coin[j]] + 1);
                        if (table[j][i] == table[j][i - coin[j]] + 1) {
                            R[j] = coin[j];
                        }
                    }

                }
                else {
                    if (j == 0) {
                        table[j][i] = Integer.MAX_VALUE;
                    }
                    else
                    {
                        table[j][i] = table[j - 1][i];
                    }
                }
            //    System.out.print(table[j][i] + " ");

            }
        }
        System.out.print("\n");

        for (int j = 0; j < size; j++) {
            for (int i = 1; i < sum + 1; i++) {
                System.out.print(table[j][i] + " ");
            }
            System.out.print("\n");
        }

        return 0;

    }



    public static void main(String[] args) {
        int sum = 30;
        int[] coin = new int[]{5,10,25};
        int count = dp_count(sum,coin,coin.length);
        //System.out.println(count);
    }
}
