
public class NumberofCombRec {

    public static int genComb(int n, int k){
        if (k ==0 || n == k)
            return 1;
        else
        {
            return genComb(n-1,k-1) + genComb(n-1,k);
        }
    }


    public static void main(String[] args){
        int n = 10;
        int k = 3;
        int c = genComb (n,k);
        System.out.println(c);
    }
}
