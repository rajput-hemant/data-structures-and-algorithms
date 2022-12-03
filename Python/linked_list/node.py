class Node:
    def __init__(self) -> None:
        pass  # empty constructor

    def __init__(self, data):
        self.data = data
        self.next = self.prev = None

    def __init__(self, data, next=None, prev=None):
        self.data = data
        self.next = next
        self.prev = prev
