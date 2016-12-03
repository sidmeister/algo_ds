package recursion;

import java.util.ArrayList;

/**
 * Created by srathi on 11/28/16.
 */
public class PowerSet {

            public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set,int index) {
            ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();;
            if (set.size() == index) { // Base case - add empty set
                //allsubsets = new ArrayList<ArrayList<Integer>>();
                allsubsets.add(new ArrayList<Integer>()); // Empty set
            }
            else {
                allsubsets = getSubsets(set, index + 1);
                int item = set.get(index);
                ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
                for (ArrayList<Integer> subset : allsubsets) {
                    ArrayList<Integer> newsubset = new ArrayList<Integer>();
                    allsubsets.add(subset); //
                    newsubset.add(item);
                    allsubsets.add(newsubset);
                }
                allsubsets.addAll(moresubsets);
            }
            return allsubsets;
    }


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(3);
        a.add(1);
        a.add(2);
        a.add(3);

        System.out.println(getSubsets(a,0));
    }
}
