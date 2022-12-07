def max_cuts(n, a, b, c):
    if n < 0:
        return -1
    if n == 0:
        return 0
    res = 1 + max(
        max_cuts(n - 1, a, b, c),
        max(max_cuts(n - b, a, b, c), max_cuts(n - c, a, b, c)),
    )
    return res


if __name__ == "__main__":
    print(max_cuts(5, 1, 2, 3))
