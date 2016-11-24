package Graph;

/**
 * Created by srathi on 11/24/16.
 */
public class PowerSet {

    static void powerSet(int[] arr)
    {
        for (int i = 0; i < arr.length; ++i)
        {
            int[] branch = new int[i];
            Combinations.combine(arr, i, 0, branch, 0);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        powerSet(a);
    }
}
