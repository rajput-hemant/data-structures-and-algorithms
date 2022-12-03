from node import Node
from tree_builder import build_tree

prev_node = None


def convert_binary_tree_to_doubly_linked_list(root: Node) -> Node:
    global prev_node
    if root is None:
        return root
    head = convert_binary_tree_to_doubly_linked_list(root.left)
    if prev_node is None:
        head = root
    else:
        root.left = prev_node
        prev_node.right = root
    prev_node = root
    convert_binary_tree_to_doubly_linked_list(root.right)
    return head


def __display(root: Node):
    if root is None:
        print("List is Empty!")
        return
    print("[", end="")
    current_node = root
    while current_node is not None:
        print(f"{current_node.data}, ", end="")
        current_node = current_node.right
    print("\b\b]")


def main():
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
    root = build_tree(nodes)
    new_node = convert_binary_tree_to_doubly_linked_list(root)
    __display(new_node)


if __name__ == "__main__":
    main()
