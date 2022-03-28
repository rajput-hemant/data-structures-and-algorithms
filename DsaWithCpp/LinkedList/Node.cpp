struct Node
{
    int data;
    Node *next;
    Node *prev;

    Node()
    {
    }

    Node(int val)
    {
        data = val;
        next = prev = NULL;
    }

    Node(int val, Node *leftptr, Node *rightptr)
    {
        data = val;
        next = leftptr;
        prev = rightptr;
    }
};
