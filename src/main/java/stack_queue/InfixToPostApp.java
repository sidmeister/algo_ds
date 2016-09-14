package stack_queue;

import java.io.IOException;

/**
 * Created by srathi on 8/11/16.
 */


    // infix.java
// converts infix arithmetic expressions to postfix
// to run this program: C>java InfixApp
              // for I/O
    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////
    public class InfixToPostApp
    {
        public static void main(String[] args) throws IOException
        {
            String input, output;
            input = "((A+B)*C)-D";
            InToPost1 theTrans = new InToPost1(input);
            output = theTrans.doTrans(); // do the translation
            System.out.println("Postfix is " + output + '\n');
        }  // end main()
        //--------------------------------------------------------------
        public static String getString() throws IOException
        {
            String s =  "(A-C+B)";
            return s;
        }
//--------------------------------------------------------------
    }  // end class InfixApp
////////////////////////////////////////////////////////////////

