#include <bits/stdc++.h>
using namespace std;

int getCount(int coins[], int n, int amount)
{
  if (amount == 0)
    return 1;
  if (n == 0)
    return 0;
  int count = getCount(coins, n - 1, amount);
  if (coins[n - 1] <= amount)
    count += getCount(coins, n, amount - coins[n - 1]);
  return count;
}

// int main()
// {
//   int coins[] = {2, 3, 5, 6},
//       n = sizeof(coins) / sizeof(coins[0]);
//   cout << getCount(coins, n, 10) << endl;
// }
