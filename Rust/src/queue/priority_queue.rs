use crate::heap::MinHeap;

pub struct PriorityQueue<T> {
    mh: MinHeap<T>,
}

impl<T: Ord> PriorityQueue<T> {
    /// Create a new empty priority queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::priority_queue::PriorityQueue;
    ///
    /// let pq: PriorityQueue<i32> = PriorityQueue::new();
    /// ```
    pub fn new() -> Self {
        PriorityQueue { mh: MinHeap::new() }
    }

    /// Returns the number of elements in the priority queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::priority_queue::PriorityQueue;
    ///
    /// let mut pq = PriorityQueue::new();
    ///
    /// assert_eq!(pq.len(), 0);
    ///
    /// pq.enqueue(1);
    /// assert_eq!(pq.len(), 1);
    /// ```
    pub fn len(&self) -> usize {
        self.mh.size()
    }

    /// Returns true if the priority queue contains no elements.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::priority_queue::PriorityQueue;
    ///
    /// let mut pq = PriorityQueue::new();
    ///
    /// assert_eq!(pq.is_empty(), true);
    ///
    /// pq.enqueue(1);
    /// assert_eq!(pq.is_empty(), false);
    /// ```
    pub fn is_empty(&self) -> bool {
        self.mh.is_empty()
    }

    /// Adds an element to the priority queue.
    ///
    /// # Arguments
    /// * `item` - The item to be added.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::priority_queue::PriorityQueue;
    ///
    /// let mut pq = PriorityQueue::new();
    ///
    /// pq.enqueue(1);
    /// pq.enqueue(2);
    /// pq.enqueue(3);
    ///
    /// assert_eq!(pq.len(), 3);
    /// assert_eq!(pq.is_empty(), false);
    /// assert_eq!(pq.peek(), Some(&1));
    /// ```
    pub fn enqueue(&mut self, item: T) {
        self.mh.push(item);
    }

    /// Removes and returns the element at the front of the priority queue.
    ///
    /// # Returns
    /// The element at the front of the priority queue, or None if the priority queue is empty.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::priority_queue::PriorityQueue;
    ///
    /// let mut pq = PriorityQueue::new();
    ///
    /// pq.enqueue(1);
    /// pq.enqueue(2);
    /// pq.enqueue(3);
    ///
    /// assert_eq!(pq.dequeue(), Some(1));
    /// assert_eq!(pq.dequeue(), Some(2));
    /// assert_eq!(pq.dequeue(), Some(3));
    /// assert_eq!(pq.dequeue(), None);
    /// ```
    pub fn dequeue(&mut self) -> Option<T> {
        self.mh.extract_min()
    }

    /// Returns the element at the front of the priority queue without removing it.
    ///
    /// # Returns
    /// The element at the front of the priority queue, or None if the priority queue is empty.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::priority_queue::PriorityQueue;
    ///
    /// let mut pq = PriorityQueue::new();
    ///
    /// pq.enqueue(1);
    ///
    /// assert_eq!(pq.peek(), Some(&1));
    /// ```
    pub fn peek(&self) -> Option<&T> {
        self.mh.get_min()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_priority_queue() {
        let mut pq = PriorityQueue::new();
        assert_eq!(pq.len(), 0);
        assert_eq!(pq.is_empty(), true);

        pq.enqueue(1);
        assert_eq!(pq.len(), 1);
        assert_eq!(pq.is_empty(), false);
        assert_eq!(pq.peek(), Some(&1));

        pq.enqueue(2);
        assert_eq!(pq.len(), 2);
        assert_eq!(pq.is_empty(), false);
        assert_eq!(pq.peek(), Some(&1));

        pq.enqueue(3);
        assert_eq!(pq.len(), 3);
        assert_eq!(pq.is_empty(), false);
        assert_eq!(pq.peek(), Some(&1));

        assert_eq!(pq.dequeue(), Some(1));
        assert_eq!(pq.len(), 2);
        assert_eq!(pq.is_empty(), false);
        assert_eq!(pq.peek(), Some(&2));

        assert_eq!(pq.dequeue(), Some(2));
        assert_eq!(pq.len(), 1);
        assert_eq!(pq.is_empty(), false);
        assert_eq!(pq.peek(), Some(&3));

        assert_eq!(pq.dequeue(), Some(3));
        assert_eq!(pq.len(), 0);
        assert_eq!(pq.is_empty(), true);
        assert_eq!(pq.peek(), None);

        assert_eq!(pq.dequeue(), None);
        assert_eq!(pq.len(), 0);
        assert_eq!(pq.is_empty(), true);
        assert_eq!(pq.peek(), None);
    }
}
