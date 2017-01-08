/*
Basic Euclidean Algorithm is used to find GCD of two numbers say a and b. Below is a recursive C function to evaluate gcd using Euclid’s algorithm.
*/

public class GCD {

    public static int gcd(int x,int y){
        if (y == 0)
            return x;
        else
            return gcd(y,x%y);

    }

    public static void main(String[] args){
        int x = 10, y = 15;
        int c = gcd(x,y);
        System.out.println(c);
    }
}
