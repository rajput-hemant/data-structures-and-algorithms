def is_sorted(arr, i: int, choice: int) -> bool:
    if i == len(arr) - 1:
        return True
    # For Strictly Ascending
    if choice == 1:
        return is_sorted(arr, i + 1, choice) if arr[i] < arr[i + 1] else False
    # For Strictly Descending
    return is_sorted(arr, i + 1, choice) if arr[i] > arr[i + 1] else False


def main():
    arr = []
    n = int(input("Enter the lenght of the Array -> "))
    for _ in range(0, n):
        arr.append(int(input()))
    choice = int(
        input(
            "In which order do you want to check if Array is sorted or not?\n"
            "1 for Ascending\n"
            "2 for Descending\n-> "
        )
    )
    print(f"Is Array Sorted? -> {is_sorted(arr, 0, choice)}")


if __name__ == "__main__":
    main()
