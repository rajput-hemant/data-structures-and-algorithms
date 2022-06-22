package recursion;

import java.util.Scanner;

/*
In a string S, remove consecutive duplicates from it recursively.

Sample Input 1 :
aabccba
Sample Output 1 :
abcba
*/

public class RemoveChar {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the String -> ");
            String str = sc.next();
            sc.close();
            System.out.print("String after removing consecutive duplicate elements -> ");
            removeChar(str, 0, "");
    }
    static void removeChar(String str, int i, String newStr) {
        // base case
        if(i == str.length()-1) {
            newStr += str.charAt(i);
            System.out.print(newStr + " ");
            return;
        }
        if(str.charAt(i) != str.charAt(i+1))
            newStr += str.charAt(i);
        removeChar(str, i+1, newStr);
    }
}
