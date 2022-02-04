package recursion;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String -> ");
        String str = sc.next();
        System.out.print("Reversed String -> ");
        revString(str, str.length()-1);
        sc.close();
    }
    // Time Complexity -> O(n)
    static void revString(String str, int i) {
        // base case
        if(i == 0) {
            System.out.print(str.charAt(i));
            return;
        }
        System.out.print(str.charAt(i));
        revString(str, i-1);
    }
}
