def longest_common_subsequence(s1, s2):
    return __lcs(s1, s2, len(s1), len(s2))


def __lcs(s1, s2, m, n):
    if m == 0 or n == 0:
        return 0
    if s1[m - 1] == s2[n - 1]:
        return 1 + __lcs(s1, s2, m - 1, n - 1)
    else:
        return max(__lcs(s1, s2, m - 1, n), __lcs(s1, s2, m, n - 1))


if __name__ == "__main__":
    print(longest_common_subsequence("AXYZ", "BAZ"))
