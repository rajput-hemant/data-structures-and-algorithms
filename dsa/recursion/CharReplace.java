package recursion;

import java.util.Scanner;

/*
Given an input string S and two characters char1 and char2, you need to replace every occurrence of character c1 with character c2 in the given string. Do this recursively.

Sample Input :
abaca
a x
Sample Output :
xbxcd
*/

public class CharReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string -> ");
        String str = sc.next();
        System.out.print("Enter the two characters you want to replace and repalce with respectively -> ");
        char char1 = sc.next().charAt(0);
        char char2 = sc.next().charAt(0);
        sc.close();
        System.out.print("String after replacing '" + char1 + "' with '" + char2 + "' -> ");
        charReplace(str, 0, char1, char2, "");
    }
    static void charReplace(String str, int i, char o, char n, String newStr) {
        // base case
        if(str.length() == i){
            System.out.print(newStr + " ");
            return;
        }
        if(str.charAt(i) == o)
            newStr += n;
        else
            newStr += str.charAt(i);
        charReplace(str, i+1, o, n, newStr);
    }
}
