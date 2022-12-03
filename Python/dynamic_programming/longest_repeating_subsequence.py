def longest_repeating_subsequence(str_):
    _len = len(str_)
    dp = [[None] * (_len + 1) for _ in range(_len + 1)]
    for i in range(_len + 1):
        for j in range(_len + 1):
            if i == 0 or j == 0:
                dp[i][j] = 0
            elif str_[i - 1] == str_[j - 1] and i != j:
                dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return dp[_len][_len]


if __name__ == "__main__":
    print(longest_repeating_subsequence("rajput-hemant"))
