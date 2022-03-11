first = last = -1


def find_first_and_last_occurance(str: str, i: int, char: str):
    global first, last
    if i == len(str) - 1:
        print(f"First & Last Occurance of character {char} are {first} and {last} respectively.")
        return
    if char == str[i]:
        if first == -1:
            first = last = i
        else:
            last = i
    find_first_and_last_occurance(str, i + 1, char)


str = input("Enter the String -> ")
char = input("Enter the Character you want to track -> ")
find_first_and_last_occurance(str, 0, char)
