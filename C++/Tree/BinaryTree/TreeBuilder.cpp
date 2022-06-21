#include <iostream>
// #include "Node.cpp"
using namespace std;

int idx = -1;
Node *buildTree(int nodes[])
{
    idx++;
    if (nodes[idx] == -1)
        return NULL;
    Node *newNode = new Node(nodes[idx]);
    newNode->left = buildTree(nodes);
    newNode->right = buildTree(nodes);
    return newNode;
}

// int main()
// {
//     int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//     Node* root = buildTree(nodes);
//     cout << root->data << endl;
//     return 0;
// }
