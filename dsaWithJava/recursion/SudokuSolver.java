package recursion;

/*
A sudoku solution must satisfy all of the following rules:
-> Each of the digits 1-9 must occur exactly once in each row.
-> Each of the digits 1-9 must occur exactly once in each column.
-> Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The ' ' character indicates empty cells.
*/

public class SudokuSolver extends solver {
    public static void main(String[] args) {
        int[][] board = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        System.out.println("\nInput\n");
        printBoard(board);
        if(solveBoard(board)) {
            System.out.println("Solved 😗\n");
            printBoard(board);
            System.out.println();
        } else {
            System.out.println("Unsolvable 🥲\n");
            printBoard(board);
            System.out.println();
        }
    }
}

class solver {
    // To print the board
    static void printBoard(int[][] board) {
        for(int row = 0; row < 9; row++) {
            if(row % 3 == 0)
            // for printing before grid rows
                System.out.println("-------------------------------");
            for(int col = 0; col < 9; col++) {
                // for printing before grid columns
                if(col % 3 == 0)
                    System.out.print("|");
                System.out.print(" " + board[row][col] + " ");
                // for printing at last grid column
                if(col == 8)
                    System.out.print("|");
            }
            // for printing at last grid row
            if(row == 8)
                System.out.println("\n-------------------------------");
            System.out.println();
        }
    }

    // To check if number is present in row
    static boolean isNumInRow(int[][] board, int row, int number) {
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == number)
                return true;
        }
        return false;
    }

    // To check if number is present in column
    static boolean isNumInCol(int[][] board, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == number)
                return true;
        }
        return false;
    }

    // To check if number is present in 3X3 grid
    static boolean isNumInGrid(int[][] board, int row, int col, int number) {
        // There are two ways to get the initial row and column of 3X3 grid
        // 1 👇🏻
        int startingRow = row - (row % 3);
        int startingCol = col - (col % 3);
        // 2 👇🏻
        // int startingRow = 3 * (row/3);
        // int startingCol = 3 * (col/3);
        for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingCol; j < startingCol + 3; j++) {
                if(board[i][j] == number)
                    return true;
            }
        }
        return false;
    }

    // To check if it is valid to place the number
    static boolean isValidPlacement(int[][] board, int row, int col, int number){
        return !isNumInRow(board, row, number) && !isNumInCol(board, col, number) && !isNumInGrid(board, row, col, number);
    }

    // Driver Code
    static boolean solveBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if(board[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry <= 9; numberToTry++) {
                        if(isValidPlacement(board, row, col, numberToTry)) {
                            board[row][col] = numberToTry;
                            if(solveBoard(board))
                                return true;
                            else
                                board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}