#include <iostream>
#include <climits>
#include "Node.cpp"
using namespace std;

bool validBST(Node *root, long min, long max)
{
    if (root == NULL)
        return true;
    if (root->data <= min || root->data >= max)
        return false;
    return (validBST(root->left, min, root->data) &&
            validBST(root->right, root->data, max));
}

bool isBST(Node *root)
{
    return validBST(root, LONG_MIN, LONG_MAX);
}
/*
int previous = INT_MIN;

bool isBST(Node *root)
{
    if (root == NULL)
        return true;
    if (isBST(root->left) == false)
        return false;
    if (root->data <= previous)
        return false;
    previous = root->data;
    return isBST(root->right);
}
*/
