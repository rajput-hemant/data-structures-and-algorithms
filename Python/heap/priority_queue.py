from min_heap import min_heap

mh = min_heap()


def is_empty():
    return mh.is_empty()


def size():
    return mh.size()


def add(item):
    mh.insert(item)


def peek():
    if is_empty():
        return None
    return mh.get_min()


def element():
    if is_empty():
        raise Exception("Priority Queue is Empty!")
    return mh.get_min()


def poll():
    if is_empty():
        return None
    return mh.extract_min()


def remove():
    if is_empty():
        raise Exception("Priority Queue is Empty!")
    return mh.extract_min()


if __name__ == "__main__":
    add(10)
    add(20)
    add(15)
    print(peek())
    print(poll())
    print(peek())
    print(poll())
    print(peek())
    print(remove())
    print(poll())
    print(remove())
