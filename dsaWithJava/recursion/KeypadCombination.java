package recursion;

import java.util.Scanner;

public class KeypadCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Digits -> ");
        String str = sc.next();
        keyCombination(str, 0, "");
        sc.close();
    }
    static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    // Time Complexity -> O(4^n)
    static void keyCombination(String str, int i, String combination) {
        // base case
        if(str.length() == i) {
            System.out.print(combination + "");
            return;
        }
        String map = keypad[str.charAt(i) -'0'];
        for(int j = 0; j < map.length(); j++)
            keyCombination(str, i+1, combination+map.charAt(j));
    }
}
