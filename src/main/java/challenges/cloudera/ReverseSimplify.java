package challenges.cloudera;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by srathi on 10/22/16.
 */
public class ReverseSimplify {
        public static void main (String[] args) throws Exception
        {
            String line;
            try (InputStreamReader instream = new InputStreamReader(System.in);
                 BufferedReader buffer = new BufferedReader(instream)) {
                while ((line = buffer.readLine()) != null) {
                    String pattern = "(.+)\\/(.+)?$";//match the input - expression "/" operation
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(line);
                    if (m.matches()) {
                        String expression = m.group(1); //extract the expression
                        String output_expr = expression.replaceAll("\\s+", ""); //remove all embedded spaces
                        if (m.group(2) != null) { //check for operation
                            String operation = m.group(2); //extract the operation
                            String output_oper = operation.replaceAll("\\s+", ""); //remove all embedded spaces from the operation
                            output_oper = output_oper.replaceAll("(S)(\\1{2,})", "$1"); //consecutive 'S' should become 1 'S'
                            for (int i = 0; i < output_oper.length(); i++) { //iterate left to right on the operations
                                char ch = output_oper.charAt(i);
                                if (new Character('R').equals(ch)) {
                                    output_expr = reverse(output_expr);
                                } else if (new Character('S').equals(ch)) {
                                    output_expr = Simplify(output_expr);

                                }

                            }
                        }
                        System.out.println(output_expr);
                    }

                }
            }
        }// end main()

    /*
    this reverse operation reverses the input given to it using Stack datastructure. '(' are replaced with ')' and vice versa
    */

        public static String reverse(String out) {
            Stack<Character> finalStack = new Stack<>();
            String finalString = "";
            for (int i = 0; i < out.length(); i++)
            {
                char ch = out.charAt(i);
                if (new Character(')').equals(ch)) {
                    finalStack.push(new Character('('));
                }
                if (!new Character('(').equals(ch) && !new Character(')').equals(ch)) {
                    finalStack.push(ch);
                }
                else if (new Character('(').equals(ch))
                    finalStack.push(new Character(')'));
            }

            while (!finalStack.empty()) {
                Character t = finalStack.pop();
                finalString += t;
            }

            return finalString;
        } // end reverse()

    /*
    this simplify operation reverses the parenthesis from the expression
    */

        public static String Simplify(String input) {
            StringBuffer temp = new StringBuffer(input);
            while (true) //infinite loop since simplifying one subexpression results in another candidate for simplify
            {
                String pattern = "(\\([A-Z]*\\))[A-Z]"; //look for the expression (Fx)y - (Fx) can be empty
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(temp);
                if (m.find()) {
                    String from_replace = m.group(1); //if match found extract the string to be replaced. Here we replace the "("String")" with "String"
                    String to_replace = from_replace.replaceAll("\\(", "");
                    to_replace = to_replace.replaceAll("\\)", "");
                    int start = temp.indexOf(from_replace);
                    int end = temp.indexOf(from_replace) + from_replace.length();
                    temp = temp.replace(start, end, to_replace);
                }
                else    // break out of infinite loop
                    break;
            }
            return temp.toString();
        } // end simplify()
    }//the - end
