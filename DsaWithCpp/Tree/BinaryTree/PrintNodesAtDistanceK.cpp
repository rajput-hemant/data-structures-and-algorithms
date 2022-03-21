#include <iostream>
#include "Node.cpp"
#include "TreeBuilder.cpp"
using namespace std;

void printAtK(Node *root, int k)
{
    if (root == NULL)
        return;
    if (k == 0)
    {
        cout << root->data << endl;
        return;
    }
    printAtK(root->left, k - 1);
    printAtK(root->right, k - 1);
}

int main()
{
    int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    Node *root = buildTree(nodes);
    printAtK(root, 2);
}