package Graph;

import java.util.Arrays;

/**
 * Created by srathi on 11/24/16.
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:
 */
public class Combinations {

     static void combine(int[] input, int evalsize, int start, int[] branch, int numElem)
     {
         if(numElem == evalsize)
         {
             System.out.println(Arrays.toString(branch));
             return;
         }

         for (int i = start; i < input.length; i ++)
         {
             branch[numElem++] = input[i];
             combine(input,evalsize,++start,branch,numElem);
             --numElem;
         }
     }

    public static void main(String[] args) {
        int k = 2;
        int n = 4;
        int[] input = new int[n];
        for (int i =0 ; i < 4; i++)
           input[i] = i+1;
        int[] branch = new int[k];
        combine(input, k, 0, branch, 0);
    }
}
