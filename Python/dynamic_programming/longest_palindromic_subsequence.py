from longest_common_subsequence import longest_common_subsequence_tabular as lcs


def longest_palindromic_pubsequence(str_):
    return lcs(str_, str_[::-1])


if __name__ == "__main__":
    print(longest_palindromic_pubsequence("saippuakivikauppias"))
