struct Node
{
    int data, height;
    Node *left;
    Node *right;

    Node()
    {
    }

    Node(int val)
    {
        data = val;
        height = height;
        left = right = NULL;
    }

    Node(int val, Node *leftptr, Node *rightptr)
    {
        data = val;
        height = height;
        left = leftptr;
        right = rightptr;
    }
};
