def len_of_lis_optimized(arr):
    def _ceil_index(tail, left, right, x):
        while left < right:
            mid = left + (right - left) // 2
            if tail[mid] >= x:
                right = mid
            else:
                left = mid + 1
        return right

    tail = [arr[0]]
    for i in range(1, len(arr)):
        if arr[i] > tail[-1]:
            tail.append(arr[i])
        else:
            ceil_idx = _ceil_index(tail, 0, len(tail) - 1, arr[i])
            tail[ceil_idx] = arr[i]
    return len(tail)


def len_of_lis(arr):
    lis = [None] * len(arr)
    lis[0] = 1
    for i in range(1, len(arr)):
        lis[i] = 1
        for j in range(i):
            if arr[i] > arr[j]:
                lis[i] = max(lis[i], lis[j] + 1)
    res = lis[0]
    for i in lis:
        res = max(res, i)
    return res


if __name__ == "__main__":
    print(len_of_lis([10, 5, 18, 7, 2, 9]))
    print(len_of_lis_optimized([10, 5, 18, 7, 2, 9]))
