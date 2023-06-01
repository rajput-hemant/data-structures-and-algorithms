type Link<T> = Option<Box<Node<T>>>;

pub struct Node<T> {
    item: T,
    next: Link<T>,
}

impl<T> Node<T> {
    /// Create a new node
    ///
    /// # Arguments
    /// * `item` - The item to be stored in the node
    ///
    /// # Returns
    /// * A new node
    ///
    /// # Example
    /// ```
    /// use rust::stack::stack_using_linked_list::Node;
    ///
    /// let node = Node::new(1);
    /// ```
    pub fn new(item: T) -> Self {
        Node { item, next: None }
    }
}

pub struct StackUsingLinkedList<T> {
    stack: Link<T>,
}

impl<T> StackUsingLinkedList<T> {
    /// Create a new stack
    ///
    /// # Returns
    /// * A new stack
    ///
    /// # Example
    /// ```
    /// use rust::stack::stack_using_linked_list::StackUsingLinkedList;
    ///
    /// let stack: StackUsingLinkedList<i64> = StackUsingLinkedList::new();
    /// ```
    pub fn new() -> Self {
        StackUsingLinkedList { stack: None }
    }

    /// Check if the stack is empty
    ///
    /// # Returns
    /// * `true` if the stack is empty
    ///
    /// # Example
    /// ```
    /// use rust::stack::stack_using_linked_list::StackUsingLinkedList;
    ///
    /// let stack: StackUsingLinkedList<i64> = StackUsingLinkedList::new();
    /// assert_eq!(stack.is_empty(), true);
    /// ```
    pub fn is_empty(&self) -> bool {
        self.stack.is_none()
    }

    /// Push an item to the stack
    ///
    /// # Arguments
    /// * `item` - The item to be pushed to the stack
    ///
    /// # Example
    /// ```
    /// use rust::stack::stack_using_linked_list::StackUsingLinkedList;
    ///
    /// let mut stack = StackUsingLinkedList::new();
    /// stack.push(1);
    /// ```
    pub fn push(&mut self, item: T) {
        let mut node = Box::new(Node::new(item));

        if self.is_empty() {
            self.stack = Some(node);
        } else {
            let current = self.stack.take().unwrap();
            node.next = Some(current);
            self.stack = Some(node);
        }
    }

    /// Pop an item from the stack
    ///
    /// # Returns
    /// * The item popped from the stack
    ///
    /// # Example
    /// ```
    /// use rust::stack::stack_using_linked_list::StackUsingLinkedList;
    ///
    /// let mut stack = StackUsingLinkedList::new();
    /// stack.push(1);
    /// stack.push(2);
    /// stack.push(3);
    ///
    /// assert_eq!(stack.pop(), Some(3));
    /// assert_eq!(stack.pop(), Some(2));
    /// assert_eq!(stack.pop(), Some(1));
    /// ```
    pub fn pop(&mut self) -> Option<T> {
        if self.is_empty() {
            None
        } else {
            let current = self.stack.take().unwrap();
            self.stack = current.next;

            Some(current.item)
        }
    }

    /// Peek at the top of the stack
    ///
    /// # Returns
    /// * Reference to the item at the top of the stack
    ///
    /// # Example
    /// ```
    /// use rust::stack::stack_using_linked_list::StackUsingLinkedList;
    ///
    /// let mut stack = StackUsingLinkedList::new();
    /// stack.push(1);
    /// stack.push(2);
    /// stack.push(3);
    ///
    /// assert_eq!(stack.peek(), Some(&3));
    /// ```
    pub fn peek(&self) -> Option<&T> {
        if self.is_empty() {
            None
        } else {
            let current = self.stack.as_ref().unwrap();
            Some(&current.item)
        }
    }

    /// Clear the stack
    ///
    /// # Example
    /// ```
    /// use rust::stack::stack_using_linked_list::StackUsingLinkedList;
    ///
    /// let mut stack = StackUsingLinkedList::new();
    /// stack.push(1);
    /// stack.push(2);
    /// stack.push(3);
    ///
    /// stack.clear();
    /// assert_eq!(stack.peek(), None);
    /// ```
    pub fn clear(&mut self) {
        self.stack = None;
    }
}

impl<T> Drop for StackUsingLinkedList<T> {
    fn drop(&mut self) {
        let mut current = self.stack.take();

        while let Some(mut node) = current {
            current = node.next.take();
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_push() {
        let mut stack = StackUsingLinkedList::new();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assert_eq!(stack.peek(), Some(&3));
    }

    #[test]
    fn test_pop() {
        let mut stack = StackUsingLinkedList::new();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assert_eq!(stack.pop(), Some(3));
        assert_eq!(stack.pop(), Some(2));
        assert_eq!(stack.pop(), Some(1));
    }

    #[test]
    fn test_peek() {
        let mut stack = StackUsingLinkedList::new();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assert_eq!(stack.peek(), Some(&3));
        assert_eq!(stack.peek(), Some(&3));
    }

    #[test]
    fn test_clear() {
        let mut stack = StackUsingLinkedList::new();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.clear();
        assert_eq!(stack.peek(), None);
    }
}
