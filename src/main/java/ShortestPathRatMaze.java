/**
 * Created by srathi on 1/16/17.
 * to find the shortest path between a given source cell to a destination cell.
 */

class MazePoint
{

    boolean found;
    int value;

    public MazePoint(boolean found,int value) {
        this.found = found;
        this.value = value;
    }
}

public class ShortestPathRatMaze {

    public static final int ROW = 9;
    public static final int COL = 10;



    static boolean isValid(int row, int col)
    {
        // return true if row number and column number
        // is in range
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    public static MazePoint bfsutil(int[][] mat,int x,int y,int destx, int desty,boolean[][] visited)
    {
        if(x == destx && y == desty)
        {
           return new MazePoint(true,0);
        }

        else if(!isValid(x,y) || mat[x][y]==0 || visited[x][y]) {
            return new MazePoint(false, 0);
        }
        else {
            int res = Integer.MAX_VALUE;
            visited[x][y] = true;
            MazePoint sol = bfsutil(mat,x,y-1,destx,desty,visited);
            if (sol.found) res = Math.min(res, sol.value);
            sol = bfsutil(mat, x, y + 1, destx,desty,visited);
            if (sol.found) res = Math.min(res, sol.value);
            sol = bfsutil(mat, x - 1, y, destx,desty,visited);
            if (sol.found) res = Math.min(res, sol.value);
            sol = bfsutil(mat, x + 1, y, destx,desty,visited);
            if (sol.found) res = Math.min(res, sol.value);
            visited[x][y] = false;
            if (res != Integer.MAX_VALUE)
            {
                MazePoint p = new MazePoint(true, 1 + res);
                return p;
            }

            // if destination can't be reached from current cell,
            // return false
            else
            {
                MazePoint  p = new MazePoint(false,Integer.MIN_VALUE);
                return p;
            }

        }

    }

    public static void main(String[] args) {
        int mat[][] = new int[][]
        {
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        MazePoint point = bfsutil(mat, 0,0,3,4,visited);

        if (point.found)
            System.out.println("Shortest Path is:" + point.value) ;
        else
            System.out.println("Shortest Path doesn't exist");


    }

}
