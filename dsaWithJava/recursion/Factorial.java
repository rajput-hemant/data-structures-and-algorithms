package recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Range for Factorial -> ");
        int n = sc.nextInt();
        System.out.print("Factorial -> " + fact(n));
        sc.close();
    }
    static int fact(int n) {
        // base case
        if(n == 1 || n == 0) 
            return 1;
        return n * fact(n-1);
    }
}
