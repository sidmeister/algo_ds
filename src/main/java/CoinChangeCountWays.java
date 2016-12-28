/**
 * Created by srathi on 12/27/16.
 * Coin Change)
 Given a value N, if we want to make change for N cents,
 and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 how many ways can we make the change? The order of coins doesn’t matter.

 For example, for N = 4 and S = {1,2,3}, there are four solutions:
 {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 For N = 10 and S = {2, 5, 3, 6},
 there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 So the output should be 5.
 */
public class CoinChangeCountWays {

    public static int calc_change(int[] coin_denom, int amount,int length)
    {
        if (amount == 0) //if amount  = 0 only 1 solution
            return 1;

        if (amount < 0) //if amount  = 0 only 1 solution
            return 0;

        if (length <= 0 && amount >= 0) // if no coins no solution
            return 0;

        int left_count = calc_change(coin_denom,amount - coin_denom[length -1],length); //left_Call;
        int right_count = calc_change(coin_denom,amount, length -1); //right_call;

        int count = left_count + right_count;

        return count;
    }

    public static void main(String[] args) {
        int amount = 20,cnt;
        int[] coin_denom = new int[]{10,5,3};
        cnt = calc_change(coin_denom,amount,coin_denom.length);
        System.out.print("\n");
        System.out.println(cnt);
    }
}
