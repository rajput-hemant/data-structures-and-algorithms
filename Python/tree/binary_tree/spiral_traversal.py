from node import Node
from tree_builder import build_tree


def spiral_traversal(root: Node):
    if root is None:
        return
    stk1, stk2 = [], []
    stk1.append(root)
    while len(stk1) > 0 or len(stk2) > 0:
        while len(stk1) > 0:
            node = stk1.pop()
            print(node.data, end=" ")
            if node.left is not None:
                stk2.append(node.left)
            if node.right is not None:
                stk2.append(node.right)
        print()
        while len(stk2) > 0:
            node = stk2.pop()
            print(node.data, end=" ")
            if node.right is not None:
                stk1.append(node.right)
            if node.left is not None:
                stk1.append(node.left)
        print()


def main():
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    spiral_traversal(root)


if __name__ == "__main__":
    main()
