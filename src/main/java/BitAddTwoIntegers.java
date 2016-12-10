/**
 * Created by srathi on 12/6/16.
 */
public class BitAddTwoIntegers {

    public static int add(int a, int b)
    {
        if(b == 0)
            return a;
        int carry = (a&b)<< 1;;
        int sum = (a^b);
        return add(sum,carry);
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(add(a,b));
    }
}
