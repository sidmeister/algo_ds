/**
 * Created by srathi on 3/22/17.
 *
 * Problem statement : Finding the length of the connected cells of 1s(regions) in a matrix of 0s and 1s : Given a matrix.each of which may be 1 or 0.
 * The filled cells that are connected form a region. Two cells are said to be connected if they are adjacent to each other horizontally,
 * vertically or diagonally. There may be several regions in the matric. How do you find the largest region (in terms of number of cells) in the matrix?
 */
public class MatrixRegion {

     public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0}
        };
        findMaxOnes(matrix);
    }

    public static boolean isSafe(int row,int col,int[][] matrix)
    {
        if((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length) && matrix[row][col] == 1 )
            return true;
        else
            return false;
    }

    public static int findMaxBlock(int row,int col,int[][] matrix,boolean[][] visited)
    {
        if(!(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) || !(matrix[row][col] == 1 && visited[row][col] == false) )
            return 0;
        int[][] direction = new int[][]{{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count = 1;
        visited[row][col] = true;
        for(int i =0;i<8;i++) {
            int newr = row + direction[i][0];
            int newc = col + direction[i][1];
            count = count + findMaxBlock(newr, newc, matrix, visited);
        }
        return count;
    }

    public static void findMaxOnes(int[][] matrix)
    {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int size =0;
        int maxSize = 0;
        for(int i =0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j] == 1 && visited[i][j] == false )
                    size =findMaxBlock(i,j,matrix,visited);
                if (size > maxSize)
                    maxSize = size;
            }
        }

        System.out.println(maxSize);
    }

}
