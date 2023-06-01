pub struct MaxHeap<T> {
    heap: Vec<T>,
}

impl<T: Ord> MaxHeap<T> {
    /// Create a new empty `MaxHeap`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let heap: MaxHeap<i64> = MaxHeap::new();
    /// ```
    pub fn new() -> Self {
        MaxHeap { heap: Vec::new() }
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

    /// Get the number of elements in the `MaxHeap`.
    ///
    /// # Returns
    /// The number of elements in the `MaxHeap`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let mut heap = MaxHeap::new();
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

    /// Check if the `MaxHeap` is empty.
    ///
    /// # Returns
    /// `true` if the `MaxHeap` is empty, `false` otherwise.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let mut heap = MaxHeap::new();
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

    /// Insert a value into the `MaxHeap`.
    ///
    /// # Arguments
    /// * `value` - The value to be inserted into the `MaxHeap`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let mut heap = MaxHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    /// ```
    pub fn push(&mut self, value: T) {
        // Add the value to the end of the heap.
        self.heap.push(value);

        let mut index = self.heap.len() - 1;

        // iterate up the heap, swapping the value of the current node with its parent if the parent is smaller
        // or until the root is reached.
        while let Some(parent) = self.parent(index) {
            if self.heap[index] > self.heap[parent] {
                self.heap.swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    /// Restore the `MaxHeap` property at the given index.
    ///
    /// # Arguments
    /// * `index` - The index at which to restore the `MaxHeap` property.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let mut heap = MaxHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///
    /// heap.max_heapify(0);
    /// ```
    pub fn max_heapify(&mut self, index: usize) {
        // initialize the index of the largest node
        let mut largest = index;

        // check if the left child is larger than the current node
        // if so, set the index of the largest node to the index of the left child
        if let Some(left) = self.left_child(index) {
            if self.heap[left] > self.heap[largest] {
                largest = left;
            }
        }

        // check if the right child is larger than the current node
        // if so, set the index of the largest node to the index of the right child
        if let Some(right) = self.right_child(index) {
            if self.heap[right] > self.heap[largest] {
                largest = right;
            }
        }

        // if the largest node is not the current node,
        // swap the values of the current node and the largest node
        // and recursively call max_heapify on the largest node

        if largest != index {
            self.heap.swap(index, largest);
            self.max_heapify(largest);
        }
    }

    /// Extract the maximum value from the `MaxHeap`.
    ///
    /// # Returns
    /// The maximum value in the `MaxHeap`, or `None` if the `MaxHeap` is empty.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let mut heap = MaxHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///
    /// assert_eq!(heap.extract_max(), Some(3));
    /// ```
    pub fn extract_max(&mut self) -> Option<T> {
        if self.heap.is_empty() {
            return None;
        }

        // swap the maximum value with the last value in the heap and remove the last value
        let max = self.heap.swap_remove(0);

        // restore the heap property at the root
        if !self.heap.is_empty() {
            self.max_heapify(0);
        }

        Some(max)
    }

    /// Get the maximum value in the `MaxHeap`.
    ///
    /// # Returns
    /// The maximum value in the `MaxHeap`, or `None` if the `MaxHeap` is empty.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let mut heap = MaxHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///
    /// assert_eq!(heap.get_max(), Some(&3));
    /// ```
    pub fn get_max(&self) -> Option<&T> {
        self.heap.first()
    }

    /// Remove the element at the given index from the `MaxHeap`.
    ///
    /// # Arguments
    /// * `index` - The index of the element to be removed.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let mut heap = MaxHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///
    /// heap.remove(1);
    ///
    /// assert_eq!(heap.size(), 2);
    ///
    /// assert_eq!(heap.get_max(), Some(&3));
    /// ```
    pub fn remove(&mut self, index: usize) {
        // swap the element at the given index with the last element in the heap and remove the last element,
        // hence removing max element
        self.heap.swap_remove(index);

        // restore the heap property at the given index
        if !self.heap.is_empty() {
            self.max_heapify(index);
        }
    }

    /// Build a `MaxHeap` from the elements in the `MaxHeap`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let mut heap = MaxHeap::new();
    ///
    /// heap.push(1);
    /// heap.push(2);
    /// heap.push(3);
    ///     
    /// heap.build_heap();
    ///
    /// assert_eq!(heap.get_max(), Some(&3));
    /// ```
    pub fn build_heap(&mut self) {
        let bmrmin_index = self.size() / 2 - 1;

        for i in (0..=bmrmin_index).rev() {
            self.max_heapify(i);
        }
    }
}

impl<T: Ord> From<Vec<T>> for MaxHeap<T> {
    /// Create a new `MaxHeap` from a `Vec`.
    ///
    /// # Arguments
    /// * `vec` - A `Vec` of elements to be inserted into the `MaxHeap`.
    ///
    /// # Returns
    /// A new `MaxHeap` containing the elements of `vec`.
    ///
    /// # Examples
    /// ```
    /// use rust::heap::max_heap::MaxHeap;
    ///
    /// let heap = MaxHeap::from(vec![1, 4, 3, 2, 5]);
    /// ```
    fn from(vec: Vec<T>) -> Self {
        let mut heap = MaxHeap { heap: vec };

        heap.build_heap();

        heap
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_max_heap() {
        let mut heap = MaxHeap::new();

        assert!(heap.is_empty());

        heap.push(1);
        heap.push(4);
        heap.push(2);
        heap.push(5);
        heap.push(13);
        heap.push(6);
        heap.push(17);

        assert_eq!(heap.size(), 7);
        assert_eq!(heap.get_max(), Some(&17));

        assert_eq!(heap.extract_max(), Some(17));
        assert_eq!(heap.extract_max(), Some(13));
        assert_eq!(heap.extract_max(), Some(6));
        assert_eq!(heap.extract_max(), Some(5));
        assert_eq!(heap.extract_max(), Some(4));
        assert_eq!(heap.extract_max(), Some(2));
        assert_eq!(heap.extract_max(), Some(1));
        assert_eq!(heap.extract_max(), None);

        heap.push(1);
        heap.push(4);
        heap.push(3);
        heap.push(2);
        heap.push(5);

        assert_eq!(heap.extract_max(), Some(5));
        assert_eq!(heap.extract_max(), Some(4));
        assert_eq!(heap.extract_max(), Some(3));

        heap.push(4);
        heap.push(5);

        assert_eq!(heap.extract_max(), Some(5));
        assert_eq!(heap.extract_max(), Some(4));
        assert_eq!(heap.extract_max(), Some(2));
        assert_eq!(heap.extract_max(), Some(1));
        assert_eq!(heap.extract_max(), None);
    }

    #[test]
    fn test_max_heap_from_vec() {
        let heap = MaxHeap::from(vec![1, 4, 3, 2, 5]);

        assert_eq!(heap.size(), 5);
        assert_eq!(heap.get_max(), Some(&5));
    }

    #[test]
    fn test_max_heap_build_heap() {
        let mut heap = MaxHeap::from(vec![1, 4, 3, 2, 5]);

        heap.build_heap();

        assert_eq!(heap.size(), 5);
        assert_eq!(heap.get_max(), Some(&5));
    }

    #[test]
    fn test_max_heap_remove() {
        let mut heap = MaxHeap::from(vec![1, 4, 3, 2, 5]);

        heap.remove(2);

        assert_eq!(heap.size(), 4);
        assert_eq!(heap.get_max(), Some(&5));
    }
}
