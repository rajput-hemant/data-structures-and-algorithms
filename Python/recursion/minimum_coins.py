import sys


def min_coins(coins, target):
    if target == 0:
        return 0
    res = sys.maxsize
    for coin in coins:
        if coin <= target:
            rem_target = 1 + min_coins(coins, target - coin)
            if rem_target != sys.maxsize:
                res = min(res, rem_target)
    return res


if __name__ == "__main__":
    print(min_coins([10, 25, 5], 30))
