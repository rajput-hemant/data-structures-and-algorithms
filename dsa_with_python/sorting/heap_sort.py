from sort_helper import *


def heap_sort(arr, sort):
    __build_heap(arr, sort)
    for i in range(len(arr) - 1, -1, -1):
        arr[0], arr[i] = arr[i], arr[0]
        if sort == 1:
            __max_heapify(arr, i, 0)
        else:
            __min_heapify(arr, i, 0)


def __build_heap(arr, sort):
    bmrmin = len(arr) - 2 // 2  # bottom most right most internal node
    for i in range(bmrmin, -1, -1):
        # For sorting in Ascending Order
        if sort == 1:
            __max_heapify(arr, len(arr), i)
        # For sorting in Descending Order
        else:
            __min_heapify(arr, len(arr), i)


def __max_heapify(arr, n, index):
    l_child, r_child, largest = (
        2 * index + 1,
        2 * index + 2,
        index,
    )
    if l_child < n and arr[l_child] > arr[largest]:
        largest = l_child
    if r_child < n and arr[r_child] > arr[largest]:
        largest = r_child
    if largest != index:
        arr[index], arr[largest] = arr[largest], arr[index]
        __max_heapify(arr, n, largest)


def __min_heapify(arr, n, index):
    l_child, r_child, smallest = (
        2 * index + 1,
        2 * index + 2,
        index,
    )
    if l_child < n and arr[l_child] < arr[index]:
        smallest = l_child
    if r_child < n and arr[r_child] < arr[smallest]:
        smallest = r_child
    if smallest != index:
        arr[index], arr[smallest] = arr[smallest], arr[index]
        __min_heapify(arr, n, smallest)


if __name__ == "__main__":
    arr = take_input()
    heap_sort(arr, sort())
    print_sorted_array(arr)
