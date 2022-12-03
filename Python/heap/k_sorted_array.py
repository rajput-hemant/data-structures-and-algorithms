import priority_queue as pq


def k_sort(arr: list, k):
    for i in range(k + 1):
        pq.add(arr[i])
    idx = 0
    for i in range(k + 1, len(arr)):
        arr[idx] = pq.poll()
        idx += 1
        pq.add(arr[i])
    while not pq.is_empty():
        arr[idx] = pq.poll()
        idx += 1


def main():
    arr = [9, 8, 7, 19, 18]
    k_sort(arr, 3)
    print(arr)


if __name__ == "__main__":
    main()
