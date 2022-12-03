# Stack Height -> n
def power(n: int, p: int) -> int:
    if p == 0:
        return 1
    return n * power(n, p - 1)


# Stack Height -> logn
def power2(n: int, p: int) -> int:
    if p == 0:
        return 1
    return (
        (power2(n, p // 2) * power2(n, p // 2))
        if (p % 2 == 0)
        else (n * power2(n, p // 2) * power2(n, p // 2))
    )


def main():
    n = int(input("Enter the Numbr -> "))
    p = int(input("Enter the Power -> "))
    print(f"{n} raise to power {p} is -> {power2(n, p)}")


if __name__ == "__main__":
    main()
