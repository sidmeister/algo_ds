/**
 * Created by srathi on 11/30/16.
 * Given a sum find pair of elements in the array which equal to the sum
 *Example:
  Let Array be {1, 4, 45, 6, 10, -8} and sum to find be 16
 */


public class GetPairForSum {

    public static void main(String[] args) {
        int sum = 16;
        int[] arr = new int[] {1, 4, 45, 6, 10, -8};
        boolean[] hashmap = new boolean[100];
        for (int i =0; i< arr.length; i++ )
        {
            int temp = sum - arr[i];
            if(hashmap[temp] == true)
            {
                System.out.print(i + "," + temp);
                hashmap[arr[i]] = true;
            }
        }
    }
}
