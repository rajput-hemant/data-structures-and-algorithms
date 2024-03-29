use std::fmt::{Debug, Display, Formatter, Result};

pub struct Node<T> {
    element: T,
    next: Option<Box<Node<T>>>, // Box is a smart pointer, that knows its size and how to clean up after itself
}

impl<T> Node<T> {
    /// Create a new Node
    ///
    /// # Arguments
    /// * `element` - The element to store in the node
    ///
    /// # Example
    /// ```
    /// use rust::linked_list::singly_linked_list::Node;
    ///
    /// let node = Node::new(1);
    /// ```
    pub fn new(element: T) -> Self {
        Node {
            element,
            next: None,
        }
    }

    /// Create a new Node with a next node
    ///
    /// # Arguments
    /// * `element` - The element to store in the node
    /// * `next` - The next node in the list
    ///
    /// # Example
    /// ```
    /// use rust::linked_list::singly_linked_list::Node;
    ///
    /// let node = Node::new_with_next(1, None);
    /// ```
    pub fn new_with_next(element: T, next: Option<Box<Node<T>>>) -> Self {
        Node { element, next }
    }
}

#[derive(Default)]
pub struct SinglyLinkedList<T> {
    head: Option<Box<Node<T>>>,
    length: usize,
}

impl<T> SinglyLinkedList<T> {
    /// Create a new SinglyLinkedList
    pub fn new() -> Self {
        SinglyLinkedList {
            head: None,
            length: 0,
        }
    }

    /// Get the length of the list
    pub fn len(&self) -> usize {
        self.length
    }

    /// Check if the list is empty
    pub fn is_empty(&self) -> bool {
        self.length == 0
    }

    /// Push an element to the front of the list
    ///
    /// # Arguments
    /// * `element` - The element to push to the front of the list
    ///
    /// # Example
    /// ```
    /// use rust::linked_list::SinglyLinkedList;
    ///
    /// let mut list = SinglyLinkedList::new();
    ///
    /// list.push_front(1);
    /// list.push_front(2);
    /// list.push_front(3);
    ///
    /// assert_eq!(list.len(), 3);
    /// ```
    pub fn push_front(&mut self, element: T) {
        let mut node = Box::new(Node::new(element));
        node.next = self.head.take(); // take the reference out of the head, and leave None in its place

        /* w/ new_with_next associated function */
        // let node = Box::new(Node::new_with_next(
        //     element,
        //     self.head.take(), // take the reference out of the head, and leave None in its place
        // ));

        self.head = Some(node); // put the node in the head, making it the new head
        self.length += 1;
    }

    /// Push an element to the list at a given index
    ///
    /// # Arguments
    /// * `element` - The element to push to the list
    ///
    /// # Example
    /// ```
    /// use rust::linked_list::SinglyLinkedList;
    ///
    /// let mut list = SinglyLinkedList::new();
    ///
    /// list.push_at(1, 0);
    /// list.push_at(2, 0);
    /// list.push_at(3, 0);
    ///
    /// assert_eq!(list.len(), 3);
    /// ```
    pub fn push_at(&mut self, element: T, index: usize) {
        // insert at the front of the list if index is 0
        if index == 0 {
            self.push_front(element);
            return;
        }

        // panic if given an index greater than the length of the list
        if index > self.length {
            panic!("Index out of bounds");
        }

        // we need to use a mutable reference to the head, because we need to change the next field of the head
        let mut current = &mut self.head;

        // iterate through the list until we reach the node before the index we want to insert at
        for _ in 0..index {
            // current is a mutable reference to the next field of the current node
            current = &mut current
                .as_mut() // as_mut() gives us a mutable reference to the Option<Box<Node<T>>>
                .unwrap() // unwrap() gives us a mutable reference to the Box<Node<T>>
                .next; // next is a mutable reference to the next field of the Node<T>
        }

        let mut node = Box::new(Node::new(element));
        node.next = current.take(); // take the reference out of the current node, and leave None in its place

        /* w/ new_with_next associated function */
        // let node = Box::new(Node::new_with_next(
        //     element,
        //     current.take(), // take the reference out of the current node, and leave None in its place
        // ));

        *current = Some(node); // put the node in the current node, making it the new current node
        self.length += 1;
    }

