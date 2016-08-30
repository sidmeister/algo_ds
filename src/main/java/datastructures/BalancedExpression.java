package datastructures;

/**
 * Created by srathi on 8/9/16.
 */
public class BalancedExpression {

    public static void main(String[] args) {
        String input = "(a{b[c]d}e";
        Stack stx = new Stack(input.length());
        for (int i = 0; i < input.length();i ++) {
            char c = input.charAt(i);
            //System.out.println(c);
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stx.push(c);
                    //System.out.println(stx.peek());
                    break;
                case '}':
                case ')':
                case ']':
                    if (!stx.is_empty()) {
                        char p = (char) stx.pop();
                        if ((c == '}' && p != '{') ||
                            (c == ')' && p != '(') ||
                            (c == ']' && p != '[')
                           )
                            System.out.println("not balanced");
                    }
                    else
                        System.out.println("not balanced");
                    break;
                default:
                    break;
            }
        }
        if (!stx.is_empty()) {
            System.out.println("not balanced");
        }

    }
}
