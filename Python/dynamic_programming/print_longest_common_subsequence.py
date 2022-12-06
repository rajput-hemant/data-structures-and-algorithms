def print_lcs(str1, str2):
    m, n = len(str1), len(str2)
    dp = [[None] * (n + 1) for _ in range(m + 1)]
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 or j == 0:
                dp[i][j] = 0
            elif str1[i - 1] == str2[j - 1]:
                dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    i, j = m, n
    res = ""
    while i > 0 and j > 0:
        if str1[i - 1] == str2[j - 1]:
            res += str1[i - 1]
            i -= 1
            j -= 1
        elif dp[i - 1][j] > dp[i][j - 1]:
            i -= 1
        else:
            j -= 1
    print(res[::-1])


if __name__ == "__main__":
    print_lcs("AXYZ", "BAZ")
