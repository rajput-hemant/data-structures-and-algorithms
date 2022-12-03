import priority_queue as pq


def k_largest_elements(arr, k):
    for i in range(k):
        pq.add(arr[i])
    for i in range(k, len(arr)):
        if arr[i] > pq.peek():
            pq.poll()
            pq.add(arr[i])
    while not pq.is_empty():
        print(pq.poll(), end=" ")
    print()


def main():
    arr = [5, 15, 10, 20, 8, 25, 18]
    k_largest_elements(arr, 3)


if __name__ == "__main__":
    main()
