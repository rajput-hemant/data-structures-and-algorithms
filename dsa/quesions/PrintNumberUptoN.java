package quesions;

import java.util.Scanner;

/*Write a program to print numbers from 1 to n in increasing order recursively.

Sample Input 1 :
 6
Sample Output 1 :
1 2 3 4 5 6
*/

public class PrintNumberUptoN {
    static void func(int n) {
        if (n == 0) 
            return;
        func(n-1);
        System.out.print(n+" ");
         }
    public static void main(String[] args) {
        System.out.print("Enter the value of N - ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        func(n);
    }
}
