def get_count(coins, amt):
    def _get_count(coins, n, amt):
        dp = [[None] * (n + 1) for _ in range(amt + 1)]

        for i in range(n + 1):
            dp[0][i] = 1
        for i in range(amt + 1):
            dp[i][0] = 0
        for i in range(1, amt + 1):
            for j in range(1, n + 1):
                dp[i][j] = dp[i][j - 1]
                if coins[j - 1] <= i:
                    dp[i][j] += dp[i - coins[j - 1]][j]
        return dp[amt][n]

    return _get_count(coins, len(coins), amt)


if __name__ == "__main__":
    print(get_count([2, 3, 5, 6], 10))
