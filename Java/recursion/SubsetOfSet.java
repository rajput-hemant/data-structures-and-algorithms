package recursion;

import java.util.*;

// Subset of set of n natural numbers

public class SubsetOfSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> subset = new ArrayList<>();
        System.out.print("Enter the value of n -> ");
        int n = sc.nextInt();
        findSubset(n, subset);
        sc.close();
    }
    // Time Complexity -> O(2^n)
    static void findSubset(int n, ArrayList<Integer> subset) {
        // base case
        if(n == 0) {
            printSubset(subset);
            return;
        }
        // if element is added
        subset.add(n);
        findSubset(n-1, subset);
        // if element isn't added
        subset.remove(subset.size()-1); // to remove already added subset by earlier recursion fn call
        findSubset(n-1, subset);
    }
    static void printSubset(ArrayList<Integer> subset) {
        for (Integer i : subset)
            System.out.print(i + " ");
        System.out.println();;
    }
}
