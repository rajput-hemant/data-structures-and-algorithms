#include <iostream>
#include "Node.cpp"
using namespace std;

class BSTRecursive
{
public:
    Node *root = NULL;

    void insert(int data)
    {
        root = insert(root, data);
    }

    void remove(int data)
    {
        root = remove(root, data);
    }

    bool search(int data)
    {
        return search(root, data);
    }

    void display()
    {
        display(root);
        cout << endl;
    }

private:
    Node *insert(Node *root, int data)
    {
        if (root == NULL)
            return new Node(data);
        if (root->data > data)
            root->left = insert(root->left, data);
        else if (root->data < data)
            root->right = insert(root->right, data);
        return root;
    }

    Node *remove(Node *root, int data)
    {
        if (root == NULL)
            return NULL;
        if (root->data > data)
            root->left = remove(root->left, data);
        else if (root->data < data)
            root->right = remove(root->right, data);
        else
        {
            if (root->left == NULL)
                return root->right;
            else if (root->right == NULL)
                return root->left;
            root->data = getSuccessor(root);
            root->right = remove(root->right, root->data);
        }
        return root;
    }
    int getSuccessor(Node *root)
    {
        Node *currentNode = root->right;
        while (currentNode != NULL && currentNode->left != NULL)
            currentNode = currentNode->left;
        return currentNode->data;
    }

    bool search(Node *root, int data)
    {
        if (root == NULL)
            return false;
        if (root->data == data)
            return true;
        if (root->data > data)
            return search(root->left, data);
        else
            return search(root->right, data);
    }

    void display(Node *root)
    {
        if (root == NULL)
            return;
        display(root->left);
        cout << root->data << " ";
        display(root->right);
    }
};
