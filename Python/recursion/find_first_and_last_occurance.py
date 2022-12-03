first = last = -1


def find_first_and_last_occurance(str_: str, i: int, char: str):
    global first, last
    if i == len(str_) - 1:
        print(
            f"First & Last Occurance of character {char} are {first} and {last} respectively."
        )
        return
    if char == str_[i]:
        if first == -1:
            first = last = i
        else:
            last = i
    find_first_and_last_occurance(str_, i + 1, char)


def main():
    str_ = input("Enter the String -> ")
    char = input("Enter the Character you want to track -> ")
    find_first_and_last_occurance(str_, 0, char)


if __name__ == "__main__":
    main()
