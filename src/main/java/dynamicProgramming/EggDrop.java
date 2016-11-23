package dynamicProgramming;

/**
 * Created by srathi on 11/22/16.
 */
public class EggDrop {

    public static int minAttemps(int eggs, int floors)
    {
        int[][] dp = new int[eggs+1][floors+1];
        int new_min = 0;

        for (int i =0 ; i<= floors; i++)
        {
            dp[1][i] = i;
        }

        for (int e = 2; e<=eggs; e++)
        {
            for(int f = 1; f<=floors; f++)
            {
                dp[e][f] = Integer.MAX_VALUE;
                for (int a = 1; a<=f; a++) {
                    new_min = 1 + Math.max(dp[e-1][a-1],dp[e][f-a]);
                    if (new_min < dp[e][f]) {
                        dp[e][f] = new_min;
                    }
                }
            }
        }

        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        int eggs = 2;
        int floors = 100;
        System.out.println(minAttemps(eggs,floors));
    }
}
