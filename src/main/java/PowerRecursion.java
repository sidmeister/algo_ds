/**
 * Created by srathi on 8/22/16.
 */
public class PowerRecursion {

    public static int power(int x, int y)
    {
        int a ,b;

        if (y == 1)
            return x;
        else
            a = power(x*x,y/2);
        return y % 2 == 1 ?  a*x : a;

    }

        public static int power1(int x, int y)
        {
        int a ,b;

        if (y == 1)
            return x;
        else
            return x*power1(x,y-1);

    }

    public static void main(String[] args) {
        int x = 3, y = 18;
        int c = power (x,y);
        System.out.println(c);
        c = power1 (x,y);
        System.out.println(c);
        int p = 2, q = 8;
        c = power1(p,q);
        System.out.println(c);
        c = power(p,q);
        System.out.println(c);
    }
}
