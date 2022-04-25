#include <iostream>
#include <vector>
#include "Node.cpp"
using namespace std;

vector<int> isPair(Node *root, vector<int> list, int sum)
{
    if (root != NULL)
    {
        isPair(root->left, list, sum);
        list.push_back(root->data);
        isPair(root->right, list, sum);
    }
    return list;
}

bool isPairSum(Node *root, int sum)
{
    vector<int> list;
    list = isPair(root, list, sum);
    int head = 0, tail = list.size() - 1;
    while (head < tail)
    {
        if (list[0] + list[tail] == sum)
            return true;
        if (list[0] + list[tail] < sum)
            head++;
        else if (list[0] + list[tail] < sum)
            tail++;
    }
    return false;
}
