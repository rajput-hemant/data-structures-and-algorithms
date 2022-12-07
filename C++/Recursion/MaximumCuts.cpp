#include <bits/stdc++.h>
using namespace std;

int maxCuts(int n, int a, int b, int c)
{
  if (n < 0)
    return -1;
  if (n == 0)
    return 0;
  int res = 1 + max(maxCuts(n - a, a, b, c),
                    max(maxCuts(n - b, a, b, c), maxCuts(n - c, a, b, c)));
  return res;
}

int main()
{
  cout << maxCuts(5, 1, 2, 3) << endl;
}
