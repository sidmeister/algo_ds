/**
 * Created by srathi on 9/2/16.
 *
 * Given weights and values of n items, put these items in a knapsackDP of capacity W to get the maximum total value in the knapsackDP.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsackDP capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 *
 */
public class knapsackDP
{
    public static int maxValue(int[] value, int[] wt, int total_wt)
    {
        int[][] dp = new int[value.length+1][total_wt + 1];
        for (int i =0 ; i < value.length + 1; i++)
        {
            for (int j = 0; j <=total_wt; j++)
            {
                if ( i ==0 || j ==0) {
                    dp[i][j] = 0;
                    continue;
                }

                if(j - wt[i-1] >= 0)
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j - wt[i-1]]+value[i-1]);
                }
                else
                    dp[i][j]= dp[i-1][j];
            }
            //display(dp);
        }
        return dp[value.length][total_wt];
    }




    public static void display(int [][] dp)
    {
        System.out.print("\n");
        for (int i =0; i < dp.length; i++) {
            System.out.print("\n");
            for (int j=0; j< dp[0].length; j++)
                System.out.print(dp[i][j] + " ");
        }


    }

    public static void main(String[] args) {

        int value[] = new int[]{50, 40, 10, 30};
        int wt[] = new int[]{3, 4, 5, 6};
        int total_wt = 10;

        int i = maxValue(value,wt,total_wt);
        System.out.print("\n" + i);


    }

}
