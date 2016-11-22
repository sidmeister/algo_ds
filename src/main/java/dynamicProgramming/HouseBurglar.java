package dynamicProgramming;

/**
 * Created by srathi on 11/22/16.
 *
 *  Problem: There are n houses built in a line, each of which contains some value in it.
 *  A thief is going to steal the maximal value in these houses, but he cannot steal in two adjacent houses
 *  because the owner of a stolen house will tell his two neighbors on the left and right side. What is the maximal stolen value?

 For example, if there are four houses with values {6, 1, 2, 7}, the maximal stolen value is 13 when the first and fourth houses are stolen
 *
 */
public class HouseBurglar {

    public static int findMaxStealValue(int[] value)
    {
        if (value.length == 0  || value == null)
            return 0;

        int[] dp = new int[value.length+1];
        dp[0] = 0;
        dp[1] = value[0];

        for (int i = 2; i <= value.length; i++)
        {
            dp[i] = Math.max(dp[i-1],value[i-1] + dp[i-2]);
        }

//        for(int i = 0; i < dp.length; i++)
//        {
//            System.out.print(dp[i] + " ");
//        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] value = new int[]{6, 1, 2, 7};
        int maxStealValue = findMaxStealValue(value);
        System.out.println(maxStealValue);

    }

}
