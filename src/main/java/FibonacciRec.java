/**
 * Created by srathi on 11/26/16.
 */
public class FibonacciRec {

    public static int fib(int n)
    {
        if (n <=1 )
            return 1;
        else
            return (fib(n-1)) + fib(n-2);
    }

    public static void main(String[] args) {
        int n =5;
        System.out.println(fib(n));
    }
}
