package quesions;

/*
Write a program to find out and return the number of digits present in a number recursively.

Sample Input 1 :
 156
Sample Output 1 :
3
Sample Input 2 :
 7
Sample Output 2 :
1
*/

import java.util.Scanner;

public class NumberOfDigits {
    static int res = 0;
    static int func(int n) {
        if (n != 0) {
            res++;
            return func(n/10);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value-");
        int n = sc.nextInt();
        sc.close();
        System.out.println(func(n));
    }
}
