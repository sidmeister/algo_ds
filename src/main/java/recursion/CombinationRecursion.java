package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srathi on 8/23/16.
 */
public class CombinationRecursion {

    public static void pickComb(int n, int k, String seq,char letter, int evalsize)
    {
       // System.out.println(seq);
        if (n <= 0 || k <= 0 || k > n ) {
            return;
        }
        seq += Character.toString(letter);
        letter++;
        pickComb( n - 1, k -1,seq,letter,evalsize); //left call
        seq = seq.substring(0,seq.length() - 1);

        if (seq.length() == evalsize)
            System.out.println(seq + "," + (char)(letter -1));
        pickComb( n - 1, k,seq,letter,evalsize); //right call
    }

    public static void main(String[] args) {

        int n = 3, k = 2;
        String seq = "";
        pickComb(n, k, seq, 'a', k-1);


    }
}
