#include <iostream>
#include <stack>
#include "Node.cpp"
#include "TreeBuilder.cpp"
using namespace std;

static void spiralTraversal(Node *root)
{
    if (root == NULL)
        return;
    stack<Node *> stk1, stk2;
    stk1.push(root);
    while (!stk1.empty() || !stk2.empty())
    {
        while (!stk1.empty())
        {
            Node *currentNode = stk1.top();
            stk1.pop();
            cout << currentNode->data << " ";
            if (currentNode->left != NULL)
                stk2.push(currentNode->left);
            if (currentNode->right != NULL)
                stk2.push(currentNode->right);
        }
        cout << endl;
        while (!stk2.empty())
        {
            Node *currentNode = stk2.top();
            stk2.pop();
            cout << currentNode->data << " ";
            if (currentNode->right != NULL)
                stk1.push(currentNode->right);
            if (currentNode->left != NULL)
                stk1.push(currentNode->left);
        }
        cout << endl;
    }
}

// int main()
// {
//     int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//     Node *root = buildTree(nodes);
//     spiralTraversal(root);
// }
