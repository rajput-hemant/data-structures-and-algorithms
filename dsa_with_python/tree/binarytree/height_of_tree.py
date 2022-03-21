from node import Node
from tree_builder import build_tree


def height(root: Node):
    if root == None:
        return 0
    else:
        return max(height(root.left), height(root.right)) + 1


# nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
# root = build_tree(nodes)
# print(height(root))
