def take_input():
    return [int(i) for i in input("Enter the Elements -> ").split()]


def sort():
    return int(input("1 for Ascending\n2 for Descending\nChoose -> "))


def print_sorted_array(arr):
    print("Array after Soring -> ", arr)
