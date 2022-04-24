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
