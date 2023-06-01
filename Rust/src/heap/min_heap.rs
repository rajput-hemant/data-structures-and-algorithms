pub struct MinHeap<T> {
    heap: Vec<T>,
}

impl<T: Ord> MinHeap<T> {
    /// Create a new empty `MinHeap`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let heap: MinHeap<i64> = MinHeap::new();
    /// ```
    pub fn new() -> Self {
        MinHeap { heap: Vec::new() }
    }

    /// Get the index of the left child of the node at the given index.
    ///
    /// # Arguments
    /// * `index` - The index of the node whose left child is to be found.
    ///
    /// # Returns
    /// The index of the left child of the node at the given index, or `None` if the node has no left child.
    fn left_child(&self, index: usize) -> Option<usize> {
        let left = 2 * index + 1;
        if left < self.heap.len() {
            Some(left)
        } else {
            None
        }
    }

    /// Get the index of the right child of the node at the given index.
    ///
    /// # Arguments
    /// * `index` - The index of the node whose right child is to be found.
    ///
    /// # Returns
    /// The index of the right child of the node at the given index, or `None` if the node has no right child.
    fn right_child(&self, index: usize) -> Option<usize> {
        let right = 2 * index + 2;
        if right < self.heap.len() {
            Some(right)
        } else {
            None
        }
    }

    /// Get the index of the parent of the node at the given index.
    ///
    /// # Arguments
    /// * `index` - The index of the node whose parent is to be found.
    ///
    /// # Returns
    /// The index of the parent of the node at the given index, or `None` if the node has no parent.
    fn parent(&self, index: usize) -> Option<usize> {
        if index > 0 {
            Some((index - 1) / 2)
        } else {
            None
        }
    }

    /// Get the number of elements in the `MinHeap`.
    ///
    /// # Returns
    /// The number of elements in the `MinHeap`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let mut heap = MinHeap::new();
    ///
    /// assert_eq!(heap.size(), 0);
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///
    /// assert_eq!(heap.size(), 3);
    /// ```
    pub fn size(&self) -> usize {
        self.heap.len()
    }

    /// Check if the `MinHeap` is empty.
    ///
    /// # Returns
    /// `true` if the `MinHeap` is empty, `false` otherwise.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let mut heap = MinHeap::new();
    ///
    /// assert!(heap.is_empty());
    ///
    /// heap.push(1);
    ///
    /// assert!(!heap.is_empty());
    /// ```
    pub fn is_empty(&self) -> bool {
        self.heap.is_empty()
    }

