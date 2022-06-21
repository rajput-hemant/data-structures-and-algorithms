#include <iostream>
// #include "Node.cpp"
// #include "TreeBuilder.cpp"
// already included in HeightOfTree.cpp
#include "HeightOfTree.cpp"
using namespace std;

// Naive Approach
// Time Complexity -> O(n^2)
// static bool isBalancedTree(Node *root)
// {
//     if (root == NULL)
//         return true;
//     int leftHeight = height(root->left);
//     int rightHeight = height(root->right);
//     return abs(leftHeight - rightHeight) <= 1 && isBalancedTree(root->left) && isBalancedTree(root->right);
// }

// Time Complexity -> O(n)
static int isBalTree(Node *root)
{
    if (root == NULL)
        return 0;
    int leftHeight = isBalTree(root->left);
    if (leftHeight == -1)
        return -1;
    int rightHeight = isBalTree(root->right);
    if (rightHeight == -1)
        return -1;
    if (abs(leftHeight - rightHeight) > 1)
        return -1;
    else
        return max(leftHeight, rightHeight) + 1;
}

static bool isBalancedTree(Node *root)
{
    return !(isBalTree(root) == -1);
}

int main()
{
    int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 8, -1, -1, 9, -1, -1};
    Node *root = buildTree(nodes);
    printf("Is Balanced Tree -> %s", isBalancedTree(root) ? "true\n" : "false\n");
}