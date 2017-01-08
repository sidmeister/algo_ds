/**Suppose that there is a pile of sixteen coins on a table, one of which is a counterfeit weighing slightly less than the others. You also have a twopan balance that allows you to weigh one set of coins against another. Using the principle of divide-and-conquer, how could you determine the counterfeit coin in four weighings? If you solve this problem, see if you can come up with a procedure to find the counterfeit coin in just three weighings. The strategy is much the same, but the problem must be subdivided in a different way. Can you generalize this approach so that it works for any set of N coins?**/


public class CounterfeitCoinRecursion {

    public static int wt(int[] coins,int start,int mid)
    {
        int sum=0;
        for(int i=start;i<mid;i++)
        {
            sum += coins[i];
        }
        return sum;
    }

    public static int[][] samplesize(int[] coins)
    {
        double samplesize = 1.0/3 * coins.length;
        int[][] samples = new int[3][(int)Math.round(samplesize+1)];
        for(int i = 0; i <3;i++)
        {
            int start = (int)Math.round(i*samplesize);
            int end   = (int)Math.round((i+1)*samplesize);

            for(int j = start, k= 0 ; j < end ; j++,k++)
            {
                samples[i][k] = coins[j];
            }
        }
        return samples;
    }

    public static int len(int[] arr)
    {
        int nelems = 0;
        for(int i =0;i<arr.length;i++)
            if(arr[i]!=0)
                nelems++;
        return nelems;
    }

       public static void findCounterfeit(int[] coins)
       {
        if(len(coins) == 1)
            System.out.println("counterfeit is:" + coins[0]);
        else
        {
        int[][] s = samplesize(coins);
        int[] chunk1 = s[0];
        int[] chunk2 = s[1];
        int[] chunk3 = s[2];
        if (len(chunk1) == len(chunk2) && len(chunk1) == len(chunk3))
        {
            if (wt(chunk1,0,chunk1.length) > wt(chunk1,0,chunk2.length) || wt(chunk3,0,chunk3.length) > wt(chunk2,0,chunk2.length))
            {
                System.out.println("counterfeit must be in chunk2");
                findCounterfeit(chunk2);
            }
            else if (wt(chunk1,0,chunk1.length) > wt(chunk3,0,chunk3.length))
            {
                System.out.println("counterfeit must be in chunk3");
                findCounterfeit(chunk3);
            }
            else
            {
                System.out.println("counterfeit must be in chunk1");
                findCounterfeit(chunk1);
            }
        }
        else
        {
            if (len(chunk1) == len(chunk2))
            {
                if (wt(chunk1,0,chunk2.length) > wt(chunk2,0,chunk2.length))
                {
                    System.out.println("counterfeit must be in chunk2");
                    findCounterfeit(chunk2);
                }
                else if(wt(chunk2,0,chunk2.length) > wt(chunk1,0,chunk1.length))
                {
                    System.out.println("counterfeit must be in chunk1");
                    findCounterfeit(chunk1);
                }
                else
                {
                    System.out.println("counterfeit must be in chunk3");
                    findCounterfeit(chunk3);
                }
            }
            else if (len(chunk1) == len(chunk3))
            {
                if (wt(chunk1,0,chunk1.length) > wt(chunk3,0,chunk3.length))
                {
                    System.out.println("counterfeit must be in chunk3");
                    findCounterfeit(chunk3);
                }
                else if(wt(chunk3,0,chunk3.length) > wt(chunk1,0,chunk1.length))
                {
                    System.out.println("counterfeit must be in chunk1");
                    findCounterfeit(chunk1);
                }
                else
                {
                    System.out.println("counterfeit must be in chunk2");
                    findCounterfeit(chunk2);
                }
            }
            else
            {
                System.out.println("counterfeit must be in chunk2");
                findCounterfeit(chunk2);
            }
        }
    }
    }

    public static void findCounterfeit4(int[] coins,int start,int end){
        if(end - start == 1)
            System.out.println("counterfeit coin is at index " + start);
        else
        {
            int mid = (start+end)/2;
            int left_wt = wt(coins,start, mid);
            int right_wt = wt(coins,mid, end);
            if(left_wt < right_wt)
            {
                System.out.println("weighings");
                findCounterfeit4(coins,start,mid);
            }
            else
            {
                System.out.println("weighings");
                findCounterfeit4(coins,mid,end);
            }
        }
    }

    public static void main(String[] args){
        int[] coins = new int[]{2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        findCounterfeit(coins);
    }
}
