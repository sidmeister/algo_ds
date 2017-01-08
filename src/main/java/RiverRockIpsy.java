/**
 * Created by srathi on 1/3/17.
 * You are given a string which represents the width of a river. River contains rocks represented by
 an asterisk (*), and water is represented by an empty space. You need to write a method that determines whether you can cross the river assuming you follow the following rules:

 river = "*****  *   * * *  *  *  "
 Initial location: 0
 Initial speed: 0

 each step:
 1. choose a speed from {current speed, current speed + 1, current speed - 1} (speed cannot be negative)
 2. move speed spaces on the river: current location += speed
 3. if you land on water (empty space), you fail
 4. if you land past end of river, you win
 5. otherwise, keep going


 example:
 river = "*****  *   * * *  *  *  "
 011  2   3    4     4  3   3   4 (crossed)

 impossible_river = "****  *      *   *"
 01  2  3 234  (failed)

 Question: Given a river, is it possible to cross it?
 (i.e. function from string to boolean)

 */


public class RiverRockIpsy {

    public static boolean isway(int loc, int speed, char[] str) {
        if (speed <= 0) return false;
        if (loc >= str.length) return true;
        if (str[loc] == ' ') return false;
        else {
            return (isway(loc + speed, speed, str) || isway(loc + speed + 1, speed + 1, str) || isway(loc + speed - 1, speed - 1, str));
        }
    }

    public static boolean iswayPrintPath(int loc, int speed, char[] str,char[]path) {
        if (speed <= 0) return false;
        if (loc >= str.length) return true;
        if (str[loc] == ' ') return false;
        else {
            path[loc] = '+';
            if (iswayPrintPath(loc + speed, speed, str,path)) return true;
            if (iswayPrintPath(loc + speed + 1, speed + 1, str,path)) return true;
            if (iswayPrintPath(loc + speed - 1, speed - 1, str,path)) return true;
            path[loc] = ' ';
            return false;
        }

    }


    public static void main(String[] args) {
        String river = new String("*****  *   * * *  *  *  ");
        //String river = new String("****  *      *   *");
        char[] arr = river.toCharArray();
        char[] path = new char[arr.length];
        iswayPrintPath(1,1,arr,path);
        for(int i =0 ; i < path.length;i++)
            System.out.print(path[i] + " ");;

    }
}
