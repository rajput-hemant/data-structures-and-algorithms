from node import Node


class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.size = 0

    def is_empty(self) -> bool:
        return self.head is None

    def insert_begin(self, data):
        new_node = Node(data)
        if self.is_empty():
            self.head = new_node
            print("Data Inserted!")
            self.size += 1
            return
        new_node.next = self.head
        self.head = new_node
        print("Data Inserted!")
        self.size += 1

    def insert_at_pos(self, data, pos: int):
        if pos == 0:
            print("Invalid Input! Index Starts from 1.")
        elif pos == 1:
            self.insert_begin()
        elif pos > self.size:
            print(f"Invalid Input! List Size is: '{self.size}'")
        else:
            new_node = Node(data)
            current_node = self.head
            for i in range(0, pos - 2):
                current_node = current_node.next
            new_node.next = current_node.next
            current_node.next = new_node
            print("Data Inserted!")
            self.size += 1

    def insert_at_last(self, data):
        new_node = Node(data)
        if self.is_empty():
            self.head = new_node
            print("Data Inserted!")
            self.size += 1
        else:
            current_node = self.head
            while current_node.next is not None:
                current_node = current_node.next
            current_node.next = new_node
            self.size += 1

    def delete_at_begin(self):
        if self.is_empty():
            print("List is Empty!")
        elif self.head.next is None:
            self.head = None
            print("List Cleared Successfully!")
            self.size = 0
        else:
            print(f"Successfully Deleted '{self.head.data}' from beginning.")
            self.head = self.head.next
            self.size -= 1

    def delete_at_pos(self, pos: int):
        if self.is_empty():
            print("List is Empty!")
        elif self.head.next is None:
            self.head = None
            print("List Successfully Cleared!")
            self.size = 0
        elif pos == 0:
            print("Invalid Input! Index Starts from 1.")
        elif pos == 1:
            self.delete_at_begin()
        elif pos == self.size:
            self.delete_at_last()
        elif pos > self.size:
            print(f"Invalid Input! List Size is: '{self.size}'")
        else:
            current_node = self.head
            for i in range(0, pos - 2):
                current_node = current_node.next
            print(
                f"Successfully Deleted '{current_node.next.data}' from position '{pos}'."
            )
            current_node.next = current_node.next.next
            self.size -= 1

    def delete_at_last(self):
        if self.is_empty():
            print("List is Empty!")
        elif self.head.next is None:
            self.head = None
            print("List Successfully Cleared!")
            self.size = 0
        else:
            current_node = self.head
            while current_node.next.next is not None:
                current_node = current_node.next
            print(f"Successfully Deleted  '{current_node.next.data}' from last.")
            current_node.next = None
            self.size -= 1

    def delete_all(self):
        if self.is_empty():
            print("List is Empty!")
        else:
            print("List Successfully Cleared!")
            self.head = None
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
            print(f"\b\b]")
            print(f"List size is -> {self.size}")
