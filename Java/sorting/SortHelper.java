package sorting;

import java.util.Scanner;

public class SortHelper {
    static Scanner sc = new Scanner(System.in);

    // A Utility Fn to take input in an array
    public static int[] takeInput() {
        System.out.print("Enter the length of the Array -> ");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.print("Enter the elements -> ");
        for (int i = 0; i < len; i++)
            arr[i] = sc.nextInt();
        return arr;
    }

    // A Utility Fn to take input for sort options
    public static int sort() {
        System.out.print("1 for Ascending\n" +
                "2 for Descending\n" +
                "Choose -> ");
        int sort = sc.nextInt();
        return sort;
    }

    // A Utility Fn to print the Sorted Array
    public static void printSortedArray(int[] arr) {
        System.out.print("Array after sorting -> [");
        for (int i : arr)
            System.out.print(i + ", ");
        System.out.println("\b\b]");
    }
}
