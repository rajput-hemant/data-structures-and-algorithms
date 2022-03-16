def linear_search_iterative(arr: list, num: int) -> int:
    for i in range(0, len(arr)):
        if arr[i] == num:
            return i
    return -1


def __linear_search_recursive(arr: list, num: int, i: int) -> int:
    if i == len(arr):
        return -1
    if arr[i] == num:
        return i
    return __linear_search_recursive(arr, num, i + 1)


def linear_search_recursive(arr: list, num: int) -> int:
    return __linear_search_recursive(arr, num, 0)
