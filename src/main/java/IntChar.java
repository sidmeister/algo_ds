/**
 * Created by srathi on 12/2/16.
 */
public class IntChar {

    public static void main(String[] args) {

        String s = "123456789abcdefghi";
        char[] str = s.toCharArray();
        int end = str.length;
        int start = 0;
        int mid;
        char temp1 = '\0',temp2='\0';

        for (int i = 0; i < str.length; i = i+2)
        {
            start = i;
            mid = ((start + end)/2);
            temp1 = str[start];
            temp2 = str[mid];
            for(int j = mid; j > start; j-- )
                str[j] = str[j-1];
            str[start+1] = temp2;
        }


        for (int j = 0; j < str.length;j++)
            System.out.print(str[j] + " ");

    }
}
