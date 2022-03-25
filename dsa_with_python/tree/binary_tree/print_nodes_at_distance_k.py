from node import Node
from tree_builder import build_tree


def print_at_k(root: Node, k: int):
    if root is None:
        return
    if k == 0:
        print(root.data)
        return
    print_at_k(root.left, k - 1)
    print_at_k(root.right, k - 1)


if __name__ == "__main__":
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    print_at_k(root, 2)