    /// Insert a value into the `MinHeap`.
    ///
    /// # Arguments
    /// * `value` - The value to be inserted into the `MinHeap`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let mut heap = MinHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    /// ```
    pub fn push(&mut self, value: T) {
        // Add the value to the end of the heap.
        self.heap.push(value);

        let mut index = self.heap.len() - 1;

        // iterate up the heap, swapping the value of the current node with its parent if the parent is larger
        // or until the root is reached.
        while let Some(parent) = self.parent(index) {
            if self.heap[parent] > self.heap[index] {
                self.heap.swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    /// Restore the `MinHeap` property at the given index.
    ///
    /// # Arguments
    /// * `index` - The index at which to restore the `MinHeap` property.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let mut heap = MinHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///
    /// heap.min_heapify(0);
    /// ```
    pub fn min_heapify(&mut self, index: usize) {
        // initialize the index of the smallest node
        let mut smallest = index;

        // check if the left child is smaller than the current node
        // if so, set the index of the smallest node to the index of the left child
        if let Some(left) = self.left_child(index) {
            if self.heap[left] < self.heap[smallest] {
                smallest = left;
            }
        }

        // check if the right child is smaller than the current node
        // if so, set the index of the smallest node to the index of the right child
        if let Some(right) = self.right_child(index) {
            if self.heap[right] < self.heap[smallest] {
                smallest = right;
            }
        }

        // if the smallest node is not the current node,
        // swap the values of the current node and the smallest node
        // and recursively call min_heapify on the smallest node

        if smallest != index {
            self.heap.swap(index, smallest);
            self.min_heapify(smallest);
        }
    }

    /// Extract the minimum value from the `MinHeap`.
    ///
    /// # Returns
    /// The minimum value in the `MinHeap`, or `None` if the `MinHeap` is empty.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let mut heap = MinHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///
    /// assert_eq!(heap.extract_min(), Some(1));
    /// ```
    pub fn extract_min(&mut self) -> Option<T> {
        if self.heap.is_empty() {
            return None;
        }

        // swap the minimum value with the last value in the heap and remove the last value
        let min = self.heap.swap_remove(0);

        // restore the heap property at the root
        if !self.heap.is_empty() {
            self.min_heapify(0);
        }

        Some(min)
    }

    /// Get the minimum value in the `MinHeap`.
    ///
    /// # Returns
    /// The minimum value in the `MinHeap`, or `None` if the `MinHeap` is empty.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let mut heap = MinHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///
    /// assert_eq!(heap.get_min(), Some(&1));
    /// ```
    pub fn get_min(&self) -> Option<&T> {
        self.heap.first()
    }

    /// Remove the element at the given index from the `MinHeap`.
    ///
    /// # Arguments
    /// * `index` - The index of the element to be removed.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let mut heap = MinHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///
    /// heap.remove(1);
    ///
    /// assert_eq!(heap.size(), 2);
    ///
    /// assert_eq!(heap.get_min(), Some(&1));
    /// ```
    pub fn remove(&mut self, index: usize) {
        // swap the element at the given index with the last element in the heap and remove the last element,
        // hence removing min element
        self.heap.swap_remove(index);

        // restore the heap property at the given index
        if !self.heap.is_empty() {
            self.min_heapify(index);
        }
    }

    /// Build a `MinHeap` from the elements in the `MinHeap`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let mut heap = MinHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///     
    /// heap.build_heap();
    ///
    /// assert_eq!(heap.get_min(), Some(&1));
    /// ```
    pub fn build_heap(&mut self) {
        let bmrmin_index = self.size() / 2 - 1;

        for i in (0..=bmrmin_index).rev() {
            self.min_heapify(i);
        }
    }
}

impl<T: Ord> From<Vec<T>> for MinHeap<T> {
    /// Create a new `MinHeap` from a `Vec`.
    ///
    /// # Arguments
    /// * `vec` - A `Vec` of elements to be inserted into the `MinHeap`.
    ///
    /// # Returns
    /// A new `MinHeap` containing the elements of `vec`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::min_heap::MinHeap;
    ///
    /// let heap = MinHeap::from(vec![1, 4, 3, 2, 5]);
    /// ```
    fn from(vec: Vec<T>) -> Self {
        let mut heap = MinHeap { heap: vec };

        heap.build_heap();

        heap
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_min_heap() {
        let mut heap = MinHeap::new();

        assert!(heap.is_empty());

        heap.push(1);
        heap.push(4);
        heap.push(2);
        heap.push(5);
        heap.push(13);
        heap.push(6);
        heap.push(17);

        assert_eq!(heap.size(), 7);
        assert_eq!(heap.get_min(), Some(&1));

        assert_eq!(heap.extract_min(), Some(1));
        assert_eq!(heap.extract_min(), Some(2));
        assert_eq!(heap.extract_min(), Some(4));
        assert_eq!(heap.extract_min(), Some(5));
        assert_eq!(heap.extract_min(), Some(6));
        assert_eq!(heap.extract_min(), Some(13));
        assert_eq!(heap.extract_min(), Some(17));
        assert_eq!(heap.extract_min(), None);

        heap.push(1);
        heap.push(4);
        heap.push(3);
        heap.push(2);
        heap.push(5);

        assert_eq!(heap.extract_min(), Some(1));
        assert_eq!(heap.extract_min(), Some(2));
        assert_eq!(heap.extract_min(), Some(3));

        heap.push(1);
        heap.push(2);

        assert_eq!(heap.extract_min(), Some(1));
        assert_eq!(heap.extract_min(), Some(2));
        assert_eq!(heap.extract_min(), Some(4));
        assert_eq!(heap.extract_min(), Some(5));
        assert_eq!(heap.extract_min(), None);
    }

    #[test]
    fn test_min_heap_from_vec() {
        let heap = MinHeap::from(vec![1, 4, 3, 2, 5]);

        assert_eq!(heap.size(), 5);
        assert_eq!(heap.get_min(), Some(&1));
    }

    #[test]
    fn test_min_heap_build_heap() {
        let mut heap = MinHeap::from(vec![1, 4, 3, 2, 5]);

        heap.build_heap();

        assert_eq!(heap.size(), 5);
        assert_eq!(heap.get_min(), Some(&1));
    }

    #[test]
    fn test_min_heap_remove() {
        let mut heap = MinHeap::from(vec![1, 4, 3, 2, 5]);

        heap.remove(2);

        assert_eq!(heap.size(), 4);
        assert_eq!(heap.get_min(), Some(&1));
    }
}
