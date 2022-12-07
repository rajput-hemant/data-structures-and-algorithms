def max_cuts(n, a, b, c):
    dp = [-1] * (n + 1)
    dp[0] = 0
    for i in range(1, n + 1):
        if i - a >= 0:
            dp[i] = max(dp[i], dp[i - a])
        if i - b >= 0:
            dp[i] = max(dp[i], dp[i - b])
        if i - c >= 0:
            dp[i] = max(dp[i], dp[i - c])
        if dp[i] != -1:
            dp[i] += 1
    return dp[n]


if __name__ == "__main__":
    print(max_cuts(5, 1, 2, 3))
