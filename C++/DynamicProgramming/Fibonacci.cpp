#include <iostream>
using namespace std;

class Fibonacci
{

public:
  int fibonacciMemoization(int n)
  {
    int memo[n + 1];
    fill(memo, memo + n + 1, -1);
    return fibMemo(n, memo);
  }

  int fibonacciTabulation(int n)
  {
    if (n == 0 || n == 1)
      return n;
    int dp[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i < n + 1; i++)
      dp[i] = dp[i - 1] + dp[i - 2];
    return dp[n];
  }

private:
  int fibMemo(int n, int memo[])
  {
    if (memo[n] == -1)
    {
      if (n == 0 || n == 1)
        return n;
      int res = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
      memo[n] = res;
    }
    return memo[n];
  }
};

int main()
{
  Fibonacci ob;
  cout << ob.fibonacciMemoization(5) << endl;
  cout << ob.fibonacciTabulation(5) << endl;
  return 0;
}