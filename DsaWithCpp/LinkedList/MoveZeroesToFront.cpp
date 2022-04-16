#include <iostream>
// #include "Node.cpp"
#include "SinglyLinkedList.cpp"
using namespace std;

static Node *moveZeroes(Node *head)
{
    Node *prevNode = head;
    Node *currentNode = head->next;
    while (currentNode != NULL)
    {
        if (currentNode->data == 0)
        {
            prevNode->next = currentNode->next;
            currentNode->next = head;
            head = currentNode;
            currentNode = prevNode->next;
            continue;
        }
        prevNode = prevNode->next;
        currentNode = currentNode->next;
    }
    return head;
}

int main()
{
    SinglyLinkedList sll;
    while (true)
    {
        printf("Press:\n"
               "1 to Insert\n"
               "2 to Display\n"
               "3 to Delete All\n"
               "4 to Move Zeroes to Front\n"
               "5 to exit()\n"
               "Enter your choice -> ");
        int choice, data;
        cin >> choice;
        switch (choice)
        {
        case 1:
            cout << "Enter your Data -> ";
            cin >> data;
            sll.insertAtLast(data);
            break;
        case 2:
            sll.display();
            break;
        case 3:
            sll.removeAll();
            break;
        case 4:
            if (!sll.isEmpty())
                sll.head = moveZeroes(sll.head);
            else
                cout << "List is Empty!" << endl;
            break;
        case 5:
            exit(0);
            break;
        default:
            cout << "Wrong Input!\n";
            cin.clear();
            cin.ignore(1000, '\n');
        }
    }
}
