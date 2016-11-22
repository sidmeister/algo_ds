package dynamicProgramming;

/**
 * Created by srathi on 11/22/16.
 */

class Pair{
    int minIndex;
    int secondMinIndex;
}


class PaintHouse {

    public int findMin(int[][] cost)
    {
        int[] ans = new int[cost.length];
        int states[][] = new int[cost.length][cost[0].length];
        for (int i = 0; i < cost[0].length; i++)
            states[0][i] = cost[0][i];

        for (int i = 1; i < cost.length; i++)
        {
            Pair p = findMinSecondMin(states[i-1]);
            ans[i-1] = p.minIndex;
            for (int j=0; j <cost[0].length; j++ )
            {
                states[i][j] = cost[i][j];
                if(j == p.minIndex)         //no two houses can be of same color
                {
                    states[i][j] += states[i-1][p.secondMinIndex];
                }
                else
                {
                    states[i][j] += states[i-1][p.minIndex];
                }
            }
            //displaydp(cost, states);

        }

        int min = Integer.MAX_VALUE;

        for (int i=0 ; i < states[0].length; i++)
        {
            min = Math.min(min,states[states.length-1][i]);
        }

        for (int i=0 ; i < ans.length; i++)
        {
            System.out.print(ans[i] + " ");
        }

        System.out.print("\n");

        return min;
    }

    private Pair findMinSecondMin(int[] input)
    {
        System.out.print("\n");
        Pair p = new Pair();
        int minIndex , secondMinIndex ;



        if (input[0] < input[1]){
            minIndex = 0;
            secondMinIndex = 1;
        }
        else {
            minIndex = 1;
            secondMinIndex = 0;
        }
        for (int i = 2; i < input.length; i++)
        {
            if (input[i] <= input[minIndex])
            {
                secondMinIndex = minIndex;
                minIndex = i;
            }
            else if (input[i] <= input[secondMinIndex])
            {
                secondMinIndex = i;

            }
        }


        p.minIndex = minIndex;
        p.secondMinIndex = secondMinIndex;
        return p;
    }



    public void displaydp(int[][] cost,int[][] states)
    {
        for (int i = 0; i < cost.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < cost[0].length; j++)
                System.out.print(states[i][j] + " ");
        }


    }
}

    public class PaintChange {
        public static void main(String[] args) {
            int[][] cost = new int[][]{{1, 2, 1}, {1, 4, 5}, {2, 6, 1}, {3, 3, 2}};
            PaintHouse paintHouse = new PaintHouse();
            int min = paintHouse.findMin(cost);
            System.out.println(min);


        }
    }


