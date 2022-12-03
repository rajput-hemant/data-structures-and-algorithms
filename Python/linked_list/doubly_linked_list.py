from node import Node


class DoublyLinkedList:
    def __init__(self):
        self.head = self.tail = None
        self.size = 0

    def is_empty(self) -> bool:
        return self.head is None and self.tail is None

    def insert_begin(self, data):
        new_node = Node(data)
        if self.is_empty():
            self.head = self.tail = new_node
        else:
            new_node.next = self.head
            self.head.prev = new_node
            self.head = new_node
        print("Data Inserted!")
        self.size += 1

    def insert_at_pos(self, data, pos: int):
        if pos == 0:
            print("Invalid Input! Index Starts from 1.")
        elif pos == 1:
            self.insert_begin(data)
        elif pos > self.size:
            print(f"Invalid Input! List size is: {self.size}")
        else:
            new_node = Node(data)
            current_node = self.head
            for _ in range(0, pos - 2):
                current_node = current_node.next
            new_node.next = current_node.next
            current_node.next.prev = new_node
            current_node.next = new_node
            new_node.prev = current_node
            print("Data Inserted!")
            self.size += 1

    def insert_at_last(self, data):
        new_node = Node(data)
        if self.is_empty():
            self.head = self.tail = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node
        print("Data Inserted!")
        self.size += 1

    def delete_begin(self):
        if self.is_empty():
            print("List is Empty!")
        elif self.head.next is None:
            self.head = self.tail = None
            print("List Cleared Successfully!")
        else:
            print(f"Successfully Deleted '{self.head.data}' from beginning.")
            self.head = self.head.next
            self.head.prev = None
            self.size -= 1

    def delete_at_pos(self, pos: int):
        if self.is_empty():
            print("List is Empty!")
        elif pos == 0:
            print("Invalid Input! Index Starts from 1.")
        elif pos == 1:
            self.delete_begin()
        elif pos > self.size:
            print(f"Invalid Input! List size is: {self.size}")
        else:
            current_node = self.head
            for _ in range(0, pos - 2):
                current_node = current_node.next
            print(
                f"Successfully Deleted '{current_node.next.data}' from position '{pos}'."
            )
            current_node.next = current_node.next.next
            current_node.next.prev = current_node
            self.size -= 1

    def delete_at_last(self):
        if self.is_empty():
            print("List is Empty!")
        elif self.head.next is None:
            self.head = self.tail = None
            print("List Cleared Successfully!")
            self.size = 0
        else:
            print(f"Successfully Deleted '{self.tail.data}' from last.")
            self.tail = self.tail.prev
            self.tail.next = None
            self.size -= 1

    def delete_all(self):
        if self.is_empty():
            print("List is Empty!")
        else:
            print("List Cleared Successfully!")
            self.head = self.tail = None
            self.size = 0

    def display(self):
        if self.is_empty():
            print("List is Empty!")
        else:
            current_node = self.head
            print("[", end="")
            while current_node is not None:
                print(current_node.data, end=", ")
                current_node = current_node.next
            print("\b\b]")
            print(f"List size is -> {self.size}")

    def display_reverse(self):
        if self.is_empty():
            print("List is Empty!")
        else:
            current_node = self.tail
            print("[", end="")
            while current_node is not None:
                print(current_node.data, end=", ")
                current_node = current_node.prev
            print("\b\b]")
            print(f"List size is -> {self.size}")
