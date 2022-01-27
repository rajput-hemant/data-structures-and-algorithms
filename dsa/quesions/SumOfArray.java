package quesions;

import java.util.Scanner;

/*
Write a program to find and return the sum of all elements of the array. Do this recursively.

Sample Input 1 :
3
9 8 9
Sample Output 1 :
26
Sample Input 2 :
3
4 2 1
Sample Output 2 :
7 
*/

public class SumOfArray {
    static int arraySum(int arr[], int n) {
        if (n <= 0)
            return 0;
        return arr[n-1] + arraySum(arr, n-1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println(arraySum(arr,n));
    }
}