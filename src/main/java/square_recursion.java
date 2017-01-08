/**
 * Created by srathi on 8/22/16.
 */
public class square_recursion {

    public static int sqr(int x)
    {
        int a =0;

        if(x == 0)
            return 0;

        if (x == 1)
            return 1;
        else
        {
            return 2*x -1 + sqr(x-1);

        }

    }




    public static void main(String[] args) {
        int x = 4;
        int c = sqr (x);
        System.out.println(c);

    }
}
