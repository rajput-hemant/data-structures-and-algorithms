#include <iostream>
#include <queue>
#include "Node.cpp"
#include "TreeBuilder.cpp"
using namespace std;

class Traversals
{
public:
    static void preOrder(Node *root)
    {
        if (root == NULL)
        {
            cout << -1 << " ";
            return;
        }
        cout << root->data << " ";
        preOrder(root->left);
        preOrder(root->right);
    }

    static void inOrder(Node *root)
    {
        if (root == NULL)
        {
            cout << -1 << " ";
            return;
        }
        inOrder(root->left);
        cout << root->data << " ";
        inOrder(root->right);
    }

    static void postOrder(Node *root)
    {
        if (root == NULL)
        {
            cout << -1 << " ";
            return;
        }
        postOrder(root->left);
        postOrder(root->right);
        cout << root->data << " ";
    }

    static void levelOrder(Node *root)
    {
        if (root == NULL)
            return;
        queue<Node *> q;
        q.push(root);
        while (!q.empty())
        {
            Node *currentNode = q.front();
            q.pop();
            cout << currentNode->data << " ";
            if (currentNode->left != NULL)
                q.push(currentNode->left);
            if (currentNode->right != NULL)
                q.push(currentNode->right);
        }
    }
};

// int main()
// {
//     Traversals ob;
//     int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//     Node *root = buildTree(nodes);
//     ob.preOrder(root);
//     cout << endl;
//     ob.inOrder(root);
//     cout << endl;
//     ob.postOrder(root);
//     cout << endl;
//     ob.levelOrder(root);
//     return 0;
// }