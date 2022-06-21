#include <iostream>
using namespace std;

bool isSorted(int arr[], int i, int n, int choice);

int main()
{
    int n, choice;
    cout << "Enter the length of the Array -> ";
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    cout << "In which order do you want to check if Array is sorted or not?\n1 for Ascending\n2 for Descending\n-> ";
    cin >> choice;
    printf("Is Array Sorted? -> %s", isSorted(arr, 0, n, choice) ? "true" : "false");
}

bool isSorted(int arr[], int i, int n, int choice)
{
    if (i == n - 1)
        return true;
    if (choice == 1)
    {
        if (arr[i] < arr[i + 1])
            return isSorted(arr, i + 1, n, choice);
        else
            return false;
    }
    else
    {
        if (arr[i] > arr[i + 1])
            return isSorted(arr, i + 1, n, choice);
        else
            return false;
    }
}