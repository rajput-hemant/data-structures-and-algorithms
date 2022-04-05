#include <iostream>
#include <stack>
#include "Node.cpp"
using namespace std;

class BSTIterative
{
    Node *root = NULL;

public:
    void insert(int data)
    {
        root = insert(root, data);
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