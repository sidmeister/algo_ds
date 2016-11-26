package recursion;

/**
 * Created by srathi on 11/23/16.
 *
 Count ways to reach the n’th stair

 There are n stairs, a person standing at the bottom wants to reach the top.
 The person can climb either 1 stair or 2 stairs at a time.
 Count the number of ways, the person can reach the top.
 */
public class ClimbingStairs {

    public static int fib(int n)
    {
        if (n <=1)
            return  1;
        return fib(n-1) + fib(n-2);
    }

    public static int findWays (int n)
    {
        return fib(n);
    }

    public static void main(String[] args) {
        int number_of_stairs = 5;
        System.out.println(findWays(number_of_stairs));
    }
}
