def binary_search_iterative(arr: list, num: int) -> int:
    return __binary_search_iterate(arr, num, 0, len(arr) - 1)


def binary_search_recursive(arr: list, num: int) -> int:
    return __binary_search_rec(arr, num, 0, len(arr) - 1)


def __binary_search_iterate(arr: list, num: int, begin: int, end: int) -> int:
    while begin <= end:
        mid = (begin + end) // 2
        if arr[mid] < num:
            begin = mid + 1
        elif arr[mid] > num:
            end = mid - 1
        else:
            return mid
    return -1


def __binary_search_rec(arr: list, num: int, begin: int, end: int) -> int:
    if begin > end:
        return -1
    mid = (begin + end) // 2
    if arr[mid] == num:
        return mid
    if arr[mid] > num:
        return __binary_search_rec(arr, num, begin, mid - 1)
    else:
        return __binary_search_rec(arr, num, mid + 1, end)
