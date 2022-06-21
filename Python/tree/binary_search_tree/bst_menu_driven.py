import bst_iterative as bst

# import bst_recursive as bst


def __is_empty() -> bool:
    return bst.root is None


while True:
    try:
        choice = int(
            input(
                "Press:\n"
                "1 to Insert\n"
                "2 to Delete\n"
                "3 to Search\n"
                "4 to Display\n"
                "5 to exit()\n"
                "Enter your choice -> "
            )
        )
    except Exception:
        print(f"Wrong Input! Only Integer value is allowed.")
        continue
    match choice:
        case 1:
            data = input("Enter the Data to Insert -> ")
            bst.insert(data)
        case 2:
            if __is_empty():
                print("BST is Empty!")
            else:
                data = input("Enter the Data to Delete -> ")
                bst.delete(data)
        case 3:
            if __is_empty():
                print("BST is Empty!")
            else:
                data = input("Enter the Data to Search -> ")
                print("Element Exists!") if bst.search(data) else print(
                    "Element Doesn't Exists!"
                )
        case 4:
            if __is_empty():
                print("BST is Empty!")
            else:
                bst.display()
        case 5:
            exit(0)
        case _:
            print("Wrong Input!")
