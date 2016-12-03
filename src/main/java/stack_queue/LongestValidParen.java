package stack_queue;
import java.util.Stack;

/**
 * Created by srathi on 12/2/16.
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.
 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParen {



    public static void main (String[] args){
        String str = "))()(())";
        int maxLen = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(i);
            }
            else{
                //no matching left - update start to next position
                //start of new local maxima
                if(stack.isEmpty()){
                    start = i+1;
                }
                else{
                    int startIndex = stack.pop();
                    //end of local maxima
                    maxLen = Math.max(maxLen, i-startIndex+1);
                    //after poping start if there is no start left on the stack indicating
                    //that this pair of parenthesis may be a part of longer substring
                    //for example, consider the case for ()()()
                    //update global maxima
                    if(stack.isEmpty()){
                        maxLen = Math.max(maxLen, i-start+1);
                    }
                }
            }
        }

        System.out.println(maxLen);
    }

}
