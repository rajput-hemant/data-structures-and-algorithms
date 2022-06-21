def factorial(n: int) -> int:
    if n == 0 or n == 1:
        return 1
    return n * factorial(n - 1)


n = int(input("Enter the Number -> "))
print(f"Factorial of '{n}' is -> '{factorial(n)}'")
