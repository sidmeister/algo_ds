/**
 * Created by srathi on 12/3/16.
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 * For example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB”
 * is the longest palindromic subseuqnce in it.
 * “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence,
 * but not the longest ones.
 */
public class LongestPalindromeSubSequenceRecursion {


    public static int lpss(char[] input, int start,int end)
    {
        int l = 0;

        if (start + 1 == end && input[start] == input[end]  )
            return 2;

        if ( start == end)
            return 1;

        char first = input[start];
        char last = input[end];

        if (first == last)
           l = 2 + lpss(input,start+1,end-1);
        else
            l = Math.max(lpss(input,start +1,end),lpss(input,start,end-1));
        return l;
    }

    public static void main(String[] args) {
        //geeksskeeg
        String input = "forgeeksskeegfor";
        char[] str = input.toCharArray();
        System.out.println(lpss(str,0,str.length-1));
    }
}
