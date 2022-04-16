from node import Node
from singly_linked_list import SinglyLinkedList


def move_zeroes(head: Node) -> Node:
    prev_node = head
    current_node = head.next
    while current_node is not None:
        if int(current_node.data) == 0:
            prev_node.next = current_node.next
            current_node.next = head
            head = current_node
            current_node = prev_node.next
            continue
        prev_node = prev_node.next
        current_node = current_node.next
    return head


if __name__ == "__main__":
    sll = SinglyLinkedList()
    while True:
        try:
            choice = int(
                input(
                    "Press:\n"
                    "1 to Insert\n"
                    "2 to Display\n"
                    "3 to Delete All\n"
                    "4 to Move Zeroes to Front\n"
                    "5 to exit()\n"
                    "Enter your choice -> "
                )
            )
        except Exception:
            print(f"Wrong Input! Only Integer value is allowed.")
            continue
        match choice:
            case 1:
                data = input("Enter the Data -> ")
                sll.insert_at_last(data)
            case 2:
                sll.display()
            case 3:
                sll.delete_all()
            case 4:
                if not sll.is_empty():
                    sll.head = move_zeroes(sll.head)
                else:
                    print("List is Empty!")
            case 5:
                exit(0)
            case _:
                print("Wrong Input!")
