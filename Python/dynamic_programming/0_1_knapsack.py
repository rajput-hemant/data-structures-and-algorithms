def knapsack(capacity, weight, cost):
    def _knapsack(capacity, weight, cost, n):
        dp = [[0] * (capacity + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, capacity + 1):
                weight_index = i - 1
                if weight[weight_index] > j:
                    dp[i][j] = dp[weight_index][j]
                else:
                    dp[i][j] = max(
                        dp[weight_index][j],
                        cost[weight_index] + dp[weight_index][j - weight[weight_index]],
                    )
        return dp[n][capacity]

    return _knapsack(capacity, weight, cost, len(weight))


if __name__ == "__main__":
    weight = [5, 4, 6, 3]
    cost = [10, 40, 30, 50]
    print(knapsack(10, weight, cost))
