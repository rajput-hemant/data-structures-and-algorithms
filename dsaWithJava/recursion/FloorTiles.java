package recursion;

import java.util.Scanner;

// Tiles of 1*m in a floor of size n*m

public class FloorTiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the floor i.e. (m*n) -> ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.print("Total ways to place tiles -> " + placeTiles(m, n));
        sc.close();
    }
    static int placeTiles(int m, int n) {
        // base cases
        if(m == n)
            return 2;
        if (m < n)
            return 1;
        // placing tiles vertically
        int verPlacements = placeTiles(m-n, n);
        // placing tiles horizontally
        int horPlacements = placeTiles(m-1, n);
        return horPlacements + verPlacements;
    }
}
