import sys


def min_coins(coins, target):
    dp = [sys.maxsize] * (target + 1)
    dp[0] = 0
    for i in range(1, target + 1):
        for coin in coins:
            if coin <= i:
                rem_target = 1 + dp[i - coin]
                if rem_target != sys.maxsize:
                    dp[i] = min(dp[i], rem_target)
    return dp[target]


if __name__ == "__main__":
    print(min_coins([10, 5, 25], 30))
