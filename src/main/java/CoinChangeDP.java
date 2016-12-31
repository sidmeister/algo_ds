/**
 * Created by srathi on 9/1/16.
 * Objec­tive: Given a set of coins and amount,
 * Write an algo­rithm to find out how many ways we can make the change of the amount using the coins given.
 */
public class CoinChangeDP {

    public static int calc_change(int[] coin_denom, int amount,int length)
    {
        int x,y;
        int[][] dp= new int[amount + 1][length];
        //for amount 0 - base case only 1 way
        for(int i=0; i<dp[0].length;i++)
            dp[0][i]=1;

        for(int i = 1; i<amount+1;i++) //amount
        {
            for(int j=0;j<length;j++) //coin
            {
                //include the coin
                x = (i -coin_denom[j] >= 0) ? dp[i-coin_denom[j]][j] : 0;
                //exclude the coin
                y = (j>=1) ? dp[i][j-1]: 0;
                //left + right;
                dp[i][j] = x+y;

            }

        }
        return dp[amount][length-1];
    }


    public static void main(String[] args) {
        int amount = 10,cnt;
        int[] coin_denom = new int[]{2,5,3,6};
        cnt = calc_change(coin_denom,amount,coin_denom.length);
        System.out.print("\n");
        System.out.println(cnt);
    }
}
