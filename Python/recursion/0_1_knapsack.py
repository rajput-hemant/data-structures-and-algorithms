def knapsack(capacity, weight, cost):
    def _knapsack(capacity, weight, cost, n):
        if n == 0 or capacity == 0:
            return 0
        if weight[n - 1] > capacity:
            return _knapsack(capacity, weight, cost, n - 1)
        return max(
            _knapsack(capacity, weight, cost, n - 1),
            cost[n - 1] + _knapsack(capacity - weight[n - 1], weight, cost, n - 1),
        )

    return _knapsack(capacity, weight, cost, len(weight))


if __name__ == "__main__":
    weight = [5, 4, 6, 3]
    cost = [10, 40, 30, 50]
    print(knapsack(10, weight, cost))
