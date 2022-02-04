package recursion;

/*
Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.
Do this recursively.
Input format :
Two integers x and n (separated by space)
Output Format :
x^n (i.e. x raise to the power n)
Sample Input 1 :
3 4
Sample Output 1 :
81
*/

import java.util.Scanner;

public class PowerFn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the values for X and N i.e x^n -> ");
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.print(power(x, n));
        // System.out.print(x + " raise to the power " + n + " is -> " + power(x, n));
        sc.close();
    }
    // This recursion function of power has Stack Height -> n
    static int power(int x, int n) {
        // base classes
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        return x * power(x, n-1);
    }
    // This recursion function of power has Stack Height -> logn
    static int power2(int x, int n) {
        // base classes
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        if(n % 2 == 0) // if n is even
            return power2(x, n/2) * power2(x, n/2);
        else // if n is odd
            return x * power2(x, n/2) * power2(x, n/2);
    }
}
