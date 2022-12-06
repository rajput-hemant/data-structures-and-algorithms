def longest_common_subsequence_memoization(s1, s2):
    m, n = len(s1), len(s2)
    memo = [[-1 for x in range(m + 2)] for _ in range(n + 2)]
    return __lcs_memo(s1, s2, m, n, memo)


def __lcs_memo(s1, s2, m, n, memo) -> int:
    if memo[m][n] != -1:
        return memo[m][n]
    if m == 0 or n == 0:
        memo[m][n] = 0
    else:
        if s1[m - 1] == s2[n - 1]:
            memo[m][n] = 1 + __lcs_memo(s1, s2, m - 1, n - 1, memo)
        else:
            memo[m][n] = max(
                __lcs_memo(s1, s2, m - 1, n, memo), __lcs_memo(s1, s2, m, n - 1, memo)
            )
    return memo[m][n]


def longest_common_subsequence_tabular(s1, s2):
    m, n = len(s1), len(s2)
    dp = [[None] * (n + 1) for _ in range(m + 1)]
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 or j == 0:
                dp[i][j] = 0
            elif s1[i - 1] == s2[j - 1]:
                dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return dp[m][n]


def longest_common_subsequence(s1, s2):
    m, n = len(s1), len(s2)
    dp = [[None] * (n + 1)] * 2
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 or j == 0:
                dp[i % 2][j] = 0
            elif s1[i - 1] == s2[j - 1]:
                dp[i % 2][j] = 1 + dp[(i + 1) % 2][j - 1]
            else:
                dp[i % 2][j] = max(dp[(i + 1) % 2][j], dp[i % 2][j - 1])
    return dp[m % 2][n]


if __name__ == "__main__":
    print(longest_common_subsequence("AXYZ", "BAZ"))
    print(longest_common_subsequence_memoization("AXYZ", "BAZ"))
    print(longest_common_subsequence_tabular("AXYZ", "BAZ"))
