#include <iostream>
#include "Node.cpp"
using namespace std;

class DoublyLinkedList
{
    Node *head, *tail = NULL;
    int size = 0;

public:
    bool isEmpty()
    {
        return head == NULL && tail == NULL;
    }

    void insertAtBegin(int data)
    {
        Node *newNode = new Node(data);
        if (isEmpty())
            head = tail = newNode;
        else
        {
            newNode->next = head;
            head->prev = newNode;
            head = newNode;
        }
        cout << "Data Inserted!\n";
        size++;
    }

    void insertAtPos(int data, int pos)
    {
        if (pos == 0)
            cout << "Invalid Input! Index Starts from 1.\n";
        else if (pos == 1)
            insertAtBegin(data);
        else if (pos > size)
            cout << "Invalid Input! List Size is: " << size << endl;
        else
        {
            Node *newNode = new Node(data);
            Node *currentNode = head;
            for (int i = 0; i < pos - 2; i++)
                currentNode = currentNode->next;
            newNode->next = currentNode->next;
            currentNode->next->prev = newNode;
            currentNode->next = newNode;
            newNode->prev = currentNode;
            cout << "Data Inserted!\n";
            size++;
        }
    }

    void insertAtLast(int data)
    {
        Node *newNode = new Node(data);
        if (isEmpty())
            head = tail = newNode;
        else
        {
            tail->next = newNode;
            newNode->prev = tail;
            tail = newNode;
        }
        cout << "Data Inserted!\n";
        size++;
    }

    void delAtBegin()
    {
        if (isEmpty())
            cout << "List is Empty!\n";
        else if (head->next == NULL)
        {
            cout << "List Cleared Sucessfully!\n";
            size = 0;
        }
        else
        {
            cout << "Sucessfully Deleted -> '" << head->data << "' from the beginning.\n";
            head = head->next;
            head->prev = NULL;
            size--;
        }
    }

    void delAtPos(int pos)
    {
        if (isEmpty())
            cout << "List is Empty!\n";
        else if (pos == 0)
            cout << "Invalid Input! Index Starts from 1.\n";
        else if (pos == 1)
            delAtBegin();
        else if (pos > size)
            cout << "Invalid Input! List Size is: " << size << endl;
        else
        {
            Node *currentNode = head;
            for (int i = 0; i < pos - 2; i++)
                currentNode = currentNode->next;
            cout << "Sucessfully Deleted -> '" << currentNode->next->data << "' from position '" << pos << "'.\n";
            currentNode->next = currentNode->next->next;
            currentNode->next->prev = currentNode;
            size--;
        }
    }

    void delAtLast()
    {
        if (isEmpty())
            cout << "List is Empty!\n";
        else if (head->next == NULL)
        {
            head = tail = NULL;
            cout << "List Successfully Cleared.\n";
            size = 0;
        }
        else
        {
            cout << "Sucessfully Deleted -> '" << tail->data << "' from Last.\n";
            tail = tail->prev;
            tail->next = NULL;
            size--;
        }
    }

    void deleteAll()
    {
        if (isEmpty())
        {
            cout << "List is Empty!\n";
            return;
        }
        head = tail = NULL;
        cout << "List Sucessfully Cleared!\n";
        size = 0;
    }

    void display()
    {
        if (isEmpty())
        {
            cout << "List is Empty!\n";
            return;
        }
        Node *currentNode = head;
        cout << "[";
        while (currentNode != NULL)
        {
            cout << currentNode->data << ", ";
            currentNode = currentNode->next;
        }
        cout << "\b\b]\nList Size is -> " << size << ".\n";
    }

    void printReverse()
    {
        if (isEmpty())
        {
            cout << "List is Empty!\n";
            return;
        }
        Node *currentNode = tail;
        cout << "[";
        while (currentNode != NULL)
        {
            cout << currentNode->data << ", ";
            currentNode = currentNode->prev;
        }
        cout << "\b\b]\nList Size is -> " << size << ".\n";
    }
};