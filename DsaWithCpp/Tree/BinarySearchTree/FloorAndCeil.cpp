#include <iostream>
// #include "Node.cpp"
#include "BSTRecursive.cpp"
using namespace std;

class FloorAndCeil : public BSTRecursive
{
public:
    static Node *getFloorIterative(Node *root, int num)
    {
        Node *floor = NULL;
        while (root != NULL)
        {
            if (root->data == num)
                return root;
            if (root->data > num)
                root = root->left;
            else
            {
                floor = root;
                root = root->right;
            }
        }
        return floor;
    }

    static Node *getCeilIterative(Node *root, int num)
    {
        Node *ceil = NULL;
        while (root != NULL)
        {
            if (root->data == num)
                return root;
            if (root->data < num)
                root = root->right;
            else
            {
                ceil = root;
                root = root->left;
            }
        }
        return ceil;
    }

    static Node *getFloorRecursive(Node *root, int num)
    {
        return getFloorRecursive(root, num, NULL);
    }

    static Node *getCeilRecursive(Node *root, int num)
    {
        return getCeilRecursive(root, num, NULL);
    }

private:
    static Node *getFloorRecursive(Node *root, int num, Node *floor)
    {
        if (root == NULL)
            return floor;
        if (root->data == num)
            return root;
        if (root->data > num)
            return getFloorRecursive(root->left, num, floor);
        else
            return getFloorRecursive(root->right, num, root);
    }

    static Node *getCeilRecursive(Node *root, int num, Node *ceil)
    {
        if (root == NULL)
            return ceil;
        if (root->data == num)
            return root;
        if (root->data < num)
            return getCeilRecursive(root->right, num, ceil);
        else
            return getCeilRecursive(root->left, num, root);
    }
};

// int main()
// {
//     FloorAndCeil ob;
//     while (true)
//     {
//         printf("Press:\n"
//                "1 to Insert\n"
//                "2 to Display\n"
//                "3 to Delete\n"
//                "4 to Search\n"
//                "5 to Get Floor\n"
//                "6 to Get Ceil\n"
//                "7 to exit()\n"
//                "Enter your choice -> ");
//         int choice, data, floor, ceil;
//         cin >> choice;
//         switch (choice)
//         {
//         case 1:
//             cout << "Enter the Data to Insert -> ";
//             cin >> data;
//             ob.insert(data);
//             break;
//         case 2:
//             ob.display();
//             break;
//         case 3:
//             cout << "Enter the Data to Delete -> ";
//             cin >> data;
//             ob.remove(data);
//             break;
//         case 4:
//             cout << "Enter the Data to Search -> ";
//             cin >> data;
//             printf("%s\n", ob.search(data) ? "Element Exists!" : "Element Doesn't Exists!");
//             break;
//         case 5:
//             cout << "Enter the Number -> ";
//             cin >> floor;
//             if (ob.getFloorIterative(ob.root, floor) == NULL)
//                 cout << "NULL" << endl;
//             else
//                 cout << ob.getFloorIterative(ob.root, floor)->data << endl;
//             break;
//         case 6:
//             cout << "Enter the Number -> ";
//             cin >> ceil;
//             if (ob.getCeilIterative(ob.root, ceil) == NULL)
//                 cout << "NULL" << endl;
//             else
//                 cout << ob.getCeilIterative(ob.root, ceil)->data << endl;
//             break;
//         case 7:
//             exit(0);
//             break;
//         default:
//             cout << "Wrong Input!\n";
//             cin.clear();
//             cin.ignore(1000, '\n');
//         }
//     }
// }
