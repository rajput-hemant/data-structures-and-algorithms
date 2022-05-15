#include <iostream>
#include "MinHeap.cpp"
using namespace std;

class PriorityQueue
{
public:
    MinHeap mh;

    bool isEmpty()
    {
        return mh.isEmpty();
    }

    int size()
    {
        return mh.size();
    }

    void push(int item)
    {
        mh.insert(item);
    }

    int top()
    {
        if (isEmpty())
            throw length_error("Priority Queue is Empty!");
        return mh.getMin();
    }

    int pop()
    {
        if (isEmpty())
            throw length_error("Priority Queue is Empty!");
        return mh.extractMin();
    }
};

// int main()
// {
//     PriorityQueue pq;
//     pq.push(10);
//     pq.push(20);
//     pq.push(15);
//     cout << pq.top() << endl;
//     cout << pq.pop() << endl;
//     cout << pq.top() << endl;
//     cout << pq.pop() << endl;
//     cout << pq.top() << endl;
//     cout << pq.pop() << endl;
//     cout << pq.pop() << endl;
// }
