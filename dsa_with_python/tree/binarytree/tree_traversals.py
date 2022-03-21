from node import Node
from tree_builder import build_tree


class Traversals:
    def pre_order(self, root: Node):
        if root == None:
            print(-1, end=" ")
            return
        print(root.data, end=" ")
        self.pre_order(root.left)
        self.pre_order(root.right)

    def in_order(self, root: Node):
        if root == None:
            print(-1, end=" ")
            return
        self.in_order(root.left)
        print(root.data, end=" ")
        self.in_order(root.right)

    def post_order(self, root: Node):
        if root == None:
            print(-1, end=" ")
            return
        self.post_order(root.left)
        self.post_order(root.right)
        print(root.data, end=" ")

    def level_order(self, root: Node):
        if root == None:
            return
        q = []
        q.append(root)
        while len(q) > 0:
            print(q[0].data, end=" ")
            node = q.pop(0)
            if node.left is not None:
                q.append(node.left)
            if node.right is not None:
                q.append(node.right)


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
