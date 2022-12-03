from node import Node
import bst_recursive as bst
import sys


def get_floor_iterarive(root: Node, num: int) -> Node:
    floor = None
    while root is not None:
        if root.data == num:
            return root
        if root.data > num:
            root = root.left
        else:
            floor = root
            root = root.right
    return floor


def get_ceil_iterative(root: Node, num: int) -> Node:
    ceil = None
    while root is not None:
        if root.data == num:
            return root
        if root.data < num:
            root = root.right
        else:
            ceil = root
            root = root.left
    return ceil


def get_floor_recursive(root: Node, num: int) -> Node:
    def __get_floor_recursive(root: Node, num: int, floor: Node) -> Node:
        if root is None:
            return floor
        if root.data == num:
            return root
        if root.data > num:
            return __get_floor_recursive(root.left, num, floor)
        return __get_floor_recursive(root.right, num, root)

    return __get_floor_recursive(root, num, None)


def get_ceil_recursive(root: Node, num: int) -> Node:
    def __get_ceil_recursive(root: Node, num: int, floor: Node) -> Node:
        if root is None:
            return floor
        if root.data == num:
            return root
        if root.data < num:
            return __get_ceil_recursive(root.right, num, floor)
        return __get_ceil_recursive(root.left, num, root)

    return __get_ceil_recursive(root, num, None)


if __name__ == "__main__":
    while True:
        try:
            choice = int(
                input(
                    "Press:\n"
                    "1 to Insert\n"
                    "2 to Display\n"
                    "3 to Delete\n"
                    "4 to Search\n"
                    "5 to Get Floor\n"
                    "6 to Get Ceil\n"
                    "7 to exit()\n"
                    "Enter your choice -> "
                )
            )
        except BaseException:
            print("Wrong Input! Only Integer value is allowed.")
            continue
        match choice:
            case 1:
                data = input("Enter the Data to Insert -> ")
                bst.insert(data)
            case 2:
                bst.display()
            case 3:
                data = input("Enter the Data to Delete -> ")
                bst.delete(data)
            case 4:
                data = input("Enter the Data to Search -> ")
                print("Element Exists!") if bst.search(data) else print(
                    "Element Doesn't Exists!"
                )
            case 5:
                floor = input("Enter the Number -> ")
                try:
                    print(get_floor_iterarive(bst.root, floor).data)
                except BaseException:
                    print("NONE")
            case 6:
                ceil = input("Enter the Number -> ")
                try:
                    print(get_ceil_iterative(bst.root, ceil).data)
                except BaseException:
                    print("NONE")
            case 7:
                sys.exit(0)
            case _:
                print("Wrong Input!")
