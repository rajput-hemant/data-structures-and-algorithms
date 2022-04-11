class Node:
    def __init__(self) -> None:
        pass

    def __init__(self, data):
        self.data = data
        self.height = 1
        self.left = self.right = None

    def __init__(self, data, left=None, right=None):
        self.data = data
        self.height = 1
        self.left = left
        self.right = right
