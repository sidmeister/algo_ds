/**
 * Created by srathi on 8/5/16.
 */
public class StringReverseRec {

    private  String input;
    private String output = "";

    public StringReverseRec(final String input) {

        this.input = input;
    }

    public String StringReverse()
    {
        Stack arr = new Stack(input.length());
        for(int j =0 ; j<input.length();j++)
        {
            char cpush = input.charAt(j);
            arr.push(cpush);
        }
        while(!arr.is_empty())
        {
            Character cpop = (Character) arr.pop();
            output = output + cpop;
        }
        return output;

    }


    public static void main(String[] args) {

        String input = "nitin";
        StringReverseRec orig = new StringReverseRec(input);
        String reverse = orig.StringReverse();
        System.out.println(input);
        System.out.println(reverse);
        if (input.equals(reverse))
        {
            System.out.println("We have a palindrome");
        }

    }
}
