use std::fmt::{Debug, Display, Formatter, Result};

use crate::stack::StackUsingVector;

#[derive(Default, Debug)]
pub struct QueueUsingTwoStacks<T> {
    stack1: StackUsingVector<T>,
    stack2: StackUsingVector<T>,
}

impl<T> QueueUsingTwoStacks<T> {
    /// Creates an empty queue.
    ///
    /// # Returns
    /// * `QueueUsingTwoStacks<T>` - An empty queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingTwoStacks;
    ///
    /// let queue: QueueUsingTwoStacks<i32> = QueueUsingTwoStacks::new();
    /// ```
    pub fn new() -> Self {
        QueueUsingTwoStacks {
            stack1: StackUsingVector::new(),
            stack2: StackUsingVector::new(),
        }
    }

    /// Returns the number of elements in the queue.
    ///
    /// # Returns
    /// * `usize` - The number of elements in the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingTwoStacks;
    ///
    /// let mut queue = QueueUsingTwoStacks::new();
    /// assert_eq!(queue.len(), 0);
    ///
    /// queue.enqueue(1);
    /// assert_eq!(queue.len(), 1);
    /// ```
    pub fn len(&self) -> usize {
        self.stack1.len() + self.stack2.len()
    }

    /// Returns `true` if the queue contains no elements.
    ///
    /// # Returns
    /// * `bool` - `true` if the queue contains no elements.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingTwoStacks;
    ///
    /// let mut queue = QueueUsingTwoStacks::new();
    /// assert_eq!(queue.is_empty(), true);
    ///
    /// queue.enqueue(1);
    /// assert_eq!(queue.is_empty(), false);
    /// ```
    pub fn is_empty(&self) -> bool {
        self.stack1.is_empty() && self.stack2.is_empty()
    }

    /// Adds an element to the back of the queue.
    ///
    /// # Arguments
    /// * `item` - The element to be added to the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingTwoStacks;
    ///
    /// let mut queue = QueueUsingTwoStacks::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.peek(), Some(&1));
    /// ```
    pub fn enqueue(&mut self, item: T) {
        // remove top element from stack1 and push it to stack2 until stack1 is empty
        while !self.stack1.is_empty() {
            self.stack2.push(self.stack1.pop().unwrap());
        }

        // push the new element to stack1
        self.stack1.push(item);

        // remove top element from stack2 and push it to stack1 until stack2 is empty
        while !self.stack2.is_empty() {
            self.stack1.push(self.stack2.pop().unwrap());
        }
    }

    /// Removes the element from the front of the queue and returns it.
    ///
    /// # Returns
    /// * `Option<T>` - The element at the front of the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingTwoStacks;
    ///
    /// let mut queue = QueueUsingTwoStacks::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.dequeue(), Some(1));
    /// ```
    pub fn dequeue(&mut self) -> Option<T> {
        self.stack1.pop()
    }

    /// Returns a refrence to the element at the front of the queue without removing it.
    ///
    /// # Returns
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingTwoStacks;
    ///
    /// let mut queue = QueueUsingTwoStacks::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.peek(), Some(&1));
    /// ```
    pub fn peek(&self) -> Option<&T> {
        self.stack1.peek()
    }

    /// Removes all elements from the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingTwoStacks;
    ///
    /// let mut queue = QueueUsingTwoStacks::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.len(), 3);
    /// queue.clear();
    /// assert_eq!(queue.len(), 0);
    /// ```
    pub fn clear(&mut self) {
        self.stack1.clear();
    }
}

impl<T: Display> Display for QueueUsingTwoStacks<T> {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {
        write!(f, "[ Top: ")?;

        for i in 0..self.len() {
            write!(f, "{}", self.stack1.stack[i])?;
            if i != self.len() - 1 {
                write!(f, " -> ")?;
            }
        }

        write!(f, "]")
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_queue_using_vector() {
        let mut queue = QueueUsingTwoStacks::new();
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
