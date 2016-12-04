import java.util.HashMap;
import java.util.Map;

/**
 * Created by srathi on 12/2/16.
 *
 *  You are playing the following Bulls and Cows game with your friend:
 *  You write down a number and ask your friend to guess what the number is.
 *  Each time your friend makes a guess, you provide a hint that indicates how many
 *  digits in said guess match your secret number exactly in both digit and position (called "bulls")
 *  and how many digits match the secret number but locate in the wrong position (called "cows").
 *  Your friend will use successive guesses and hints to eventually derive the secret number.
 For example:

 Secret number:  "1807"
 Friend's guess: "7810"

 Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 Write a function to return a hint according to the secret number and friend's guess,
 use A to indicate the bulls and B to indicate the cows.
 In the above example, your function should return "1A3B"
 *
 */
public class BullsandCows {

    public static void main(String[] args) {
        String number = "1807";
        String guess = "7810";
        int bulls =0,cows = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i =0; i < number.length();i++)
        {
            char s = number.charAt(i);
            char g = guess.charAt(i);
            if( s == g)
                bulls++;
            else
            {
                if (map.containsKey(s))
                {
                    int freq = map.get(s);
                    freq++;
                    map.put(s,freq);

                }
                else
                    map.put(s,1);
            }
        }

        //cows
        for (int i =0; i < number.length();i++)
        {
            char s = number.charAt(i);
            char g = guess.charAt(i);
            if( s != g) {
                cows++;
                if (map.get(g) == 1) {
                    map.remove(g);
                } else {
                    int freq = map.get(g);
                    freq--;
                    map.put(g, freq);
                }
            }
        }



        System.out.println( "A" + bulls + "B" + cows);

    }
}
