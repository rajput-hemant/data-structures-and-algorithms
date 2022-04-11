#include <iostream>
#include "AVL.cpp"
using namespace std;

int main()
{
    AVL avl;
    while (true)
    {
        printf("Press:\n"
               "1 to Insert\n"
               "2 to Display\n"
               "3 to Delete\n"
               "4 to Search\n"
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
            avl.insert(data);
            break;
        case 2:
            avl.display();
            break;
        case 3:
            cout << "Enter the Data to Delete -> ";
            cin >> data;
            avl.remove(data);
            break;
        case 4:
            cout << "Enter the Data to Search -> ";
            cin >> data;
            printf("%s\n", avl.search(data) ? "Element Exists!" : "Element Doesn't Exists!");
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
