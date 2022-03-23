from node import Node

index = -1


def build_tree(nodes: list) -> Node:
    global index
    index += 1
    if nodes[index] == -1:
        return None
    new_node = Node(nodes[index])
    new_node.left = build_tree(nodes)
    new_node.right = build_tree(nodes)
    return new_node


if __name__ == "__main__":
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    print(root.data)
