package recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the range for Fibonacci Series -> ");
        int n = sc.nextInt();
        int a = 0, b = 1;
        System.out.print("Fibonacci Series -> 0 1 ");
        fibonacci(a, b, n-2);
        sc.close();
    }

    static void fibonacci(int a, int b, int n) {
        // base class
        if (n == 0)
            return;
        System.out.print(a + b + " ");
        fibonacci(b, a+b, n-1);
    }
}

class Fibonacci2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the range for Fibonacci Series -> ");
        int n = sc.nextInt();
        System.out.print("Fibonacci Series -> ");
        fibonacci2(n , 0, 1);
        sc.close();
    }
    static void fibonacci2 (int n, long a, long b) {
        if(n < 1)
            return;
        System.out.print(a + " ");
        fibonacci2(n-1, b, a+b);
    }
}

