#include <iostream>
#include "Node.cpp"
using namespace std;

/**
-> It is a BST (For every node, left subtree is smaller & right subtree is
greater)
-> It is Balanced (For every node, differerce b/w left & right heights <= 1)
Balance Factor: |leftHeight - rightHeight| <= 1
*/
class AVL
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
        else
            return root;
        root->height = height(root);
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1 && data < root->left->data)
            return rightRotate(root);
        if (balanceFactor < -1 && data > root->right->data)
            return leftRotate(root);
        if (balanceFactor > 1 && data > root->left->data)
        {
            root->left = leftRotate(root->left);
            return rightRotate(root);
        }
        if (balanceFactor < -1 && data < root->right->data)
        {
            root->right = rightRotate(root->right);
            return leftRotate(root);
        }
        return root;
    }

    Node *remove(Node *root, int data)
    {
        if (root == NULL)
            return root;
        if (root->data > data)
            root->left = remove(root->left, data);
        else if (root->data < data)
            root->right = remove(root->right, data);
        else
        {
            if (root->left == NULL || root->right == NULL)
            {
                Node *temp = NULL;
                if (temp == root->left)
                    temp = root->right;
                else
                    temp = root->left;
                if (temp == NULL)
                {
                    temp = root;
                    root = NULL;
                }
                else
                    root = temp;
            }
            else
            {
                Node *temp = getSuccessor(root);
                root->data = temp->data;
                root->right = remove(root->right, temp->data);
            }
        }
        if (root == NULL)
            return root;
        root->height = height(root);
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1 && getBalanceFactor(root->left) >= 0)
            return rightRotate(root);
        if (balanceFactor < -1 && getBalanceFactor(root->right) <= 0)
            return leftRotate(root);
        if (balanceFactor > 1 && getBalanceFactor(root->left) < 0)
        {
            root->left = leftRotate(root->left);
            return rightRotate(root);
        }
        if (balanceFactor < -1 && getBalanceFactor(root->right) > 0)
        {
            root->right = rightRotate(root->right);
            return leftRotate(root);
        }
        return root;
    }

    Node *getSuccessor(Node *root)
    {
        Node *currentNode = root->right;
        while (currentNode->left != NULL)
            currentNode = currentNode->left;
        return currentNode;
    }

    int height(Node *root)
    {
        if (root == NULL)
            return 0;
        else
            return max(height(root->left), height(root->right)) + 1;
    }

    int getBalanceFactor(Node *root)
    {
        if (root == NULL)
            return 0;
        return height(root->left) - height(root->right);
    }

    Node *leftRotate(Node *root)
    {
        Node *rightNode = root->right;
        Node *b = rightNode->left;
        rightNode->left = root;
        root->right = b;
        root->height = height(root);
        rightNode->height = height(rightNode);
        return rightNode;
    }

    Node *rightRotate(Node *root)
    {
        Node *leftNode = root->left;
        Node *b = leftNode->right;
        leftNode->right = root;
        root->left = b;
        root->height = height(root);
        leftNode->height = height(leftNode);
        return leftNode;
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
        cout << root->data << " ";
        display(root->left);
        display(root->right);
    }
};
