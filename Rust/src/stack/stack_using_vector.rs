use std::fmt::{Debug, Display, Formatter, Result};

#[derive(Default, Debug)]
pub struct StackUsingVector<T> {
    pub stack: Vec<T>,
}

impl<T> StackUsingVector<T> {
    /// Creates an empty stack.
    ///
    /// # Returns
    /// * `StackUsingVector<T>` - An empty stack.
    ///
    /// # Examples
    /// ```
    /// use rust::stack::StackUsingVector;
    ///
    /// let stack: StackUsingVector<i32> = StackUsingVector::new();
    /// ```
    pub fn new() -> Self {
        StackUsingVector { stack: Vec::new() }
    }

    /// Returns the number of elements in the stack.
    ///
    /// # Returns
    /// * `usize` - The number of elements in the stack.
    ///
    /// # Examples
    /// ```
    /// use rust::stack::StackUsingVector;
    ///
    /// let mut stack = StackUsingVector::new();
    /// assert_eq!(stack.len(), 0);
    ///
    /// stack.push(1);
    /// assert_eq!(stack.len(), 1);
    /// ```
    pub fn len(&self) -> usize {
        self.stack.len()
    }

    /// Returns `true` if the stack contains no elements.
    ///
    /// # Returns
    /// * `bool` - `true` if the stack contains no elements.
    ///
    /// # Examples
    /// ```
    /// use rust::stack::StackUsingVector;
    ///
    /// let mut stack = StackUsingVector::new();
    /// assert_eq!(stack.is_empty(), true);
    ///
    /// stack.push(1);
    /// assert_eq!(stack.is_empty(), false);
    /// ```
    pub fn is_empty(&self) -> bool {
        self.stack.is_empty()
    }

    /// Pushes an element onto the top of the stack.
    ///
    /// # Arguments
    /// * `item` - The element to be pushed onto the stack.
    ///
    /// # Examples
    /// ```
    /// use rust::stack::StackUsingVector;
    ///
    /// let mut stack = StackUsingVector::new();
    /// stack.push(1);
    /// stack.push(2);
    /// stack.push(3);
    /// ```
    pub fn push(&mut self, item: T) {
        self.stack.push(item);
    }

    /// Removes the element from the top of the stack and returns it.
    ///
    /// # Returns
    /// * `Some(T)` - The element at the top of the stack.
    ///
    /// # Examples
    /// ```
    /// use rust::stack::StackUsingVector;
    ///
    /// let mut stack = StackUsingVector::new();
    /// stack.push(1);
    /// stack.push(2);
    /// stack.push(3);
    ///
    /// assert_eq!(stack.pop(), Some(3));
    /// assert_eq!(stack.pop(), Some(2));
    /// assert_eq!(stack.pop(), Some(1));
    /// assert_eq!(stack.pop(), None);
    /// ```
    pub fn pop(&mut self) -> Option<T> {
        self.stack.pop()
    }

    /// Returns a reference to the element on the top of the stack.
    ///
    /// # Returns
    /// * `Option<&T>` - A reference to the element on the top of the stack.
    ///
    /// # Examples
    /// ```
    /// use rust::stack::StackUsingVector;
    ///
    /// let mut stack = StackUsingVector::new();
    /// stack.push(1);
    /// stack.push(2);
    /// stack.push(3);
    ///
    /// assert_eq!(stack.peek(), Some(&3));
    /// ```
    pub fn peek(&self) -> Option<&T> {
        self.stack.last()
    }

    /// Removes all elements from the stack.
    ///
    /// # Examples
    /// ```
    /// use rust::stack::StackUsingVector;
    ///
    /// let mut stack = StackUsingVector::new();
    /// stack.push(1);
    /// stack.push(2);
    /// stack.push(3);
    ///
    /// stack.clear();
    /// assert_eq!(stack.len(), 0);
    /// ```
    pub fn clear(&mut self) {
        self.stack.clear();
    }
}

impl<T: Display> Display for StackUsingVector<T> {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {
        write!(
            f,
            "{}",
            String::from_iter(self.stack.iter().enumerate().map(|(i, x)| {
                if i == self.stack.len() - 1 {
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
    fn test_stack_using_array() {
        let mut stack = StackUsingVector::new();
        assert_eq!(stack.len(), 0);
        assert!(stack.is_empty());
        assert_eq!(stack.peek(), None);
        assert_eq!(stack.pop(), None);

        stack.push(1);
        assert_eq!(stack.len(), 1);
        assert!(!stack.is_empty());
        assert_eq!(stack.peek(), Some(&1));
        assert_eq!(stack.pop(), Some(1));

        stack.push(2);
        stack.push(3);
        stack.push(4);
        assert_eq!(stack.len(), 3);
        assert!(!stack.is_empty());
        assert_eq!(stack.peek(), Some(&4));
        assert_eq!(stack.pop(), Some(4));

        stack.clear();
        assert_eq!(stack.len(), 0);
        assert!(stack.is_empty());
        assert_eq!(stack.peek(), None);
        assert_eq!(stack.pop(), None);
    }
}
