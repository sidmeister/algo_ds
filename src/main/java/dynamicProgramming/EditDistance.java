package dynamicProgramming;

/**
 * Created by srathi on 12/3/16.
 * In computer science, edit distance is a way of quantifying how dissimilar
 * two strings (e.g., words) are to one another by counting the minimum number of operations
 * required to transform one string into the other.
 *There are three operations permitted on a word: replace, delete, insert.
 * For example, the edit distance between "a" and "b" is 1,
 * the edit distance between "abc" and "def" is 3
 */
public class EditDistance {

    public static int editDistDP(char[] str1, char[] str2)
    {
        int m = str1.length;
        int n = str2.length;
        // Create a table to store results of subproblems
        int[][] dp = new int[m+1][n+1];

        // Fill d[][] in bottom up manner
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // isnert all characters of second string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (str1[i-1] == str2[j-1])
                    dp[i][j] = dp[i-1][j-1];

                    // If last character are different, consider all
                    // possibilities and find minimum
                else {
                    int insert = dp[i][j - 1];  // Insert
                    int remove = dp[i - 1][j];  // Remove
                    int replace = dp[i - 1][j - 1]; // Replace
                    int min = Math.min(insert,remove);
                    min = Math.min(min,replace);
                    dp[i][j] = 1 + min;
                }
            }
        }




        System.out.println(dp[m][n]);
        return dp[m][n];

    }


    public static void main(String[] args) {

        String word1 = "sunday";
        String word2 = "saturday";
        editDistDP(word1.toCharArray(),word2.toCharArray());

    }
}
