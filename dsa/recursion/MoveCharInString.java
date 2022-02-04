package recursion;

import java.util.Scanner;

public class MoveCharInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string -> ");
        String str = sc.next();
        System.out.print("Enter the Character to move at the end of the String -> ");
        char c = sc.next().charAt(0);
        String newStr = "";
        System.out.print("String after moving all '" + c + "'s at the end of the String -> ");
        move(str, 0, c, 0, newStr);
        sc.close();
    }
    // Time Complexity -> O(n)
    static void move(String str, int i, char c, int count, String newStr) {
        // base case
        if(i > str.length()-1) {
            for (int j = 0; j < count; j++) 
                newStr += c;
            System.out.println(newStr);
            return;
        }
        if(str.charAt(i) == c) {
            count++;
            move(str, i+1, c, count, newStr);
        }
        else {
            newStr += str.charAt(i);
            move(str, i+1, c, count, newStr);
        }
    }
}