    /// Push an element to the back of the list
    ///
    /// # Arguments
    /// * `element` - The element to push to the back of the list
    ///
    /// # Example
    /// ```
    /// use rust::linked_list::SinglyLinkedList;
    ///
    /// let mut list = SinglyLinkedList::new();
    ///
    /// list.push_back(1);
    /// list.push_back(2);
    /// list.push_back(3);
    ///
    /// assert_eq!(list.len(), 3);
    /// ```
    pub fn push_back(&mut self, element: T) {
        let node = Box::new(Node::new(element));

        // if the list is empty, put the node in the head
        if self.is_empty() {
            self.head = Some(node);
            self.length += 1;
            return;
        }

        // we need to use a mutable reference to the head, because we need to change the next field of the head
        let mut current = &mut self.head;

        // iterate through the list until we reach the last node
        while let Some(node) = current {
            // current is a mutable reference to the next field of the current node
            current = &mut node.next;
        }

        *current = Some(node); // put the node in the current node, making it the new current node
        self.length += 1;
    }

    /// Pop an element from the front of the list
    ///
    /// # Example
    /// ```
    /// use rust::linked_list::SinglyLinkedList;
    ///
    /// let mut list = SinglyLinkedList::new();
    ///
    /// list.push_front(1);
    /// list.push_front(2);
    /// list.push_front(3);
    ///
    ///
    /// assert_eq!(list.len(), 3);
    /// assert_eq!(list.pop_front(), Some(3));
    /// assert_eq!(list.pop_front(), Some(2));
    /// ```
    pub fn pop_front(&mut self) -> Option<T> {
        if self.is_empty() {
            None
        } else {
            let mut node = self.head.take();
            self.head = node.as_mut().unwrap().next.take();
            self.length -= 1;

            Some(node.unwrap().element)
        }
    }

    /// Pop an element from the list at a given index
    ///
    /// # Arguments
    /// * `index` - The index to pop from
    ///
    /// # Example
    /// ```
    /// use rust::linked_list::SinglyLinkedList;
    ///
    /// let mut list = SinglyLinkedList::new();
    ///
    /// list.push_front(1);
    /// list.push_front(2);
    /// list.push_front(3);
    ///
    /// assert_eq!(list.len(), 3);
    /// assert_eq!(list.pop_at(1), Some(2));
    /// assert_eq!(list.pop_at(1), Some(1));
    /// ```
    pub fn pop_at(&mut self, index: usize) -> Option<T> {
        if self.is_empty() {
            return None;
        }

        // panic if given an index greater than the length of the list
        if index >= self.length {
            panic!("Index out of bounds");
        }

        // pop from the front of the list if index is 0
        if index == 0 {
            return self.pop_front();
        }

        // we need to use a mutable reference to the head, because we need to change the next field of the head
        let mut current = &mut self.head;

        // iterate through the list until we reach the node before the index we want to pop at
        for _ in 0..index {
            // current is a mutable reference to the next field of the current node
            current = &mut current
                .as_mut() // as_mut() gives us a mutable reference to the Option<Box<Node<T>>>
                .unwrap() // unwrap() gives us a mutable reference to the Box<Node<T>>
                .next; // next is a mutable reference to the next field of the Node<T>
        }

        // take the reference out of the current node, and leave None in its place
        let mut node = current.take();
        // put the reference to the next node in the current node, making it the new current node
        *current = node.as_mut().unwrap().next.take();
        self.length -= 1;

        Some(node.unwrap().element)
    }

    /// Pop an element from the back of the list
    ///
    /// # Example
    /// ```
    /// use rust::linked_list::SinglyLinkedList;
    ///
    /// let mut list = SinglyLinkedList::new();
    ///
    /// list.push_back(1);
    /// list.push_back(2);
    /// list.push_back(3);
    ///
    /// assert_eq!(list.len(), 3);
    /// assert_eq!(list.pop_back(), Some(3));
    /// assert_eq!(list.pop_back(), Some(2));
    /// ```
    pub fn pop_back(&mut self) -> Option<T> {
        if self.is_empty() {
            None
        } else if self.length == 1 {
            self.pop_front()
        } else {
            // we need to use a mutable reference to the head, because we need to change the next field of the head
            let mut current = &mut self.head;

            // iterate through the list until we reach the second to last node
            for _ in 0..self.length - 1 {
                // current is a mutable reference to the next field of the current node
                current = &mut current
                    .as_mut() // as_mut() gives us a mutable reference to the Option<Box<Node<T>>>
                    .unwrap() // unwrap() gives us a mutable reference to the Box<Node<T>>
                    .next; // next is a mutable reference to the next field of the Node<T>
            }

            // take the reference out of the current node, and leave None in its place
            let mut node = current.take();
            // put the reference to the next node in the current node, making it the new current node
            *current = node.as_mut().unwrap().next.take();
            self.length -= 1;

            Some(node.unwrap().element)
        }
    }
}

