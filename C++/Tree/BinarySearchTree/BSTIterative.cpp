#include <iostream>
#include <stack>
#include "Node.cpp"
using namespace std;

class BSTIterative
{
public:
    Node *root = NULL;
    void insert(int data)
    {
        root = insert(root, data);
    }

    bool search(int data)
    {
        return search(root, data);
    }

    void remove(int data)
    {
        root = remove(root, data);
    }

    void display()
    {
        display(root);
    }

private:
    Node *insert(Node *root, int x)
    {
        Node *newNode = new Node(x);
        Node *parentNode = NULL, *currentNode = root;
        while (currentNode != NULL)
        {
            parentNode = currentNode;
            if (currentNode->data > x)
                currentNode = currentNode->left;
            else if (currentNode->data < x)
                currentNode = currentNode->right;
            else
                return root;
        }
        if (parentNode == NULL)
            return newNode;
        if (parentNode->data > x)
            parentNode->left = newNode;
        else
            parentNode->right = newNode;
        return root;
    }

    Node *remove(Node *root, int x)
    {
        if (root == NULL)
            return NULL;
        Node *currentNode = root, *parentNode = NULL;
        while (currentNode != NULL && currentNode->data != x)
        {
            parentNode = currentNode;
            if (currentNode->data > x)
                currentNode = currentNode->left;
            else
                currentNode = currentNode->right;
        }
        if (currentNode == NULL)
            return root;
        if (currentNode->left == NULL || currentNode->right == NULL)
        {
            Node *newNode;
            if (currentNode->left == NULL)
                newNode = currentNode->right;
            else
                newNode = currentNode->left;
            if (parentNode == NULL)
                return newNode;
            if (currentNode == parentNode->left)
                parentNode->left = newNode;
            else
                parentNode->right = newNode;
        }
        else
        {
            Node *inOrderParent = NULL, *successor = currentNode->right;
            while (successor->left != NULL)
            {
                inOrderParent = successor;
                successor = successor->left;
            }
            if (inOrderParent != NULL)
                inOrderParent->left = successor->right;
            else
                currentNode->right = successor->right;
            currentNode->data = successor->data;
        }
        return root;
    }

    bool search(Node *root, int x)
    {
        while (root != NULL)
        {
            if (root->data == x)
                return true;
            else if (root->data > x)
                root = root->left;
            else
                root = root->right;
        }
        return false;
    }

    void display(Node *root)
    {
        stack<Node *> stk;
        Node *currentNode = root;
        cout << "[";
        while (currentNode != NULL || stk.empty() == false)
        {
            while (currentNode != NULL)
            {
                stk.push(currentNode);
                currentNode = currentNode->left;
            }
            currentNode = stk.top();
            stk.pop();
            cout << currentNode->data << ", ";
            currentNode = currentNode->right;
        }
        cout << "\b\b]\n";
    }
};