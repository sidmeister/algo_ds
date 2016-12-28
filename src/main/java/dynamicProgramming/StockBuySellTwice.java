package dynamicProgramming;

/**
 * Created by srathi on 12/25/16.
 *
 * Maximum profit by buying and selling a share at most twice
 In a daily share trading, a buyer buys shares in the morning and sells it on same day. If the trader is allowed
 to make at most 2 transactions in a day, where as second transaction can only start after first one is complete
 (Sell->buy->sell->buy).
 Given stock prices throughout day, find out maximum profit that a share trader could have made.
 Input:   price[] = {10, 22, 5, 75, 65, 80}
 Output:  87
 Trader earns 87 as sum of 12 and 75
 Buy at price 10, sell at 22, buy at 5 and sell at 80

 Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
 Output:  100
 Trader earns 100 as sum of 28 and 72
 Buy at price 2, sell at 30, buy at 8 and sell at 80

 Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
 Output:  72
 Buy at price 8 and sell at 80.

 Input:   price[] = {90, 80, 70, 60, 50}
 Output:  0
 Not possible to earn.
 *
 */
public class StockBuySellTwice
{
    // Returns maximum profit with two transactions on a given
    // list of stock prices, price[0..n-1]
    static int maxProfit1(int price[], int n)
    {
        // Create profit array and initialize it as 0
        int profit[] = new int[n];
        for (int i=0; i<n; i++)
            profit[i] = 0;

        /* Get the maximum profit with only one transaction
           allowed. After this loop, profit[i] contains maximum
           profit from price[i..n-1] using at most one trans. */
        int max_price = price[n-1];
        for (int i=n-2;i>=0;i--)
        {
            // max_price has maximum of price[i..n-1]
            if (price[i] > max_price)
                max_price = price[i];

            // we can get profit[i] by taking maximum of:
            // a) previous maximum, i.e., profit[i+1]
            // b) profit by buying at price[i] and selling at
            //    max_price
            profit[i] = Math.max(profit[i+1], max_price-price[i]);
        }

        /* Get the maximum profit with two transactions allowed
           After this loop, profit[n-1] contains the result */
        int min_price = price[0];
        for (int i=1; i<n; i++)
        {
            // min_price is minimum price in price[0..i]
            if (price[i] < min_price)
                min_price = price[i];

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and add
            //    profit of other trans. stored in profit[i]
            profit[i] = Math.max(profit[i-1], profit[i] +
                    (price[i]-min_price) );
        }
        int result = profit[n-1];
        return result;
    }

    static int maxProfit2(int[] prices) {
        // f(i) = max profit in [0, i]
        // g(i) = max profit in [i + 1, n - 1]
        // max profit in [0, n - 1] = max{f(i) + g(i), for all 0 <= i <= n - 1}
        int N = prices.length;
        if (N < 2)  return 0;

        int[] f = new int[N];
        int[] g = new int[N];

        // calculate f[i]
        int min = prices[0];
        for (int i = 1; i < N; i++) {
            min = Math.min(min, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - min);
        }

        // calculate g[i]
        int max = prices[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            g[i] = Math.max(g[i + 1], max - prices[i]);
        }

        // calculate max profit
        int profit = 0;
        for (int i = 0; i < N; i++) {
            profit = Math.max(profit, f[i] + g[i]);
        }
        return profit;
    }


    public static void main(String args[])
    {
        int price[] = {2, 30, 15, 10, 8, 25, 80};
        int n = price.length;
        System.out.println("Maximum Profit = "+ maxProfit1(price, n));
        System.out.println("Maximum Profit = "+ maxProfit2(price));

    }

}/* This code is contributed by Rajat Mishra */