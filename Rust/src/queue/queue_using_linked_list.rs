use std::{cell::RefCell, rc::Rc};

type Link<T> = Option<Rc<RefCell<Node<T>>>>;

pub struct Node<T> {
    item: T,
    next: Link<T>,
}

impl<T> Node<T> {
    /// Creates a new node.
    ///
    /// # Arguments
    /// * `item` - The item to be stored in the node.
    ///
    /// # Returns
    /// * `Node<T>` - A new node.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::queue_using_linked_list::Node;
    ///
    /// let node = Node::new(1);
    /// ```
    pub fn new(item: T) -> Self {
        Node { item, next: None }
    }
}

pub struct QueueUsingLinkedList<T> {
    head: Link<T>,
    tail: Link<T>,
}

impl<T: Clone> QueueUsingLinkedList<T> {
    /// Creates an empty queue.
    ///
    /// # Returns
    /// * `QueueUsingLinkedList<T>` - An empty queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingLinkedList;
    ///
    /// let queue: QueueUsingLinkedList<i32> = QueueUsingLinkedList::new();
    /// ```
    pub fn new() -> Self {
        QueueUsingLinkedList {
            head: None,
            tail: None,
        }
    }

    /// Returns `true` if the queue contains no elements.
    ///
    /// # Returns
    /// * `bool` - `true` if the queue contains no elements.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingLinkedList;
    ///
    /// let mut queue = QueueUsingLinkedList::new();
    /// assert_eq!(queue.is_empty(), true);
    ///
    /// queue.enqueue(1);
    /// assert_eq!(queue.is_empty(), false);
    /// ```
    pub fn is_empty(&self) -> bool {
        self.head.is_none() && self.tail.is_none()
    }

    /// Adds an element to the back of the queue.
    ///
    /// # Arguments
    /// * `item` - The element to be added to the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingLinkedList;
    ///
    /// let mut queue = QueueUsingLinkedList::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.peek(), Some(1));
    /// ```
    pub fn enqueue(&mut self, item: T) {
        let node = Rc::new(RefCell::new(Node::new(item)));

        if self.tail.is_none() {
            self.head = Some(node.clone());
            self.tail = Some(node);
        } else {
            let tail = self.tail.as_ref().unwrap();
            tail.borrow_mut().next = Some(node.clone());
            self.tail = Some(node);
        }
    }

    /// Removes the element from the front of the queue and returns it.
    ///
    /// # Returns
    /// * `Option<T>` - The element at the front of the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingLinkedList;
    ///
    /// let mut queue = QueueUsingLinkedList::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.dequeue(), Some(1));
    /// ```
    pub fn dequeue(&mut self) -> Option<T> {
        if self.is_empty() {
            return None;
        }

        let head = self.head.clone();
        let tail = self.tail.clone();

        let item = head.clone().unwrap().borrow().item.clone();

        if Rc::ptr_eq(head.as_ref().unwrap(), tail.as_ref().unwrap()) {
            self.head = None;
            self.tail = None;
        } else {
            self.head = head.unwrap().borrow().next.clone();
        }

        Some(item)
    }

    /// Returns a refrence to the element at the front of the queue without removing it.
    ///
    /// # Returns
    /// * `Option<T>` - The element at the front of the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingLinkedList;
    ///
    /// let mut queue = QueueUsingLinkedList::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// assert_eq!(queue.peek(), Some(1));
    /// ```
    pub fn peek(&self) -> Option<T> {
        if self.is_empty() {
            return None;
        }

        let head = self.head.clone();

        Some(head.unwrap().borrow().item.clone())
    }

    /// Removes all elements from the queue.
    ///
    /// # Examples
    /// ```
    /// use rust::queue::QueueUsingLinkedList;
    ///
    /// let mut queue = QueueUsingLinkedList::new();
    /// queue.enqueue(1);
    /// queue.enqueue(2);
    /// queue.enqueue(3);
    ///
    /// queue.clear();
    /// assert_eq!(queue.is_empty(), true);
    /// ```
    pub fn clear(&mut self) {
        self.head = None;
        self.tail = None;
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_queue_using_vector() {
        let mut queue = QueueUsingLinkedList::new();
        assert!(queue.is_empty());
        assert_eq!(queue.peek(), None);
        assert_eq!(queue.dequeue(), None);

        queue.enqueue(1);
        assert!(!queue.is_empty());
        assert_eq!(queue.peek(), Some(1));
        assert_eq!(queue.dequeue(), Some(1));

        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assert!(!queue.is_empty());
        assert_eq!(queue.peek(), Some(2));
        assert_eq!(queue.dequeue(), Some(2));

        queue.clear();
        assert!(queue.is_empty());
        assert_eq!(queue.peek(), None);
        assert_eq!(queue.dequeue(), None);
    }
}
