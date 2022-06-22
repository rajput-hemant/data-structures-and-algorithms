package recursion;

import java.util.Scanner;

public class RemDupliChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String -> ");
        String str = sc.next();
        String newStr = "";
        System.out.print("String after removing all duplicates elemants -> ");
        remDupliChar(str, 0, newStr);
        sc.close();
    }
    // Time Complexity -> O(n)
    static boolean[] map = new boolean[26];
    static void remDupliChar(String str, int i, String newStr) {
        // base case
        if(i == str.length()) {
            System.out.print(newStr);
            return;
        }
        if(map[str.charAt(i) - 'a'])
            remDupliChar(str, i+1, newStr);
        else {
            newStr += str.charAt(i);
            map[str.charAt(i) - 'a'] = true;
            remDupliChar(str, i+1, newStr);
        }
    }
}
