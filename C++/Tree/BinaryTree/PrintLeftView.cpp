#include <iostream>
#include "Node.cpp"
#include "TreeBuilder.cpp"
using namespace std;

// private:
int maxLevel = 0;
static void printLeftView(Node *root, int level)
{
    if (root == NULL)
        return;
    if (maxLevel < level)
    {
        cout << root->data << " ";
        maxLevel = level;
    }
    printLeftView(root->left, level + 1);
    printLeftView(root->right, level + 1);
}

static void printLeftView(Node *root)
{
    printLeftView(root, 1);
}

int main()
{
    int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    Node *root = buildTree(nodes);
    printLeftView(root);
}