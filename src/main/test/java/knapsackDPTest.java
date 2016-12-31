
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by srathi on 11/22/16.
 */
public class knapsackDPTest {

    @Test
    public void testMaxValue()
    {
        knapsackDP k = new knapsackDP();
        int[] value = new int[]{1,4,5,7};
        int[] wt = new int[]{1,3,4,5};
        int total_wt = 7;
        Assert.assertEquals(9,k.maxValue(value,wt,total_wt));

        value = new int[]{60,100,120};
        wt = new int[]{10,20,30};
        total_wt = 50;
        Assert.assertEquals(220,k.maxValue(value,wt,total_wt));

        value = new int[]{50, 40, 10, 30};
        wt = new int[]{3, 4, 5, 6};
        total_wt = 10;
        Assert.assertEquals(90,k.maxValue(value,wt,total_wt));

    }

    @Test
    public void testMaxSubArrayDp()
    {
        MaximumSubArrayDP maximumSubArray = new MaximumSubArrayDP();
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(6,maximumSubArray.getMaximumSub(arr));
    }

    @Test
    public void testEggMaxValue()
    {
        EggDropDP k = new EggDropDP();
        int eggs = 2;
        int floors = 36;
        Assert.assertEquals(8,k.minAttemps(eggs,floors));

    }

}