/**
 * Created by srathi on 12/30/16.
 */
public class MazeRecursion {

    public static void solve(int[][] maze,int row,int col,int exitrow,int exitcol) {

        int min = Integer.MAX_VALUE,res;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
            {
                res = findways(maze,i,j,row,col,exitrow,exitcol);
                if (res < min)
                    min = res;
            }

    }

    public static int findways(int[][] maze,int row,int col,int num_rows,int num_cols,int exitrow,int exitcol) {

        if(row > num_rows || col > num_cols)
            return Integer.MAX_VALUE;
        if(row == exitrow || col == exitcol)
            return 1;
        if(maze[row][col] == 1)
            return 0;
        int north = findways(maze,row-1,col,num_rows,num_cols,exitrow,exitcol);
        int south = findways(maze,row-1,col,num_rows,num_cols,exitrow,exitcol);
        int east = findways(maze,row-1,col,num_rows,num_cols,exitrow,exitcol);
        int min = findways(maze,row-1,col,num_rows,num_cols,exitrow,exitcol);

    }

    public static void main(String[] args) {
        int[][] maze = new int[][] {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        solve(maze,3,3,2,2);
    }
}
