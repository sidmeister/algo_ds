package recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by srathi on 11/29/16.
 * Write a function to generate all possible n pairs of balanced parentheses.

 For example, if n=1
 {}
 for n=2
 {}{}
 {{}}
 */
public class PrintValidParen {

    public static Set<String> genParen(int n)
    {
        Set<String> set = new HashSet<>();
        if ( n == 0)
        {
            set.add(new String(""));
        }
        else
        {
            Set<String> prev = genParen(n -1);
            for(String str: prev)
            {
                for( int i=0; i<str.length();i++)
                {
                    if (str.charAt(i) == '(')
                    {
                        String s = addInsideParen(str,i);
                        set.add(s);
                    }

                }
                set.add(new String("()") + str);
            }
        }
        return set;
    }

    public static String addInsideParen(String str, int i)
    {
        String leftstr = str.substring(0,i+1);
        String rightstr = str.substring(i+1);
        return leftstr + new String("()") + rightstr;
    }

    public static void main(String[] args) {
        int n = 3;
        Set<String> f = genParen(n);
        for(String str: f)
            System.out.println(str);

    }

}
