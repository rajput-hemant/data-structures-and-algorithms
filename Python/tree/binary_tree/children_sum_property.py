from node import Node
from tree_builder import build_tree


def is_child_sum(root: Node) -> bool:
    if root is None or root.left is None and root.right is None:
        return True
    sum_ = root.left.data + root.right.data
    return root.data == sum_ and is_child_sum(root.left) and is_child_sum(root.right)


def main():
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    print(f"Follows Children Sum Property -> {is_child_sum(root)}")


if __name__ == "__main__":
    main()
