package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.TreeSet;

public class ClosestGreaterAndLargestSmaller {
    public static void largestSmaller(int[] arr, int choice) {
        int n = arr.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        ArrayList<Integer> floors = new ArrayList<>();
        // In Left Side
        if (choice == 1) {
            for (int i = 0; i < n; i++) {
                Integer smaller = treeSet.floor(arr[i]);
                if (smaller == null)
                    floors.add(-1);
                else
                    floors.add(smaller);
                treeSet.add(arr[i]);
            }
            for (Integer floor : floors)
                System.out.print(floor + " ");
        }
        // In Right Side
        else if (choice == 2) {
            for (int i = n - 1; i >= 0; i--) {
                Integer smaller = treeSet.floor(arr[i]);
                if (smaller == null)
                    floors.add(-1);
                else
                    floors.add(smaller);
                treeSet.add(arr[i]);
            }
            for (int i = n - 1; i >= 0; i--)
                System.out.print(floors.get(i) + " ");
        }
        System.out.println();
    }

    public static void closestGreater(int[] arr, int choice) {
        int n = arr.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        ArrayList<Integer> ceilings = new ArrayList<>();
        // In Left Side
        if (choice == 1) {
            for (int i = 0; i < n; i++) {
                Integer greater = treeSet.ceiling(arr[i]);
                if (greater == null)
                    ceilings.add(-1);
                else
                    ceilings.add(greater);
                treeSet.add(arr[i]);
            }
            for (Integer ceil : ceilings)
                System.out.print(ceil + " ");
        }
        // In Right Side
        else if (choice == 2) {
            for (int i = n - 1; i >= 0; i--) {
                Integer greater = treeSet.ceiling(arr[i]);
                if (greater == null)
                    ceilings.add(-1);
                else
                    ceilings.add(greater);
                treeSet.add(arr[i]);
            }
            for (int i = n - 1; i >= 0; i--)
                System.out.print(ceilings.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 8, 3, 4, 9 };
        closestGreater(arr, 1);
        closestGreater(arr, 2);
        largestSmaller(arr, 1);
        largestSmaller(arr, 2);
    }
}
