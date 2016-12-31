import java.util.*;

/**
 * Created by srathi on 10/3/16.
 */
public class Lookahead {



    public static void main(String[] args) {

        String input = "IBM cognitive computing|IBM \"cognitive\" computing is a revolution| ibm cognitive computing|'IBM Cognitive Computing' is a revolution";
        String[] data = input.split("\\|");
        String [] out = data;
        String toCompare = null;
        Map<String, Integer> a = new LinkedHashMap<String, Integer>();
        int maxlength = 0 ,currlength = 0, maxindex = 0;
        for(int i= 0 ; i < data.length; i ++)
        {
            currlength = data[i].length();
            String temp = data[i];
            temp = temp.toLowerCase();
            temp = temp.trim();
            temp = temp.replaceAll("[^A-Za-z0-9 ]", "");
            temp = temp.replaceAll("\\s+", " ");
            if (!a.containsKey(temp))
            a.put(temp,i);
            if (currlength > maxlength)
            {
                maxlength = currlength;
                maxindex = i;
                toCompare = temp;
            }
        }

        System.out.println(toCompare);

        Iterator iter = a.keySet().iterator();
        while (iter.hasNext()) {
            String temp = (String) iter.next();
            if (toCompare.contains(temp) && !toCompare.equals(temp))
            {
                    a.remove(temp);
            }
        }
        System.out.println(a.entrySet());



    }


}
