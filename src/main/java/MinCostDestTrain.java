/**
 * Created by srathi on 12/26/16.
 * Find the minimum cost to reach destination using a train
 There are N stations on route of a train. The train goes from station 0 to N-1.
 The ticket cost for all pair of stations (i, j) is given where j is greater than i.
 Find the minimum cost to reach the destination.

 Consider the following example:

 Input:
 cost[N][N] = { {0, 15, 80, 90},
 {INF, 0, 40, 50},
 {INF, INF, 0, 70},
 {INF, INF, INF, 0}
 };
 There are 4 stations and cost[i][j] indicates cost to reach j
 from i. The entries where j < i are meaningless.

 Output:
 The minimum cost is 65
 The minimum cost can be obtained by first going to station 1
 from 0. Then from station 1 to station 3.
 */
public class MinCostDestTrain {



    public static int mincost(int start, int end,boolean[] visited,int[][]cost) {

        if (start == end)
            return 0;
        visited[start] = true;
        System.out.print(cost[start][start+1] + " ");
        for(int n=0;n<cost[0].length;n++)
        {
            if(n > start && visited[n] == false)
            {
                mincost(n,end,visited,cost);
            }

        }
        return 0;
    }

    public static void minCostKickoff(int[][] cost)
    {
        boolean[] visited = new boolean[4];
        for(int i=0;i<cost.length;i++) {
            mincost(i, 3, visited, cost);
        }
    }

    public static void main(String[] args) {
        int[][] cost = new int[][]{ {0, 15, 80, 90},
                {Integer.MAX_VALUE, 0, 40, 50},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 70},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        minCostKickoff(cost);

    }
}
