#include <iostream>
// #include "BSTRecursive.cpp"
#include "BSTIterative.cpp"
using namespace std;

BSTIterative bst;
// BSTRecursive bst;

bool isEmpty()
{
    return bst.root == NULL;
}

int main()
{
    while (true)
    {
        printf("Press:\n"
               "1 to Insert\n"
               "2 to Delete\n"
               "3 to Search\n"
               "4 to Display\n"
               "5 to exit()\n"
               "Enter your choice -> ");
        int choice;
        int data;
        cin >> choice;
        switch (choice)
        {
        case 1:
            cout << "Enter the Data to Insert -> ";
            cin >> data;
            bst.insert(data);
            break;
        case 2:
            if (isEmpty())
                cout << "BST is Empty!" << endl;
            else
            {
                cout << "Enter the Data to Delete -> ";
                cin >> data;
                bst.remove(data);
            }
            break;
        case 3:
            if (isEmpty())
                cout << "BST is Empty!" << endl;
            else
            {
                cout << "Enter the Data to Search -> ";
                cin >> data;
                printf("%s\n", bst.search(data) ? "Element Exists!" : "Element Doesn't Exists!");
            }
            break;
        case 4:
            if (isEmpty())
                cout << "BST is Empty!" << endl;
            else
                bst.display();
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
