package dynamicProgramming;

/**
 * Created by srathi on 12/3/16.
 * Given a string, find the longest substring which is palindrome.
 * For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
 */
public class LongestPalindromeSubStringBottomUp {

    public static void lcs(char[] input)
    {
        int n = input.length;
        int start = 0;
        int maxlen = Integer.MIN_VALUE;
        boolean[][] dp = new boolean[n][n];
        for(int i =0;i <n;i++) {
            dp[i][i] = true;
        }
        for(int i =0;i <n-1;i++) {
            if (input[i] == input[i + 1]) {
                dp[i][i + 1] = true;
            }
            start =1;
            maxlen = 2;
        }

        int j;

        for(int len =3; len<=n;len++)
        {
            for (int i=0; i<n-len+1;i++)
            {
              j=i+len-1;
              if(input[i] == input[j] && dp[i+1][j-1] == true)
              {
                  dp[i][j] = true;
                  if(len > maxlen) {
                      maxlen = len;
                      start =i;
                  }
              }
            }
        }

        for( int i = start; i < start+maxlen; ++i )
            System.out.print(input[i]);





    }

    public static void main(String[] args) {
        char[] input = "forgeeksskeegfor".toCharArray();
        lcs(input);
}
}
