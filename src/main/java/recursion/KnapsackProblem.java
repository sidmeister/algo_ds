package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srathi on 8/22/16.
 */
public class KnapsackProblem {

    static List<Integer> tgt_list  =  new ArrayList<Integer>();;
    static  int[] given_weights = new int[] {11,8,7,6,5};
    public static boolean  knapsack(int tgt_weight, int index)
    {
        boolean complete = false;
        if (index == given_weights.length) return false;

        int curr_wt = given_weights[index];
        if (curr_wt == tgt_weight)
        {
            System.out.print("Answer : " + given_weights[index] + " ");
            complete = true;
        }
        else if (curr_wt < tgt_weight)
        {
            System.out.println("tgt : " + tgt_weight + "," + "curr: " + given_weights[index] + " is too small");
            complete = knapsack(tgt_weight - curr_wt, index + 1);
            if (complete) System.out.println(curr_wt + " ");
            for (int i = index + 1; i < given_weights.length; i ++)
            {
                if (! complete)
                complete = knapsack(tgt_weight, i);
            }
        }
        else  complete = knapsack(tgt_weight, index +1);
        return complete;
    }


    public static void main(String[] args) {
        int tgt_weight = 20;
        knapsack(tgt_weight,0);
    }
}
