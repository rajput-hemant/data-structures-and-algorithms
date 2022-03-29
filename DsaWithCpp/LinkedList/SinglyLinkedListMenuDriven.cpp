#include <iostream>
#include "SinglyLinkedList.cpp"
using namespace std;

SinglyLinkedList sll;
class SinglyLinkedListMenuDriven
{
public:
    void insert()
    {
        while (true)
        {
            printf("Press:\n"
                   "1 to Insertion at Beginning\n"
                   "2 to Insertion Inbetween\n"
                   "3 to Insertion at Last\n"
                   "4 Go Back\n"
                   "Enter your choice -> ");
            int choice = 0;
            cin >> choice;
            int data = 0, pos = 0;
            switch (choice)
            {
            case 1:
                cout << "Enter your Data -> ";
                cin >> data;
                sll.insertAtBegin(data);
                break;
            case 2:
                cout << "Enter your Data -> ";
                cin >> data;
                cout << "Enter the Index -> ";
                cin >> pos;
                sll.insertAtPos(data, pos);
                break;
            case 3:
                cout << "Enter your Data -> ";
                cin >> data;
                sll.insertAtLast(data);
                break;
            case 4:
                return;
            default:
                cout << "Wrong Input!\n";
            }
        }
    }

    void remove()
    {
        if (sll.isEmpty())
        {
            cout << "List is Empty!\n";
            return;
        }
        printf("Press:\n"
               "1 to Deletion at Beginning\n"
               "2 to Deletion Inbetween\n"
               "3 to Deletion at Last\n"
               "Enter your choice -> ");
        int choice = 0;
        cin >> choice;
        int pos = 0;
        switch (choice)
        {
        case 1:
            sll.remAtBegin();
            break;
        case 2:
            cout << "Enter the Index -> ";
            cin >> pos;
            sll.remAtPos(pos);
            break;
        case 3:
            sll.remAtLast();
            break;
        default:
            cout << "Wrong Input!\n";
        }
    }
};

// int main()
// {
//     SinglyLinkedListMenuDriven ob;
//     while (true)
//     {
//         printf("Press:\n"
//                "1 to Insert\n"
//                "2 to Display\n"
//                "3 to Delete\n"
//                "4 to Delete All\n"
//                "5 to exit()\n"
//                "Enter your choice -> ");
//         int choice;
//         cin >> choice;
//         switch (choice)
//         {
//         case 1:
//             ob.insert();
//             break;
//         case 2:
//             sll.display();
//             break;
//         case 3:
//             ob.remove();
//             break;
//         case 4:
//             sll.removeAll();
//             break;
//         case 5:
//             exit(0);
//             break;
//         default:
//             cout << "Wrong Input!\n";
//             cin.clear();
//             cin.ignore(1000, '\n');
//         }
//     }
// }
