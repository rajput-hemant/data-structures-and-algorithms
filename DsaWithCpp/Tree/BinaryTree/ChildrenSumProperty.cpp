#include <iostream>
#include "Node.cpp"
#include "TreeBuilder.cpp"
using namespace std;

static bool isChildSum(Node *root)
{
    if (root == NULL || root->left == NULL && root->right == NULL)
        return true;
    int sum = root->left->data + root->right->data;
    return root->data == sum && isChildSum(root->left) && isChildSum(root->right);
}

// int main()
// {
//     int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//     Node *root = buildTree(nodes);
//     printf("Follows Children Sum Property -> %s", isChildSum(root) ? "true\n" : "false\n");
// }
