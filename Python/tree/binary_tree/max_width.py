from node import Node
from tree_builder import build_tree


def max_width(root: Node) -> int:
    if root is None:
        return
    q = [root]
    width = 0
    while len(q) > 0:
        flag = len(q)
        width = max(width, flag)
        for _ in range(flag):
            node = q.pop(0)
            if node.left is not None:
                q.append(node.left)
            if node.right is not None:
                q.append(node.right)
    return width


def main():
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 9, -1, -1, 8, -1, -1]
    root = build_tree(nodes)
    print(f"Max Width of Binary Tree is -> {max_width(root)}")


if __name__ == "__main__":
    main()
