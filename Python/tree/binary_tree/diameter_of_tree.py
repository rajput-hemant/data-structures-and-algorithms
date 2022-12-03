from node import Node
from tree_builder import build_tree
from height_of_tree import height


# Approach 1
# Time Complexity -> O(n^2)
def diameter_of_tree2(root: Node) -> int:
    if root is None:
        return 0
    dia_1 = diameter_of_tree2(root.left)
    dia_2 = diameter_of_tree2(root.right)
    dia_3 = height(root.left) + height(root.right) + 1
    return max(dia_1, dia_2, dia_3)


__max_dia = 0


# Approach 2
# Time Complexity -> O(n)
def diameter_of_tree(root: Node) -> int:
    def __helper(root: Node):
        global __max_dia
        if root is None:
            return 0
        left_height = __helper(root.left)
        right_height = __helper(root.right)
        __max_dia = max(__max_dia, left_height + right_height + 1)
        return max(left_height, right_height) + 1

    __helper(root)
    return __max_dia


def main():
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    print(diameter_of_tree(root))


if __name__ == "__main__":
    main()
