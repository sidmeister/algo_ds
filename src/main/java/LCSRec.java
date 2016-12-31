/**
 * Created by srathi on 11/30/16.
 * recursion.LCSDP Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 */
public class LCSRec {

    public static int LCS(String [] str1,String [] str2, int x, int y)
    {
       System.out.println("entering with x:" + x + " y:" + y );
       int lcs;
       if ( x == 0 || y == 0 )
           return 0;
        if (str1[x-1].equals(str2[y-1]))
            lcs = 1 + LCS(str1,str2,x-1,y-1);
        else
            lcs = Math.max(LCS(str1,str2,x-1,y),LCS(str1,str2,x,y-1));
        return lcs;

    }

    public static void main(String[] args) {
        String[] str1= new String[]{"A","B","C"};
        String[] str2 = new String[]{"A","E","C"};

        //String str1 = new String("ABCDGH");
        //String str2 = new String("AEDFHR");

        System.out.println(LCS(str1,str2, str1.length,str2.length));
    }
}
