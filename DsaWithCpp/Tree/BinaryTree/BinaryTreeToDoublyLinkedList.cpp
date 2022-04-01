#include <iostream>
#include "Node.cpp"
#include "TreeBuilder.cpp"
using namespace std;

Node *prevNode = NULL;
Node *convertBinaryTreeToDoublyLinkedList(Node *root)
{
    if (root == NULL)
        return root;
    Node *head = convertBinaryTreeToDoublyLinkedList(root->left);
    if (prevNode == NULL)
        head = root;
    else
    {
        root->left = prevNode;
        prevNode->right = root;
    }
    prevNode = root;
    convertBinaryTreeToDoublyLinkedList(root->right);
    return head;
}

void display(Node *root)
{
    if (root == NULL)
    {
        cout << "List is Empty!";
        return;
    }
    cout << "[";
    for (Node *currentNode = root; currentNode != NULL; currentNode = currentNode->right)
        cout << currentNode->data << ", ";
    cout << "\b\b]\n";
}

int main()
{
    int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 8, -1, -1, 9, -1, -1};
    // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    Node *root = buildTree(nodes);
    Node *newNode = convertBinaryTreeToDoublyLinkedList(root);
    display(newNode);
}
