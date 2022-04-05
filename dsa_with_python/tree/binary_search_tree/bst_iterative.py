from node import Node

root = None


def insert(data):
    global root

    def __insert(root: Node, data) -> Node:
        new_node = Node(data)
        parent_node, current_node = None, root
        while current_node is not None:
            parent_node = current_node
            if current_node.data > data:
                current_node = current_node.left
            elif current_node.data < data:
                current_node = current_node.right
            else:
                return root
        if parent_node is None:
            return new_node
        if parent_node.data > data:
            parent_node.left = new_node
        else:
            parent_node.right = new_node
        return root

    root = __insert(root, data)


def search(data) -> bool:
    global root

    def __search(root: Node, data) -> bool:
        while root is not None:
            if root.data == data:
                return True
            elif root.data > data:
                root = root.left
            else:
                root = root.right
        return False

    return __search(root, data)


def display():
    def __display(root: Node):
        stack = []
        current_node = root
        print("[", end="")
        while current_node is not None or len(stack) > 0:
            while current_node is not None:
                stack.append(current_node)
                current_node = current_node.left
            current_node = stack.pop()
            print(current_node.data, end=", ")
            current_node = current_node.right
        print("\b\b]")

    __display(root)
