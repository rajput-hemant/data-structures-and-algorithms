package recursion;

import java.util.Scanner;

public class CheckSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the Array -> ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements in the Array -> ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.print("In which oreder do you want to check if Array is sorted or not?\n" +
                            "1 for Ascending\n" +
                            "2 for Descending\n-> ");
        int choice = sc.nextInt();
        System.out.print("Array Sort is -> " + isSorted(arr, 0, choice));
        sc.close();
    }
    // Time Complexity -> O(n )
    static boolean isSorted(int arr[], int i, int choice) {
        // base case
        if(i == arr.length-1)
            return true;
        // For Strictly Ascending 
        if(choice == 1) {
            if(arr[i] < arr[i+1])
                return isSorted(arr, i+1, choice);
            else return false;
        }
        // For Strictly Descending 
        else {
            if(arr[i] > arr[i+1])
                return isSorted(arr, i+1, choice);
            else return false;
        }
    }
}
