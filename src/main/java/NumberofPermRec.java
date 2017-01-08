
public class NumberofPermRec {

    public static int genPerm(int n, int k){
        if (k ==1)
            return n;
        else
        {
            return n*genPerm(n-1, k-1);
        }
    }


    public static void main(String[] args){
        int n = 10;
        int k = 3;
        int c = genPerm (n,k);
        System.out.println(c);
    }
}
