package dynamicProgramming;

/**
 * Created by srathi on 9/1/16.
 * Objec­tive: Given a set of coins and amount,
 * Write an algo­rithm to find out how many ways we can make the change of the amount using the coins given.
 */
public class CoinChange {

    public static int calc_change(int[] coin_denom, int amount,int length)
    {

    }


    public static void main(String[] args) {
        int amount = 10,cnt;
        int[] coin_denom = new int[]{2,5,3,6};
        cnt = calc_change(coin_denom,amount,coin_denom.length);
        System.out.print("\n");
        System.out.println(cnt);
    }
}
