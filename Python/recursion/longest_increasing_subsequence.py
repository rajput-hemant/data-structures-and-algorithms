def len_of_lis(arr):
    def _lis(arr, prev, curr):
        if curr == len(arr):
            return 0
        take = 0
        if prev == -1 or arr[curr] > arr[prev]:
            take = 1 + _lis(arr, curr, curr + 1)
        do_not_take = _lis(arr, prev, curr + 1)
        return max(take, do_not_take)

    return _lis(arr, -1, 0)


if __name__ == "__main__":
    print(len_of_lis([1, 4, 2, 4, 7, 6, 8]))
