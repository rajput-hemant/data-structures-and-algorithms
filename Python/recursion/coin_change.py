def get_count(coins, amt):
    def _get_count(coins, n, amt):
        if amt == 0:
            return 1
        if n == 0:
            return 0
        count = _get_count(coins, n - 1, amt)
        if coins[n - 1] <= amt:
            count += _get_count(coins, n, amt - coins[n - 1])
        return count

    return _get_count(coins, len(coins), amt)


if __name__ == "__main__":
    print(get_count([2, 3, 5, 6], 10))
