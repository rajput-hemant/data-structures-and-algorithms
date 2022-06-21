import priority_queue as pq


def max_item_using_sorted_array(arr, sum):
    count = 0
    for i in sorted(arr):
        if i > sum:
            return count
        count += 1
        sum -= i
    return count


def max_item_using_heap(arr, sum):
    for i in arr:
        pq.add(i)
    count = 0
    while not pq.is_empty() and pq.peek() <= sum:
        sum -= pq.poll()
        count += 1
    return count


if __name__ == "__main__":
    arr = [1, 12, 5, 111, 200]
    print(max_item_using_sorted_array(arr, 11))
    print(max_item_using_heap(arr, 11))
