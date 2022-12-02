def fibonacci_memoization(n: int) -> int:
    memo = [-1] * (n + 1)
    return __fib_memo(n, memo)


def __fib_memo(n: int, memo: list) -> int:
    if memo[n] == -1:
        res = 0
        if n == 0 or n == 1:
            res = n
        else:
            res = __fib_memo(n - 1, memo) + __fib_memo(n - 2, memo)
        memo[n] = res
    return memo[n]


def fibonacci_tabulation(n: int) -> int:
    dp = [-1] * (n + 1)
    dp[0] = 0
    dp[1] = 1
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]
    return dp[n]


if __name__ == "__main__":
    print(fibonacci_memoization(5))
    print(fibonacci_tabulation(5))