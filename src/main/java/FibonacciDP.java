/**
 * Created by srathi on 9/1/16.
 */
public class FibonacciDP {

    public static int rec_fib (int number)
    {
        if (number <= 1)
            return  number;
        return rec_fib(number -1 ) + rec_fib(number - 2);
    }


    public static double dp_fib (double number)
    {
        double[] fib = new double[(int) number];
        fib[0] = 1;
        fib[1] = 1;
        for (int i =2 ; i < number; i++)
            fib[i] = fib[ i -1 ]+ fib[i-2];
        return fib[(int)number - 1];
    }

    public static void main(String[] args) {
        double n = 100, m;
        //m = rec_fib(n);
        m = dp_fib(n);
        System.out.println(m);
    }
}
