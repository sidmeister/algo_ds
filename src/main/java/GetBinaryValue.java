/**
 * Created by srathi on 11/19/16.
 * Get the binary representation of a number
 */
public class GetBinaryValue {

    public static void main(String[] args) {

        int num = 999;
        toBinary(num);
    }

    public static void toBinary(int num) {
        int[] path = new int[10];
        int j = 0;
        while (num >= 1) {
            path[j++] = num % 2;
            num = num / 2;
        }
        for (int i = path.length - 1; i >= 0; i--)
            System.out.print(path[i] + " ");
    }
}
