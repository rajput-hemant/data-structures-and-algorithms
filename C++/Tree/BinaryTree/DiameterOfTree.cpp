#include <iostream>
// #include "Node.cpp"
// #include "TreeBuilder.cpp"
// aleady included in HeightOfTree.cpp
#include "HeightOfTree.cpp"
using namespace std;

// Approach 1
// Time Complexity -> O(n^2)
static int diameterOfTree2(Node *root)
{
    if (root == NULL)
        return 0;
    int dia1 = diameterOfTree(root->left);
    int dia2 = diameterOfTree(root->right);
    int dia3 = height(root->left) + height(root->right) + 1;
    return max(max(dia1, dia2), dia3);
}

// Approach 2
// Time Complexity -> O(n)
static int maxDia = 0;
static int helper(Node *root)
{
    if (root == NULL)
        return 0;
    int leftHeight = helper(root->left);
    int rightHeight = helper(root->right);
    maxDia = max(maxDia, 1 + leftHeight + rightHeight);
    return max(leftHeight, rightHeight) + 1;
}

static int diameterOfTree(Node *root)
{
    helper(root);
    return maxDia;
}

// int main()
// {
//     int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//     Node *root = buildTree(nodes);
//     cout << diameterOfTree2(root) << endl;
// }
