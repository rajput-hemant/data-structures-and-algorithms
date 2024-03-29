# Given an input string S and two characters char1 and char2,
# you need to replace every occurrence of character c1
# with character c2 in the given string. Do this recursively.

# Sample Input :
# abaca
# a x
# Sample Output :
# xbxcd


def char_replace(str_: list, i: int, a: str, b: str, new_str: str) -> str:
    if len(str_) == i:
        print(new_str)
        return
    if str_[i] == a:
        new_str += b
    else:
        new_str += str_[i]
    char_replace(str_, i + 1, a, b, new_str)


def main():
    str_ = list(input("Enter the String -> "))
    new_str = ""
    print(len(str_))
    a = input("Enter the two characters -> ")
    b = input()
    print(f"String after replacing '{a}' with '{b}' -> ", end="")
    char_replace(str_, 0, a, b, new_str)


if __name__ == "__main__":
    main()
