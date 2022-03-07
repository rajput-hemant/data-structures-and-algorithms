#include <iostream>
using namespace std;

int power(int n, int p);
int power2(int n, int p);

int main()
{
    int n, p;
    cout << "Enter the values for X and N i.e x^n -> ";
    cin >> n >> p;
    printf("%d raise to the power %d is -> %d\n", n, p, power2(n, p));
    return 0;
}

int power(int n, int p)
{
    if (p == 0)
        return 1;
    return n * power(n, p - 1);
}

int power2(int n, int p)
{
    if (p == 0)
        return 1;
    if (p % 2 == 0)
        return power2(n, p / 2) * power2(n, p / 2);
    else
        return n * power2(n, p / 2) * power2(n, p / 2);
}
