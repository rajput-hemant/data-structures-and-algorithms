from node import Node
from tree_builder import build_tree
from tree_traversals import pre_order


def serialize(root: Node, arr: list):
    if root is None:
        arr.append(-1)
        return
    arr.append(root.data)
    serialize(root.left, arr)
    serialize(root.right, arr)


index = 0


def deserialize(arr: list) -> Node:
    global index
    if index == len(arr):
        return None
    data = arr[index]
    index += 1
    if data == -1:
        return None
    root = Node(data)
    root.left = deserialize(arr)
    root.right = deserialize(arr)
    return root


def main():
    arr = []
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    serialize(root, arr)
    for i in arr:
        print(i, end=" ")
    print()
    new_root = deserialize(arr)
    pre_order(new_root)
    print()


if __name__ == "__main__":
    main()
