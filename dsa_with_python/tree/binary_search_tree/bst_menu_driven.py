from bst_recursive import *

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
            insert(data)
        case 2:
            data = input("Enter the Data to Delete -> ")
            delete(data)
        case 3:
            data = input("Enter the Data to Search -> ")
            print("Element Exists!") if search(data) else print(
                "Element Doesn't Exists!"
            )
        case 4:
            display()
        case 5:
            exit(0)
        case _:
            print("Wrong Input!")
