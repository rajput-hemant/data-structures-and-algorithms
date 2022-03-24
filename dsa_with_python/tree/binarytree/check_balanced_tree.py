from node import Node
from tree_builder import build_tree
from height_of_tree import height


def is_balanced_tree(root: Node) -> bool:
    if root is None:
        return True
    left_height = height(root.left)
    right_height = height(root.right)
    return (
        abs(left_height - right_height) <= 1
        and is_balanced_tree(root.left)
        and is_balanced_tree(root.right)
    )


if __name__ == "__main__":
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 8, -1, -1, 9, -1, -1]
    root = build_tree(nodes)
    print(f"Is Balanced Tree -> {is_balanced_tree(root)}")
