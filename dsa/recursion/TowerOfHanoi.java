package recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Height of Tower of Hanoi -> ");
        int n = sc.nextInt();
        // towerOfHanoi(n, "Source", "Helper", "Destination");
        towerOfHanoi(n, "A", "B", "C");
        sc.close();
    }
    // Time Complexity -> O((2^n)-1)
    static void towerOfHanoi(int n, String src, String helper, String dest) {
        // base case
        if(n == 0)
            return;
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Transfer Disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n-1, helper, src, dest);
    }
}
