package com.sid.ctci;

import java.util.Stack;

/**
 * Created by srathi on 7/25/16.
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "2-1+2";
        char oper;
        Integer arg1,arg2,res;
        Stack operand = new Stack();
        Stack operator = new Stack();
        for (int i = 0, n = expression.length(); i < n; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-')
              operator.push(c);
            else
                operand.push(Character.getNumericValue(c));

        }
        System.out.println(operand);
        System.out.println(operator);
        while (!operator.empty())
        {
           oper  = (char) operator.pop();
           arg1 = (Integer) operand.pop();
            arg2 = (Integer) operand.pop();
            if (oper == '+')
                res = arg1 + arg2;
            else
                res = arg1 - arg2;
            operand.push(res);
        }
        Integer final_result = (Integer) operand.pop();
        System.out.println(final_result);
    }
}
