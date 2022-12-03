from queue import PriorityQueue

pq = PriorityQueue()


def k_closest_elements(arr, x, k):
    for i in range(k):
        pq.put((-abs(arr[i] - x), i))
    for i in range(k, len(arr)):
        diff = abs(arr[i] - x)
        top, top_index = pq.get()
        if -top < diff:
            pq.put((top, top_index))
        else:
            pq.put((-diff, i))
    while not pq.empty():
        top, top_index = pq.get()
        print(arr[top_index], end=" ")
    print()


def main():
    arr = [30, 40, 32, 33, 36, 37]
    x, k = 38, 3
    k_closest_elements(arr, x, k)


if __name__ == "__main__":
    main()
