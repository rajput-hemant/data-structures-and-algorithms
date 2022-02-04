package recursion;

import java.util.Scanner;

public class StringPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String -> ");
        String str = sc.next();
        System.out.print("All possibel permutaion of '" + str + "' are -> ");
        stringPermutation(str, "");
        sc.close();
    }
    // Time Comlexity -> (n!)
    static void stringPermutation(String str, String perm) {
        // base case
        if(str.length() == 0) {
            System.out.print(perm + " ");
        }
        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i+1);
            stringPermutation(newStr, perm+str.charAt(i));
        }
    }
}