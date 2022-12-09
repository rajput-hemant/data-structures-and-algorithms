#include <bits/stdc++.h>
using namespace std;

int knapsack(int capacity, int weight[], int cost[], int n)
{
  if (n == 0 || capacity == 0)
    return 0;
  if (weight[n - 1] > capacity)
    return knapsack(capacity, weight, cost, n - 1);
  else
    return max(knapsack(capacity, weight, cost, n - 1),
               cost[n - 1] + knapsack(capacity - weight[n - 1], weight, cost, n - 1));
}

int main()
{

  int weight[] = {5, 4, 6, 3};
  int cost[] = {10, 40, 30, 50};
  int n = sizeof(weight) / sizeof(weight[0]);
  cout << knapsack(10, weight, cost, n) << endl;
}