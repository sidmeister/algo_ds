/**
 * Created by srathi on 11/22/16.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to buy one share of the stock and sell one share of the stock,
 design an algorithm to find the best times to buy and sell.
 */
public class StockBestTime {

    public static void besttime(int[] prices)
    {
        int minIndex = 0, maxdiff = Integer.MIN_VALUE, diff;
        int buyIndex = 0,sellIndex = 0;
        for (int i = 0; i < prices.length; i++)
        {
            if(prices[i] < prices[minIndex])
                minIndex = i;
            diff = prices[i] - prices[minIndex];
            if (diff > maxdiff)
            {
                maxdiff = diff;
                sellIndex = i;
                buyIndex = minIndex;

            }
        }
        System.out.println(buyIndex);
        System.out.println(sellIndex);

    }

    public static void main(String[] args) {
        int[] prices = {2,4,6,10,5,8,9};
        besttime(prices);
    }

}
