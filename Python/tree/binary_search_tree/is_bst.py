import sys
from node import Node


def is_bst(root: Node) -> bool:
    def __is_bst(root: Node, min, max):
        if not root:
            return True
        if root.data <= min or root.data >= max:
            return False
        return __is_bst(root.left, min, root.data) and __is_bst(
            root.right, root.data, max
        )

    return __is_bst(root, -sys.maxsize, sys.maxsize)


# prev = -sys.maxsize


# def is_bst(root: Node) -> bool:
#     if not root:
#         return True
#     if is_bst(root.left) == False:
#         return False
#     if root.data <= prev:
#         return False
#     prev = root.data
#     return is_bst(root.right)
