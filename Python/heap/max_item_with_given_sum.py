import priority_queue as pq


def max_item_using_sorted_array(arr, sum_):
    count = 0
    for i in sorted(arr):
        if i > sum_:
            return count
        count += 1
        sum_ -= i
    return count


def max_item_using_heap(arr, sum_):
    for i in arr:
        pq.add(i)
    count = 0
    while not pq.is_empty() and pq.peek() <= sum_:
        sum_ -= pq.poll()
        count += 1
    return count


def main():
    arr = [1, 12, 5, 111, 200]
    print(max_item_using_sorted_array(arr, 11))
    print(max_item_using_heap(arr, 11))


if __name__ == "__main__":
    main()