impl<T> Drop for SinglyLinkedList<T> {
    fn drop(&mut self) {
        // take the head of the list, leaving None in its place
        let mut current = self.head.take();

        // iterate through the list, dropping each node
        while let Some(mut node) = current {
            // take the next node, assign it to the current leaving None in its place
            current = node.next.take();
        }
    }
}

impl<T: Display> Display for SinglyLinkedList<T> {
    fn fmt(&self, f: &mut Formatter) -> Result {
        // we need to use a reference to the head, because we don't want to take ownership of the list
        let mut current = &self.head;

        // iterate through the list, printing each element
        while let Some(node) = current {
            write!(f, "{}", node.element)?;

            if node.next.is_some() {
                write!(f, " -> ")?;
            }

            current = &node.next;
        }

        Ok(())
    }
}

impl<T: Debug> Debug for SinglyLinkedList<T> {
    fn fmt(&self, f: &mut Formatter) -> Result {
        let mut current = &self.head;

        while let Some(node) = current {
            write!(f, "{:?}", node.element)?;

            if node.next.is_some() {
                write!(f, " -> ")?;
            }

            current = &node.next;
        }

        Ok(())
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_push_front() {
        let mut list = SinglyLinkedList::new();

        list.push_front(1);
        list.push_front(2);
        list.push_front(3);

        assert_eq!(list.len(), 3);
        assert_eq!(list.pop_front(), Some(3));
        assert_eq!(list.pop_front(), Some(2));
        assert_eq!(list.pop_front(), Some(1));
        assert_eq!(list.pop_front(), None);
    }

    #[test]
    fn test_push_at() {
        let mut list = SinglyLinkedList::new();

        list.push_at(1, 0);
        list.push_at(2, 0);
        list.push_at(3, 0);

        assert_eq!(list.len(), 3);
        assert_eq!(list.pop_front(), Some(3));
        assert_eq!(list.pop_front(), Some(2));
        assert_eq!(list.pop_front(), Some(1));
        assert_eq!(list.pop_front(), None);
    }

    #[test]
    fn test_push_back() {
        let mut list = SinglyLinkedList::new();

        list.push_back(1);
        list.push_back(2);
        list.push_back(3);

        assert_eq!(list.len(), 3);
        assert_eq!(list.pop_front(), Some(1));
        assert_eq!(list.pop_front(), Some(2));
        assert_eq!(list.pop_front(), Some(3));
        assert_eq!(list.pop_front(), None);
    }

    #[test]
    fn test_pop_front() {
        let mut list = SinglyLinkedList::new();

        list.push_front(1);
        list.push_front(2);
        list.push_front(3);

        assert_eq!(list.len(), 3);
        assert_eq!(list.pop_front(), Some(3));
        assert_eq!(list.pop_front(), Some(2));
        assert_eq!(list.pop_front(), Some(1));
        assert_eq!(list.pop_front(), None);
    }

    #[test]
    fn test_pop_at() {
        let mut list = SinglyLinkedList::new();

        list.push_front(1);
        list.push_front(2);
        list.push_front(3);

        assert_eq!(list.len(), 3);
        assert_eq!(list.pop_at(1), Some(2));
        assert_eq!(list.pop_at(1), Some(1));
        assert_eq!(list.pop_at(0), Some(3));
        assert_eq!(list.pop_at(0), None);
    }

    #[test]
    fn test_pop_back() {
        let mut list = SinglyLinkedList::new();

        list.push_back(1);
        list.push_back(2);
        list.push_back(3);

        assert_eq!(list.len(), 3);
        assert_eq!(list.pop_back(), Some(3));
        assert_eq!(list.pop_back(), Some(2));
        assert_eq!(list.pop_back(), Some(1));
        assert_eq!(list.pop_back(), None);
    }
}
