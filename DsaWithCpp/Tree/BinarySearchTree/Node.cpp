struct Node
{
    int data;
    Node *left;
    Node *right;

    Node()
    {
    }

    Node(int val)
    {
        data = val;
        left = right = NULL;
    }

    Node(int val, Node *leftptr, Node *rightptr)
    {
        data = val;
        left = leftptr;
        right = rightptr;
    }
};
