from node import Node


def findTarget(root: Node, k: int) -> bool:
    def __is_pair_sum(root: Node, lst: list, k: int) -> list:
        if root:
            __is_pair_sum(root.left, lst, k)
            lst.append(root.data)
            __is_pair_sum(root.right, lst, k)
        return lst

    lst = []
    lst = __is_pair_sum(root, lst, k)
    head, tail = 0, len(lst) - 1
    while head < tail:
        if lst[head] + lst[tail] == k:
            return True
        if lst[head] + lst[tail] < k:
            head += 1
        elif lst[head] + lst[tail] > k:
            tail += 1
    return False
