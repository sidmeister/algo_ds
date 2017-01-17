/**
 * Created by srathi on 1/15/17.
 * In the table with n rows and n columns, some cells are occupied with balls, others are free.
 * You choose a ball and a place where you want to move it.
 * In one step the ball can be moved to the next horizontal or vertical empty cell.
 * Determine, is it possible to move the ball from the initial cell to the given, and if it is possible,
 * find a way with the minimum number of steps.
 */
public class BallsandCellsDfs {

    static char[][] mat = new char[][]{
            {'.','.','.','X','.'},
            {'.','.','.','.','.'},
            {'O','.','O','O','O'},
            {'.','.','.','.','.'},
            {'.','.','.','.','@'}
             };


    static char calcpathkickoff()
    {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        if(calcpathkick(4,4,visited)) {
            for(int i =0;i<mat.length;i++)
            {
                for(int j =0 ; j<mat[0].length;j++)
                    System.out.print(mat[i][j] + " ");
                System.out.print("\n");
            }
            return 'Y';
        }
        else {
            for(int i =0;i<mat.length;i++)
            {
                for(int j =0 ; j<mat[0].length;j++)
                    System.out.print(mat[i][j] + " ");
                System.out.print("\n");
            }
            return 'N';
        }

    }

    static boolean calcpathkick(int i,int j, boolean[][] visited)
    {
        if(i < 0 || j > (mat[0].length - 1))
            return false;

        if(mat[i][j] == 'X')
           return true;

       else if(mat[i][j] == 'O' || mat[i][j] == '+' )
            return false;

       else //(mat[i][j] == '.' )
        {
            mat[i][j] = '+';
            if (calcpathkick(i-1,j,visited)) return true;
            if (calcpathkick(i,j+1,visited)) return true;
            if (calcpathkick(i,j-1,visited)) return true;
            visited[i][j] = false;
            mat[i][j] = '.';
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(mat[0].length);
        System.out.println(calcpathkickoff());

    }
}
