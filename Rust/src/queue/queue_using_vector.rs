use std::fmt::{Debug, Display, Formatter, Result};

#[derive(Default, Debug)]
pub struct QueueUsingVector<T> {
    queue: Vec<T>,
}

impl<T> QueueUsingVector<T> {
    /// Creates an empty queue.
    ///
    /// # Returns
    /// * `QueueUsingVector<T>` - An empty queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingVector;
    ///
    /// let queue: QueueUsingVector<i32> = QueueUsingVector::new();
    /// ```
    pub fn new() -> Self {
        QueueUsingVector { queue: Vec::new() }
    }

    /// Returns the number of elements in the queue.
    ///
    /// # Returns
    /// * `usize` - The number of elements in the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingVector;
    ///
    /// let mut queue = QueueUsingVector::new();
    /// assert_eq!(queue.len(), 0);
    ///
    /// queue.enqueue(1);
    /// assert_eq!(queue.len(), 1);
    /// ```
    pub fn len(&self) -> usize {
        self.queue.len()
    }

    /// Returns `true` if the queue contains no elements.
    ///
    /// # Returns
    /// * `bool` - `true` if the queue contains no elements.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingVector;
    ///
    /// let mut queue = QueueUsingVector::new();
    /// assert_eq!(queue.is_empty(), true);
    ///
    /// queue.enqueue(1);
    /// assert_eq!(queue.is_empty(), false);
    /// ```
    pub fn is_empty(&self) -> bool {
        self.queue.is_empty()
    }

    /// Adds an element to the back of the queue.
    ///
    /// # Arguments
    /// * `item` - The element to be added to the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingVector;
    ///
    /// let mut queue = QueueUsingVector::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.peek(), Some(&1));
    /// ```
    pub fn enqueue(&mut self, item: T) {
        self.queue.push(item);
    }

    /// Removes the element from the front of the queue and returns it.
    ///
    /// # Returns
    /// * `Option<T>` - The element at the front of the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingVector;
    ///
    /// let mut queue = QueueUsingVector::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.dequeue(), Some(1));
    /// ```
    pub fn dequeue(&mut self) -> Option<T> {
        if self.is_empty() {
            None
        } else {
            Some(self.queue.remove(0))
        }
    }

    /// Returns a refrence to the element at the front of the queue without removing it.
    ///
    /// # Returns
    /// * `Option<&T>` - A refrence to the element at the front of the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingVector;
    ///
    /// let mut queue = QueueUsingVector::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.peek(), Some(&1));
    /// ```
    pub fn peek(&self) -> Option<&T> {
        self.queue.first()
    }

    /// Removes all elements from the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingVector;
    ///
    /// let mut queue = QueueUsingVector::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.len(), 3);
    /// queue.clear();
    /// assert_eq!(queue.len(), 0);
    /// ```
    pub fn clear(&mut self) {
        self.queue.clear();
    }
}

impl<T: Display> Display for QueueUsingVector<T> {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {
        write!(
            f,
            "{}",
            String::from_iter(self.queue.iter().enumerate().map(|(i, x)| {
                if i == self.queue.len() - 1 {
                    format!("{}", x)
                } else {
                    format!("{}, ", x)
                }
            }))
        )
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_queue_using_vector() {
        let mut queue = QueueUsingVector::new();
        assert_eq!(queue.len(), 0);
        assert!(queue.is_empty());
        assert_eq!(queue.peek(), None);
        assert_eq!(queue.dequeue(), None);

        queue.enqueue(1);
        assert_eq!(queue.len(), 1);
        assert!(!queue.is_empty());
        assert_eq!(queue.peek(), Some(&1));
        assert_eq!(queue.dequeue(), Some(1));

        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assert_eq!(queue.len(), 3);
        assert!(!queue.is_empty());
        assert_eq!(queue.peek(), Some(&2));
        assert_eq!(queue.dequeue(), Some(2));

        queue.clear();
        assert_eq!(queue.len(), 0);
        assert!(queue.is_empty());
        assert_eq!(queue.peek(), None);
        assert_eq!(queue.dequeue(), None);
    }
}
