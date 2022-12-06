def length_of_LIS(arr):
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
    print(length_of_LIS([10, 5, 18, 7, 2, 9]))
