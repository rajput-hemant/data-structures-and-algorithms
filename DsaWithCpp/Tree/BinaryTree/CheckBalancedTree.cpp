#include <iostream>
// #include "Node.cpp"
// #include "TreeBuilder.cpp"  
// already included in HeightOfTree.cpp
#include "HeightOfTree.cpp"
using namespace std;

static bool isBalancedTree(Node *root)
{
    if (root == NULL)
        return true;
    int leftHeight = height(root->left);
    int rightHeight = height(root->right);
    return abs(leftHeight - rightHeight) <= 1 && isBalancedTree(root->left) && isBalancedTree(root->right);
}

int main()
{
    int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 8, -1, -1, 9, -1, -1};
    Node *root = buildTree(nodes);
    printf("Is Balanced Tree -> %s", isBalancedTree(root) ? "true\n" : "false\n");
}