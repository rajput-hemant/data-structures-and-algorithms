from node import Node
from tree_builder import build_tree


class Traversals:
    def pre_order(self, root: Node):
        if root is None:
            print(-1, end=" ")
            return
        print(root.data, end=" ")
        self.pre_order(root.left)
        self.pre_order(root.right)

    def in_order(self, root: Node):
        if root is None:
            print(-1, end=" ")
            return
        self.in_order(root.left)
        print(root.data, end=" ")
        self.in_order(root.right)

    def post_order(self, root: Node):
        if root is None:
            print(-1, end=" ")
            return
        self.post_order(root.left)
        self.post_order(root.right)
        print(root.data, end=" ")

    def level_order(self, root: Node):
        if root is None:
            return
        q = []
        q.append(root)
        q.append(None)
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

    def level_order_2(self, root: Node):
        if root is None:
            return
        q = []
        q.append(root)
        while len(q) > 0:
            flag = len(q)
            for i in range(flag):
                node = q.pop(0)
                print(node.data, end=" ")
                if node.left is not None:
                    q.append(node.left)
                if node.right is not None:
                    q.append(node.right)
            print()


if __name__ == "__main__":
    ob = Traversals()
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    ob.pre_order(root)
    print()
    ob.in_order(root)
    print()
    ob.post_order(root)
    print()
    ob.level_order(root)
