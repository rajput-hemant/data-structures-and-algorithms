/*
Given an input string S and two characters char1 and char2, you need to replace every occurrence of character c1 with character c2 in the given string. Do this recursively.

Sample Input :
abaca
a x
Sample Output :
xbxcd
*/

#include <iostream>
using namespace std;

void charReplace(string str, int i, char a, char b, string newStr);

int main()
{
    string str, newStr;
    char a, b;
    int i;
    cout << "Enter the String -> ";
    cin >> str;
    cout << "Enter the two Characters -> ";
    cin >> a >> b;
    printf("String after replacing '%c' with '%c' -> ", a, b);
    charReplace(str, 0, a, b, newStr);
};

void charReplace(string str, int i, char a, char b, string newStr)
{
    if (str.length() == i)
    {
        cout << newStr << "\n";
        return;
    };
    if (str.at(i) == a)
        newStr += b;
    else
        newStr += str.at(i);
    charReplace(str, i + 1, a, b, newStr);
};
