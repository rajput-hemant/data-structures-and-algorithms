#include <iostream>
using namespace std;

int factorial(int n);

int main()
{
    int n;
    cout << "Enter the Number -> ";
    cin >> n;
    printf("Factorial of '%d' is -> '%d'\n", n, factorial(n));
    return 0;
}

int factorial(int n)
{
    if (n == 0 || n == 1)
        return 1;
    return n * factorial(n - 1);
}