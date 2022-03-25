from node import Node
from tree_builder import build_tree

# from height_of_tree import height

# Naive Approach
# Time Complexity -> O(n^2)
# def is_balanced_tree(root: Node) -> bool:
#     if root is None:
#         return True
#     left_height = height(root.left)
#     right_height = height(root.right)
#     return (
#         abs(left_height - right_height) <= 1
#         and is_balanced_tree(root.left)
#         and is_balanced_tree(root.right)
#     )

# Time Complexity -> O(n)
def is_balanced_tree(root: Node) -> bool:
    return not __is_balanced_tree(root) == -1


def __is_balanced_tree(root: Node) -> int:
    if root is None:
        return 0
    left_height = __is_balanced_tree(root.left)
    if left_height == -1:
        return -1
    right_height = __is_balanced_tree(root.right)
    if right_height == -1:
        return -1
    if abs(left_height - right_height) > 1:
        return -1
    else:
        return max(left_height, right_height) + 1


if __name__ == "__main__":
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 9, -1, -1, 8, -1, -1]
    root = build_tree(nodes)
    print(f"Is Balanced Tree -> {is_balanced_tree(root)}")
