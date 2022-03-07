#include <iostream>
using namespace std;

int fibonacci(int n, int a, int b);

int main()
{
    int n;
    cout << "Enter the Number -> ";
    cin >> n;
    cout << "Fibonacci Series -> ";
    fibonacci(n, 0, 1);
    return 0;
};

int fibonacci(int n, int a, int b)
{
    if (n < 1)
        return 1;
    cout << a << " ";
    return fibonacci(n - 1, b, a + b);
}