#include <iostream>
#include "Node.cpp"
#include "TreeBuilder.cpp"
using namespace std;

int height(Node *root)
{
    if (root == NULL)
        return 0;
    else
        return max(height(root->left), height(root->right)) + 1;
}

// int main()
// {
//     int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//     Node *root = buildTree(nodes);
//     cout << height(root) << endl;
// }