def factorial(n: int) -> int:
    if n in (0, 1):
        return 1
    return n * factorial(n - 1)


def main():
    n = int(input("Enter the Number -> "))
    print(f"Factorial of '{n}' is -> '{factorial(n)}'")


if __name__ == "__main__":
    main()
