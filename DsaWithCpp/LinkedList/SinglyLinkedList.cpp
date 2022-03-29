#include <iostream>
#include "Node.cpp"
using namespace std;

class SinglyLinkedList
{
    Node *head = NULL;
    int size = 0;

public:
    bool isEmpty()
    {
        return head == NULL;
    }

    void insertAtBegin(int data)
    {
        Node *newNode = new Node(data);
        if (isEmpty())
        {
            head = newNode;
            cout << "Data Inserted!\n";
            size++;
            return;
        }
        newNode->next = head;
        head = newNode;
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
            currentNode->next = newNode;
            cout << "Data Inserted!\n";
            size++;
        }
    }
    void insertAtLast(int data)
    {
        Node *newNode = new Node(data);
        if (isEmpty())
        {
            head = newNode;
            cout << "Data Inserted!\n";
            size++;
            return;
        }
        Node *currentNode = head;
        while (currentNode->next != NULL)
            currentNode = currentNode->next;
        currentNode->next = newNode;
        cout << "Data Inserted!\n";
        size++;
    }

    void remAtBegin()
    {
        if (isEmpty())
            cout << "List Is Empty!\n";
        else if (head->next == NULL)
        {
            head = NULL;
            cout << "List Successfully Cleared!\n";
            size = 0;
        }
        else
        {
            head = head->next;
            cout << "Successfully Deleted!\n";
            size--;
        }
    }

    void remAtPos(int pos)
    {
        if (isEmpty())
            cout << "List Is Empty!\n";
        else if (head->next == NULL)
        {
            head = NULL;
            cout << "List Successfully Cleared!\n";
            size = 0;
        }
        else if (pos = 0)
            cout << "Invalid Input! Index Starts from 1.\n";
        else if (pos == 1)
            remAtBegin();
        else if (pos > size)
            cout << "Invalid Input! List Size is: " << size << endl;
        else
        {
            Node *currentNode = head;
            for (int i = 0; i < pos - 2; i++)
                currentNode = currentNode->next;
            currentNode->next = currentNode->next->next;
            cout << "Sucessfully Deleted!\n";
            size--;
        }
    }

    void remAtLast()
    {
        if (isEmpty())
            cout << "List Is Empty!\n";
        else if (head->next == NULL)
        {
            head = NULL;
            cout << "List Successfully Cleared!\n";
            size = 0;
        }
        else
        {
            Node *lastNode = head;
            while (lastNode->next->next != NULL)
                lastNode = lastNode->next;
            lastNode->next = NULL;
            cout << "Successfully Deleted!\n";
            size--;
        }
    }

    void removeAll()
    {
        if (isEmpty())
        {
            cout << "List Is Empty!\n";
            return;
        }
        cout << "List Successfully Cleared!\n";
        head = NULL;
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
        printf("[");
        while (currentNode != NULL)
        {
            printf("%i, ", currentNode->data);
            currentNode = currentNode->next;
        }
        printf("\b\b]\nList Size is -> %i\n", size);
    }
};
