package dynamicProgramming;

/**
 * Created by srathi on 11/22/16.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction
 (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class StockBuyAndSell {

    public static int getMaxValue(int[] arr)
    {
        //int[] dp = new int[arr.length + 1];
        //int result = arr[0];
        int result = 0;
        for (int i = 1; i<arr.length +1 ; i++)
        {
            result = 1;
//            result = Math.max(result,arr[i] - );
//            min = Math.min(result,arr[i]);
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] price = {100, 90, 80, 70, 60};

    }
}
