/**
 * Created by srathi on 12/30/16.
 */

class Point
{
    int r;
    int c;
}

public class MazeRecursion {

    public static int solve(int[][] maze,int row,int col,int exitrow,int exitcol) {

        int min = Integer.MAX_VALUE,res=0;
       /* boolean res = findways(maze,i,j,row,col,exitrow,exitcol,ans,visited);
        if (res < min)*/
        return res;
    }

   /* public static boolean findways(int[][] maze,int row,int col,int num_rows,int num_cols,int exitrow,int exitcol,boolean[][] visited) {

        if(row > num_rows || col > num_cols || row < 0 || col > 0)
            return false;
        if(maze[row][col] == 1 || visited[row][col] == true)
            return false;
        ArrayList<Point> ans = new ArrayList<Point> ();
        if(row == exitrow && col ==exitcol)
        {

            return true;
        }
        else
        {
            Point p = new Point();
            p.r = row,
            p.c = col;
            ans.add(p);
            visited[row][col] = true;
            boolean foundway = false;
            int min = INTEGER.MAX_VALUE;
            if (findways(maze,row+1,col,num_rows,num_cols,exitrow,exitcol,ans)))//south direction
            {
                foundway = true;
                min = 1 + MATH.min(min,ans.size());

            }
            visited[row][col] = false;
            return foundway;
        }

    }

    public static void main(String[] args) {
        int[][] maze = new int[][] {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        System.out.println(solve(maze,3,3,2,2));
    }*/
}
