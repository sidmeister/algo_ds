
/**
 * Created by srathi on 11/23/16.
 * Determine if a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class SudokuSolver {

    public static boolean check_valid(Character[][] board)
    {
        if(board.length < 9 || board[0].length < 9 || board == null)
            return false;

        //check each column
        for (int i =0 ; i < board.length; i++ )
        {
            boolean[] check = new boolean[9];
            for(int j =0 ; j<board[i].length;j++)
            {
                if(board[i][j]!= '.')
                {
                    if(check[(int) (board[i][j] -'1')])
                    {
                        return false;
                    }
                    check[(int) (board[i][j] -'1')] = true;
                }
            }
        }

        //check each row
        for (int j =0 ; j < board.length; j++ )
        {
            boolean[] check = new boolean[9];
            for(int i =0 ; i<board[j].length;i++)
            {
                if(board[i][j]!= '.')
                {
                    if(check[(int) (board[i][j] -'1')])
                    {
                        return false;
                    }
                    check[(int) (board[i][j] -'1')] = true;
                }
            }
        }

        //check 3*3 grid
        for (int k = 0; k < 9; k++) {
            boolean[] check = new boolean[9];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != '.') {
                        if (check[(int) (board[i][j] - '1')]) {
                            return false;
                        }
                        check[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Character[][] board = new Character[9][9];
        System.out.println(check_valid(board));
    }
}
