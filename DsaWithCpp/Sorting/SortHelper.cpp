#include <iostream>
#include <vector>
using namespace std;

static void takeInput(vector<int> &arr)
{
    int len;
    cout << "Enter the length of the Array -> ";
    cin >> len;
    cout << "Enter the Elements -> ";
    for (int i = 0; i < len; i++)
    {
        int temp;
        cin >> temp;
        arr.push_back(temp);
    }
}

static int sort()
{
    cout << "1 for Ascending\n"
         << "2 for Descending\n"
         << "Choose -> ";
    int sort;
    cin >> sort;
    return sort;
}

static void printSortedArray(vector<int> arr)
{
    cout << "Array after sorting -> [ ";
    for (int i = 0; i < arr.size(); i++)
        cout << arr[i] << ", ";
    cout << "\b\b ]" << endl;
}
