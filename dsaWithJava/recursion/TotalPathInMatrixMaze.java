package recursion;

import java.util.Scanner;

// In this problem, you can either go down or move right in the matrix

public class TotalPathInMatrixMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rows and columns of the Maze Matrix -> ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.print("Total paths - > " + countPaths(0, 0, m, n));
        sc.close();
    }
    static int countPaths(int i, int j, int m, int n) {
        // base classes
        if(i == m || j == n)
            return 0;
        if(i == m-1 && j == n-1)
            return 1;
        // for moving downwards
        int downPaths = countPaths(i+1, j, m, n);
        // for moving right
        int rightPaths = countPaths(i, j+1, m, n);
        return downPaths + rightPaths;
    }
}