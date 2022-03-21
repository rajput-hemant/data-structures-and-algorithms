#include <iostream>
#include "Node.cpp"
#include "TreeBuilder.cpp"
using namespace std;

static int countNode(Node *root)
{
    if (root == NULL)
        return 0;
    return countNode(root->left) + countNode(root->right) + 1;
}

// int main()
// {
//     int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//     Node *root = buildTree(nodes);
//     cout << countNode(root) << endl;
// }