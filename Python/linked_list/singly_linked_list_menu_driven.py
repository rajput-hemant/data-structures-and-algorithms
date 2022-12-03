from singly_linked_list import SinglyLinkedList
import sys


sll = SinglyLinkedList()


def insert():
    while True:
        choice = int(
            input(
                "Press:\n"
                "1 to Insertion at Beginning\n"
                "2 to Insertion Inbetween\n"
                "3 to Insertion at Last\n"
                "4 Go Back\n"
                "Enter your choice -> "
            )
        )
        match choice:
            case 1:
                data = input("Enter your Data -> ")
                sll.insert_begin(data)
            case 2:
                pos = int(input("Enter the Index -> "))
                data = input("Enter your Data -> ")
                sll.insert_at_pos(data, pos)
            case 3:
                data = input("Enter your Data -> ")
                sll.insert_at_last(data)
            case 4:
                return
            case _:
                print("Wrong Input!")


def delete():
    if sll.is_empty():
        print("List is Empty!")
        return
    choice = int(
        input(
            "Press:\n"
            "1 to Deletion at Beginning\n"
            "2 to Deletion Inbetween\n"
            "3 to Deletion at Last\n"
            "Enter your choice -> "
        )
    )
    match choice:
        case 1:
            sll.delete_at_begin()
            return
        case 2:
            pos = int(input("Enter the Index -> "))
            sll.delete_at_pos(pos)
            return
        case 3:
            sll.delete_at_last()
            return
        case _:
            print("Wrong Input!")


if __name__ == "__main__":
    while True:
        try:
            choice = int(
                input(
                    "Press:\n"
                    "1 to Insert\n"
                    "2 to Display\n"
                    "3 to Delete\n"
                    "4 to Delete All\n"
                    "5 to exit()\n"
                    "Enter your choice -> "
                )
            )
        except Exception:
            print(f"Wrong Input! Only Integer value is allowed.")
            continue
        match choice:
            case 1:
                insert()
            case 2:
                sll.display()
            case 3:
                delete()
            case 4:
                sll.delete_all()
            case 5:
                sys.exit(0)
            case _:
                print("Wrong Input!")
