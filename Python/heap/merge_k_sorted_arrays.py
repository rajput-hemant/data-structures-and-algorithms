from queue import PriorityQueue


class Triplet:
    def __init__(self, element, arr_position, ele_position):
        self.element = element
        self.arr_position = arr_position
        self.ele_position = ele_position

    def __lt__(self, other):
        return self.element < other.element

    # def __eq__(self, other):
    #     return self.element == other.element

    # def __le__(self, other):
    #     return self.element <= other.element

    # def __ge__(self, other):
    #     return self.element >= other.element

    # def __ne__(self, other):
    #     return self.element != other.element


def merge_k_sorted_arrays(arr):
    res = []
    pq = PriorityQueue()
    for i in range(len(arr)):
        pq.put(Triplet(arr[i][0], i, 0))
    while not pq.empty():
        curr = pq.get()
        res.append(curr.element)
        arr_pos, ele_pos = curr.arr_position, curr.ele_position
        if ele_pos + 1 < len(arr[arr_pos]):
            pq.put(Triplet(arr[arr_pos][ele_pos + 1], arr_pos, ele_pos + 1))
    return res


if __name__ == "__main__":
    arr = [[5, 10], [4, 9], [5, 6]]
    print(merge_k_sorted_arrays(arr))
