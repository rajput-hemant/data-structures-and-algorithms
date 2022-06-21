#include <iostream>
#include "Node.cpp"
#include "TreeTraversals.cpp"
using namespace std;

static int getMax(Node *root)
{
    if (root == NULL)
        return INT16_MIN;
    return max(root->data, max(getMax(root->left), getMax(root->right)));
}

// int main()
// {
//     int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//     Node *root = buildTree(nodes);
//     cout << getMax(root) << endl;
// }