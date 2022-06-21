#include <iostream>
#include <queue>
#include "Node.cpp"
#include "TreeBuilder.cpp"
using namespace std;

static int maxWidth(Node *root)
{
    if (root == NULL)
        return 0;
    queue<Node *> q;
    q.push(root);
    int width = 0;
    while (!q.empty())
    {
        int flag = q.size();
        width = max(width, flag);
        for (int i = 0; i < flag; i++)
        {
            Node *currentNode = q.front();
            q.pop();
            if (currentNode->left != NULL)
                q.push(currentNode->left);
            if (currentNode->right != NULL)
                q.push(currentNode->right);
        }
    }
    return width;
}

int main()
{
    int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    Node *root = buildTree(nodes);
    cout << "Max Width of Binary Tree is -> " << maxWidth(root) << endl;
}
