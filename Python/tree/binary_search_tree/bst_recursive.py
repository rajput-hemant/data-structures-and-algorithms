from node import Node

root = None


def insert(data):
    global root

    def __insert(root: Node, data) -> Node:
        if root is None:
            return Node(data)
        if root.data > data:
            root.left = __insert(root.left, data)
        elif root.data < data:
            root.right = __insert(root.right, data)
        return root

    root = __insert(root, data)


def delete(data):
    global root

    def __delete(root: Node, data) -> Node:
        if root is None:
            return None
        if root.data > data:
            root.left = __delete(root.left, data)
        elif root.data < data:
            root.right = __delete(root.right, data)
        else:
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            root.data = __get_successor(root)
            root.right = __delete(root.right, root.data)
        return root

    def __get_successor(root: Node) -> int:
        current_node = root.right
        while current_node is not None and current_node.left is not None:
            current_node = current_node.left
        return current_node.data

    root = __delete(root, data)


def search(data) -> bool:
    global root

    def __search(root: Node, data) -> bool:
        if root is None:
            return False
        if root.data == data:
            return True
        if root.data > data:
            return __search(root.left, data)
        else:
            return __search(root.right, data)

    return __search(root, data)


def display():
    global root

    def __display(root: Node):
        if root is None:
            return
        __display(root.left)
        print(root.data, end=" ")
        __display(root.right)

    __display(root)
    print()
