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


def delete(data):
    global root

    def __delete(root: Node, data) -> Node:
        if root is None:
            return None
        current_node = root
        parent_node = None
        while current_node is not None and current_node.data != data:
            parent_node = current_node
            if current_node.data > data:
                current_node = current_node.left
            else:
                current_node = current_node.right
        if current_node is None:
            return root
        if current_node.left is None or current_node.right is None:
            new_node = None
            if current_node.left is None:
                new_node = current_node.right
            else:
                new_node = current_node.left
            if parent_node is None:
                return new_node
            if current_node == parent_node.left:
                parent_node.left = new_node
            else:
                parent_node.right = new_node
        else:
            in_order_parent = None
            successor = current_node.right
            while successor.left is not None:
                in_order_parent = successor
                successor = successor.left
            if in_order_parent is not None:
                in_order_parent.left = successor.right
            else:
                current_node.right = successor.right
            current_node.data = successor.data
        return root

    root = __delete(root, data)


def search(data) -> bool:
    global root

    def __search(root: Node, data) -> bool:
        while root is not None:
            if root.data == data:
                return True
            if root.data > data:
                root = root.left
            else:
                root = root.right
        return False

    return __search(root, data)


def display():
    global root

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
