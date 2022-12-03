from node import Node
from tree_builder import build_tree

max_level = 0


def __print_left_view(root: Node, level: int):
    global max_level
    if root is None:
        return
    if max_level < level:
        print(root.data, end=" ")
        max_level = level
    __print_left_view(root.left, level + 1)
    __print_left_view(root.right, level + 1)


def print_left_view(root):
    __print_left_view(root, 1)


def main():
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    print_left_view(root)


if __name__ == "__main__":
    main()
