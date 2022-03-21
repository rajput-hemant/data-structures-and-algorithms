import sys
from node import Node
from tree_builder import build_tree


def get_max(root: Node) -> int:
    if root == None:
        return -sys.maxsize - 1
    return max(root.data, get_max(root.left), get_max(root.right))


# nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
# root = build_tree(nodes)
# print(get_max(root))
