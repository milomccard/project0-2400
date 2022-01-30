public class Sudokusolver_copy
{

    public static void main(String[] args)
    {
        
        int[][] sudokuBoard = { {1,0,0,0,9,0,0,0,5},
                                {0,0,8,0,0,5,6,0,0},
                                {0,6,0,0,3,0,0,8,0}, 
                                {0,4,0,0,0,0,0,0,0}, 
                                {2,0,5,0,8,0,4,0,1}, 
                                {0,0,0,0,0,0,0,2,0}, 
                                {0,2,0,0,1,0,0,9,0}, 
                                {0,0,3,4,0,0,7,0,0}, 
                                {6,0,0,0,5,0,0,0,8} };
        print(sudokuBoard);
        System.out.print("\n");
        if (solveBoard(sudokuBoard))
        {
            print(sudokuBoard);
        }
    }   
     
    public static void print(int[][] board)
    {
        for (int i = 0; i <= 8; i++)
        {
            if (((i % 3) == 0) && (i != 0))
            {
                System.out.println("- - - - - - - - - - - -");
            }
            for (int j = 0; j <= 8; j++)
            {
                if ((j % 3 == 0))
                {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    public static boolean isNumberInRow(int[][] board, int number, int row)
    {
        for (int i = 0; i < 9; i++)
        {
            if (board[row][i] == number)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInColumn(int[][] board, int number, int column)
    {
        for (int i = 0; i < 9; i++)
        {
            if(board[i][column] == number)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberIn3x3(int[][] board, int number, int row, int column)
    {
        int upperLeftRow = row - (row % 3);
        int upperLeftColumn = column - (column % 3);

        for (int i = upperLeftRow; i < (upperLeftRow + 3); i++)
        {
            for (int j = upperLeftColumn; j < (upperLeftColumn + 3); j++)
            {
                if (board[i][j] == number)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPlacementValid(int[][] board, int number, int row, int column)
    {
        return !isNumberIn3x3(board, number, row, column) &&
               !isNumberInColumn(board, number, column) &&
               !isNumberInRow(board, number, row);
    }

    public static boolean solveBoard(int[][] board)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == 0)
                {
                    for (int numberToTry = 1; numberToTry <=9; numberToTry++)
                    {
                        if (isPlacementValid(board, numberToTry, i, j))
                        {
                            board[i][j] = numberToTry;

                            if (solveBoard(board))
                            {
                                return true;
                            }
                            else
                            {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}