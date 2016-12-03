package dynamicProgramming;

/**
 * Created by srathi on 11/30/16.
 * recursion.LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 */
public class LCS {

    public static int LCS(String [] str1,String [] str2, int x, int y)
    {
       int lcs;


       int[][] lcsdp = new int[x+1][y+1];
        for(int i = 0; i < str1.length; i++)
        {
            for (int j=0; j<str2.length; j++)
            {
                if ( x == 0 || y == 0 )
                    lcsdp[x][y] = 0;
                else if (str1[x-1].equals(str2[y-1]))
                    lcsdp[x][y] = 1 + LCS(str1,str2,x-1,y-1);
                else lcsdp[x][y] = Math.max(LCS(str1,str2,x-1,y),LCS(str1,str2,x,y-1));
            }
        }

        return lcsdp[x][y];

    }

    public static void main(String[] args) {
        String[] str1= new String[]{"A","B","C"};
        String[] str2 = new String[]{"A","E","C"};

        //String str1 = new String("ABCDGH");
        //String str2 = new String("AEDFHR");

        System.out.println(LCS(str1,str2, str1.length,str2.length));
    }
}
