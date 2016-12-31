import java.util.ArrayList;

/**
 * Created by srathi on 11/28/16.
 */
public class PermutationsRec {

    public static ArrayList<String> getPermutations(String str)
    {
        if (str == null)
            return null;
        ArrayList<String> permutations = new ArrayList<>();

        if (str.length() == 0)
        {
            permutations.add(new String(""));
            return permutations;
        }
        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPermutations(remainder);
        for(String word : words)
        {
            for(int i=0; i<=word.length();i++)
            {
                String s = insertChar(first,i,word);
                permutations.add(s);
            }
        }
        return permutations;

    }

    public static String insertChar(char insert, int position, String str)
    {
        String start = str.substring(position);
        String end = str.substring(0,position);
        return start + insert + end;
    }

    public static void main(String[] args) {
        String test = "abc";
        System.out.println(getPermutations(test));
    }
}
