#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Triplet
{
    int ele, arrPos, elePos;
    Triplet(int element, int arrPosition, int elePosition)
    {
        ele = element;
        arrPos = arrPosition;
        elePos = elePosition;
    }
};

struct Comparator
{
    bool operator()(Triplet st1, Triplet st2)
    {
        return st1.ele > st2.ele;
    }
};

vector<int> mergeArrays(vector<vector<int>> &arr)
{
    vector<int> res;
    priority_queue<Triplet, vector<Triplet>, Comparator> pq;
    for (int i = 0; i < arr.size(); i++)
    {
        Triplet t(arr[i][0], i, 0);
        pq.push(t);
    }
    while (!pq.empty())
    {
        Triplet curr = pq.top();
        pq.pop();
        res.push_back(curr.ele);
        int arrPos = curr.arrPos, elePos = curr.elePos;
        if (elePos + 1 < arr[arrPos].size())
        {
            Triplet t(arr[arrPos][elePos + 1], arrPos, elePos + 1);
            pq.push(t);
        }
    }
    return res;
}

// int main()
// {
//     vector<vector<int>> arr = {
//         {5, 10},
//         {4, 9},
//         {5, 6},
//     };
//     for (auto i : mergeArrays(arr))
//         cout << i << " ";
//     cout << endl;
// }
