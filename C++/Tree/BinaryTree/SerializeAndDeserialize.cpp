#include <iostream>
#include <vector>
#include "Node.cpp"
// #include "TreeBuilder.cpp"
#include "TreeTraversals.cpp"
using namespace std;

static void serialize(Node *root, vector<int> &arr)
{
    if (root == NULL)
    {
        arr.push_back(-1);
        return;
    }
    arr.push_back(root->data);
    serialize(root->left, arr);
    serialize(root->right, arr);
}

static int index = 0;

static Node *deSerialize(vector<int> &arr)
{
    if (index == arr.size())
        return NULL;
    int data = arr.at(index++);
    if (data == -1)
        return NULL;
    Node *root = new Node(data);
    root->left = deSerialize(arr);
    root->right = deSerialize(arr);
    return root;
}

int main()
{
    Traversals ob;
    vector<int> arr;
    int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    Node *root = buildTree(nodes);
    serialize(root, arr);
    for (int i = 0; i < arr.size(); i++)
        cout << arr[i] << " ";
    cout << endl;
    Node *newRoot = deSerialize(arr);
    ob.preOrder(newRoot);
    cout << endl;
}
