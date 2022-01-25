package quesions;

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

public class PowerRecursion {
    static int power(int x, int n) {
         if (n == 0)
            return 1;
        else
            return x * power(x, n-1);
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of X and N (x^n)= ");
        int x = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        System.out.println(power(x, n));   
    }
}
