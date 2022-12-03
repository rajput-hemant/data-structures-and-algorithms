import sys
from node import Node


def is_bst(root: Node) -> bool:
    def __is_bst(root: Node, min_, max_):
        if not root:
            return True
        if root.data <= min_ or root.data >= max_:
            return False
        return __is_bst(root.left, min_, root.data) and __is_bst(
            root.right, root.data, max_
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
