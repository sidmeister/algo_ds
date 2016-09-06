package dynamicProgramming;

/**
 * Created by srathi on 9/1/16.
 */
public class CoinChange {

    public static int calc_change(int[] coin_denom, int amount,int length)
    {
        if (amount == 0) //if amount  = 0 only 1 solution
            return 1;

        if (amount < 0) //if amount  = 0 only 1 solution
            return 0;

        if (length <= 0 && amount >= 0) // if no coins no solution
            return 0;

        System.out.println();
        int left_count = calc_change(coin_denom,amount - coin_denom[length -1],length); //left_Call;
        int right_count = calc_change(coin_denom,amount, length -1); //right_call;

        int count = left_count + right_count;

        return count;
    }

    public static int dp_calc_change(int[] coin_denom, int amount,int length)
    {
        if (amount == 0) //if amount  = 0 only 1 solution
            return 1;

        if (amount < 0) //if amount  = 0 only 1 solution
            return 0;

        if (length <= 0 && amount >= 0) // if no coins no solution
            return 0;



        int count = calc_change(coin_denom,amount - coin_denom[length -1],length) +
                calc_change(coin_denom,amount, length -1);




        return count;
    }

    public static void main(String[] args) {
        int amount = 10,cnt;
        int[] coin_denom = new int[]{2,5,3,6};
        cnt = calc_change(coin_denom,amount,coin_denom.length);
        System.out.print("\n");
        System.out.println(cnt);
    }
}
