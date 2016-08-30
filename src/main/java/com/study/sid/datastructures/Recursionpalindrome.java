package com.study.sid.datastructures;

/**
 * Created by srathi on 8/5/16.
 */
public class Recursionpalindrome {
    private String input;

    public Recursionpalindrome(String input) {
        this.input = input;
    }

    public boolean checkPalindrome()
    {
        return  doPalindromeCheck(0,input.length() -1);
    }

    public boolean doPalindromeCheck(int low, int high)
    {
        //System.out.println(low);
        //System.out.println(high);
        if (high == low ) //if only char then it is always a palindrome
            return true;
        char clow = input.charAt(low);
        //System.out.println(clow);
        char chigh = input.charAt(high);
        //System.out.println(chigh);
        if (clow != chigh)
            return false;
        else
            doPalindromeCheck(low +1,high -1);
        return true;

    }

    public static void main(String[] args) {
        String input = "aToyotasaToyota";
        if (input.length() == 1 || input.isEmpty() || input == "")
        {
            System.out.println("more than 1 character needed to check for palindrome");
        }
        Recursionpalindrome rep = new Recursionpalindrome(input);
        if (rep.checkPalindrome())
        {
            System.out.println("we have a palindrome");
        }
    }
}
