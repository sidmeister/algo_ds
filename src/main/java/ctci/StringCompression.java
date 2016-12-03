package ctci;

/**
 * Created by srathi on 12/2/16.
 */
public class StringCompression {

    public static String compress(String str)
    {
        StringBuilder s = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++)
        {
            cnt++;
            if ( i+1 >= str.length() || str.charAt(i+1) != str.charAt(i))
            {
                s.append(str.charAt(i));
                s.append(cnt);
                cnt = 0;
            }
        }
        return s.length() < str.length() ? s.toString() : str;
    }

    public static void main(String[] args) {

        String s = "aabcccccaaa";
        System.out.println(compress(s));
    }


}
