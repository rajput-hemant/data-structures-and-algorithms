#include <iostream>
using namespace std;

int first = -1, last = -1;

void findFirstAndLastOccurance(string str, int i, char ch);

int main()
{
    string str;
    char ch;
    cout << "Enter the String -> ";
    cin >> str;
    cout << "Enter the Character you want to track -> ";
    cin >> ch;
    findFirstAndLastOccurance(str, 0, ch);
}
void findFirstAndLastOccurance(string str, int i, char ch)
{
    if (i == str.length() - 1)
    {
        printf("First & Last Occurance of character %c are %d and %d respectively.", ch, first, last);
        return;
    }
    if (ch == str.at(i))
    {
        if (first == -1)
            first = last = i;
        else
            last = i;
    }
    findFirstAndLastOccurance(str, i + 1, ch);
}