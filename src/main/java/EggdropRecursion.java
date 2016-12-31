/**
 * Created by srathi on 12/18/16.
 */
public class EggdropRecursion {

    public static int eggDrop(int n, int k)
    {

        if(k == 1 || k == 0 || n == 1)
            return k;

        int min = Integer.MAX_VALUE,res;


        for (int x =1; x<=k; x++)
        {
                res = 1 + Math.max(eggDrop(n-1,x-1),eggDrop(n,k-x));
            if (res < min)
                min = res;
        }
        return min;
    }

    public static void main(String[] args) {
        int n = 2, k = 10;
        System.out.println("Minimum number of trials in worst case with " +  n + " eggs and " + k + " floors is:" + eggDrop(n, k));
    }
}
