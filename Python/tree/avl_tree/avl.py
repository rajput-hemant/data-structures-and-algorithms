from node import Node

"""
-> It is a BST (For every node, left subtree is smaller & right subtree is
greater)
-> It is Balanced (For every node, differerce b/w left & right heights <= 1)
Balance Factor: |leftHeight - rightHeight| <= 1
"""
root = None


def insert(data):
    global root

    def __insert(root: Node, data) -> Node:
        if not root:
            return Node(data)
        if root.data > data:
            root.left = __insert(root.left, data)
        elif root.data < data:
            root.right = __insert(root.right, data)
        else:
            return root
        root.height = __height(root)
        balance_factor = __get_balance_factor(root)
        if balance_factor > 1 and data < root.left.data:
            return __right_rotate(root)
        if balance_factor < -1 and data > root.right.data:
            return __left_rotate(root)
        if balance_factor > 1 and data > root.left.data:
            root.left = __left_rotate(root.left)
            return __right_rotate(root)
        if balance_factor < -1 and data < root.right.data:
            root.right = __right_rotate(root.right)
            return __left_rotate(root)
        return root

    root = __insert(root, data)


def delete(data):
    global root

    def __delete(root: Node, data) -> Node:
        if not root:
            return root
        if root.data > data:
            root.left = __delete(root.left, data)
        elif root.data < data:
            root.right = __delete(root.right, data)
        else:
            if root.left is None or root.right is None:
                temp = None
                if temp == root.left:
                    temp = root.right
                else:
                    temp = root.left
                if temp is None:
                    temp = root
                    root = None
                else:
                    root = temp
            else:
                temp = __get_successor(root)
                root.data = temp.data
                root.right = __delete(root.right, temp.data)
        if not root:
            return root
        root.height = __height(root)
        balance_factor = __get_balance_factor(root)
        if balance_factor > 1 and __get_balance_factor(root.left) >= 0:
            return __right_rotate(root)
        if balance_factor < -1 and __get_balance_factor(root.right) <= 0:
            return __left_rotate(root)
        if balance_factor > 1 and __get_balance_factor(root.left) < 0:
            root.left = __left_rotate(root.left)
            return __right_rotate(root)
        if balance_factor < -1 and __get_balance_factor(root.right) > 0:
            root.right = __right_rotate(root.right)
            return __left_rotate(root)
        return root

    def __get_successor(root: Node) -> Node:
        current_node = root.right
        while current_node.left is not None:
            current_node = current_node.left
        return current_node

    root = __delete(root, data)


def __height(root: Node):
    if not root:
        return 0
    return max(__height(root.left), __height(root.right)) + 1


def __get_balance_factor(root: Node):
    if not root:
        return 0
    return __height(root.left) - __height(root.right)


def __left_rotate(root: Node):
    right_node = root.right
    temp = right_node.left
    right_node.left = root
    root.right = temp
    root.height = __height(root)
    right_node.height = __height(right_node)
    return right_node


def __right_rotate(root: Node):
    left_node = root.left
    temp = left_node.right
    left_node.right = root
    root.left = temp
    root.height = __height(root)
    left_node.height = __height(left_node)
    return left_node


def search(data):
    global root

    def __search(root: Node, data) -> bool:
        if not root:
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
        if not root:
            return
        print(root.data, end=" ")
        __display(root.left)
        __display(root.right)

    __display(root)
    print()
