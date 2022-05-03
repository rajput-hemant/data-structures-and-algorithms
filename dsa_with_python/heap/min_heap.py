import sys


class min_heap:
    def __init__(self):
        self.heap = []

    # def __init__(self, items: list[int] = []):
    #     self.heap = items
    #     self.build_heap()

    def __left_child(self, index):
        return 2 * index + 1

    def __right_child(self, index):
        return 2 * index + 2

    def __parent(self, index):
        return (index - 1) // 2

    def __swap(self, a, b):
        temp = self.heap[b]
        self.heap[b] = self.heap[a]
        self.heap[a] = temp

    def is_empty(self):
        return len(self.heap) == 0

    def insert(self, item):
        self.heap.append(item)
        i = len(self.heap) - 1
        while i != 0 and self.heap[self.__parent(i)] > self.heap[i]:
            self.__swap(i, self.__parent(i))
            i = self.__parent(i)

    def min_heapify(self, index):
        l_child, r_child, smallest = (
            self.__left_child(index),
            self.__right_child(index),
            index,
        )
        if l_child < len(self.heap) and self.heap[l_child] < self.heap[index]:
            smallest = l_child
        if r_child < len(self.heap) and self.heap[r_child] < self.heap[smallest]:
            smallest = r_child
        if smallest != index:
            self.__swap(index, smallest)
            self.min_heapify(smallest)

    def get_min(self):
        return self.heap[0]

    def extract_min(self):
        if self.is_empty():
            raise Exception("Heap is Empty!")
        if len(self.heap) == 1:
            return self.heap.pop(0)
        self.__swap(0, len(self.heap) - 1)
        self.heap.pop(len(self.heap) - 1)
        self.min_heapify(0)
        return self.heap[len(self.heap) - 1]

    def decrease_key(self, index, new_val):
        if self.heap[index] < new_val:
            raise Exception("Key is larger than the original key")
        self.heap[index] = new_val
        while index != 0 and self.heap[self.__parent(index)] > self.heap[index]:
            self.__swap(index, self.__parent(index))
            index = self.__parent(index)

    def delete(self, index):
        if self.is_empty():
            raise Exception("Heap is Empty!")
        if index > len(self.heap) - 1:
            raise Exception("Index is Out of range!")
        self.decrease_key(index, -sys.maxsize)
        return self.extract_min()

    def build_heap(self):
        bmrmin = len(self.heap) - 2 // 2  # bottom most right most internal node
        for i in range(bmrmin, -1, -1):
            self.min_heapify(i)

    def print_heap(self):
        print("MinHeap -> [", end="")
        for item in self.heap:
            print(item, end=", ")
        print("\b\b]")


if __name__ == "__main__":
    ob = min_heap()
    ob.insert(10)
    ob.insert(4)
    ob.insert(9)
    ob.insert(1)
    ob.insert(7)
    ob.insert(5)
    ob.insert(3)
    ob.print_heap()
    ob.delete(4)
    ob.print_heap()
