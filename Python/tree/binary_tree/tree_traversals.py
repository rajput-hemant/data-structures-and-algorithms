from node import Node
from tree_builder import build_tree


def pre_order(root: Node):
    if root is None:
        print(-1, end=" ")
        return
    print(root.data, end=" ")
    pre_order(root.left)
    pre_order(root.right)


def in_order(root: Node):
    if root is None:
        print(-1, end=" ")
        return
    in_order(root.left)
    print(root.data, end=" ")
    in_order(root.right)


def post_order(root: Node):
    if root is None:
        print(-1, end=" ")
        return
    post_order(root.left)
    post_order(root.right)
    print(root.data, end=" ")


def level_order(root: Node):
    if root is None:
        return
    q = [root, None]
    while len(q) > 1:
        node = q.pop(0)
        if node is None:
            print()
            q.append(None)
            continue
        print(node.data, end=" ")
        if node.left is not None:
            q.append(node.left)
        if node.right is not None:
            q.append(node.right)
    print()


def level_order_2(root: Node):
    if root is None:
        return
    q = [root]
    while len(q) > 0:
        flag = len(q)
        for _ in range(flag):
            node = q.pop(0)
            print(node.data, end=" ")
            if node.left is not None:
                q.append(node.left)
            if node.right is not None:
                q.append(node.right)
        print()


def main():
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    pre_order(root)
    print()
    in_order(root)
    print()
    post_order(root)
    print()
    level_order(root)


if __name__ == "__main__":
    main()
