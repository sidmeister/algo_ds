package dynamicProgramming;

/**
 * Created by srathi on 12/25/16.
 Count ways to reach the n’th stair

 There are n stairs, a person standing at the bottom wants to reach the top.
 The person can climb either 1 stair or 2 stairs at a time.
 Count the number of ways, the person can reach the top.
 */
public  class ClimbingStairs {
    public int climbStairs(int[] res,int index) {

        if (index <=1)
            return  1;

        if (res[index] >0)
            return res[index];

        res[index] = climbStairs(res, index -1) + climbStairs(res, index -2);

        return res[index];
    }


    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();
        int number_of_stairs = 20;
        int[] res = new int[number_of_stairs+1];
        System.out.println(sol.climbStairs(res,number_of_stairs));
    }

}