use std::{cell::RefCell, rc::Rc};

// associated type
type Link<T> = Option<Rc<RefCell<Node<T>>>>;
struct Node<T> {
    el: T,
    next: Link<T>,
    prev: Link<T>,
}

impl<T> Node<T> {
    fn new(el: T) -> Self {
        Node {
            el,
            next: None,
            prev: None,
        }
    }
}

pub struct DoublyLinkedList<T> {
    head: Link<T>,
    tail: Link<T>,
    len: usize,
}

impl<T> DoublyLinkedList<T> {
    pub fn new() -> Self {
        DoublyLinkedList {
            head: None,
            tail: None,
            len: 0,
        }
    }

    pub fn len(&self) -> usize {
        self.len
    }

    pub fn is_empty(&self) -> bool {
        self.len() == 0
    }

    pub fn push_front(&mut self, item: T) {
        let node = Rc::new(RefCell::new(Node::new(item)));

        if self.is_empty() {
            self.head = Some(node.clone());
            self.tail = Some(node.clone());
        } else {
            // node next will point to first node
            node.borrow_mut().next.clone_from(&self.head);
            // prev of head will point to node
            self.head.as_ref().unwrap().borrow_mut().prev = Some(node.clone());
            // head will point to node
            self.head = Some(node.clone());
        }

        self.len += 1;
    }

    pub fn push_at(&mut self, item: T, index: usize) {
        if index == 0 {
            self.push_front(item);
        } else if index == self.len() {
            self.push_back(item);
        } else {
            let mut current = self.head.clone();
            let mut i = 0;

            while i < index - 1 {
                current = current.unwrap().borrow().next.clone();
                i += 1;
            }

            let node = Rc::new(RefCell::new(Node::new(item)));

            // node next will point to next node
            node.borrow_mut()
                .next
                .clone_from(&current.as_ref().unwrap().borrow().next);
            // node prev will point to current node
            node.borrow_mut().prev.clone_from(&current);
            // next of current node will point to node
            current.as_ref().unwrap().borrow_mut().next = Some(node.clone());
            // prev of next node will point to node
            node.borrow_mut().next.as_ref().unwrap().borrow_mut().prev = Some(node.clone());

            self.len += 1;
        }
    }

    pub fn push_back(&mut self, item: T) {
        let node = Rc::new(RefCell::new(Node::new(item)));

        if self.is_empty() {
            self.head = Some(node.clone());
            self.tail = Some(node.clone());
        } else {
            // node prev will point to last node
            node.borrow_mut().prev.clone_from(&self.tail);
            // next of tail will point to node
            self.tail.as_ref().unwrap().borrow_mut().next = Some(node.clone());
            // tail will point to node
            self.tail = Some(node.clone());
        }

        self.len += 1;
    }

    pub fn pop_front(&mut self) {
        if self.is_empty() {
            panic!("List is empty");
        } else if self.len() == 1 {
            self.head = None;
            self.tail = None;
        } else {
            // get the reference of next node of head
            let next = self.head.as_ref().unwrap().borrow().next.clone();
            // next node prev will point to None
            next.as_ref().unwrap().borrow_mut().prev = None;
            // head will point to next node, so first node will be removed
            self.head = next;
        }

        self.len -= 1;
    }

    pub fn pop_at(&mut self, index: usize) {
        if self.is_empty() {
            panic!("List is empty");
        } else if index == 0 {
            self.pop_front();
        } else if index == self.len() {
            self.pop_back();
        } else if index > self.len() {
            panic!("Index out of bound");
        } else {
            let mut current = self.head.clone();

            for _ in 0..index {
                current = current.unwrap().borrow().next.clone();
            }

            // get the reference of next node of current node
            let next = current.as_ref().unwrap().borrow().next.clone();
            // next node prev will point to current node
            next.as_ref()
                .unwrap()
                .borrow_mut()
                .prev
                .clone_from(&current.as_ref().unwrap().borrow().prev);
            // prev node next will point to next node
            current.as_ref().unwrap().borrow_mut().next = next.clone();

            self.len -= 1;
        }
    }

    pub fn pop_back(&mut self) {
        if self.is_empty() {
            panic!("List is empty");
        } else if self.len() == 1 {
            self.head = None;
            self.tail = None;
        } else {
            // get the reference of prev node of tail
            let prev = self.tail.as_ref().unwrap().borrow().prev.clone();
            // prev node next will point to None
            prev.as_ref().unwrap().borrow_mut().next = None;
            // tail will point to prev node, so last node will be removed
            self.tail = prev;
        }

        self.len -= 1;
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_push_front() {
        let mut list = DoublyLinkedList::new();
        assert_eq!(list.len(), 0);
        assert!(list.is_empty());

        list.push_front(1);
        assert_eq!(list.len(), 1);
        assert!(!list.is_empty());

        list.push_front(2);
        assert_eq!(list.len(), 2);
        assert!(!list.is_empty());
    }

    #[test]
    fn test_push_at() {
        let mut list = DoublyLinkedList::new();
        assert_eq!(list.len(), 0);
        assert!(list.is_empty());

        list.push_at(1, 0);
        assert_eq!(list.len(), 1);
        assert!(!list.is_empty());

        list.push_at(2, 1);
        assert_eq!(list.len(), 2);
        assert!(!list.is_empty());

        list.push_at(3, 1);
        assert_eq!(list.len(), 3);
        assert!(!list.is_empty());
    }

    #[test]
    fn test_push_back() {
        let mut list = DoublyLinkedList::new();
        assert_eq!(list.len(), 0);
        assert!(list.is_empty());

        list.push_back(1);
        assert_eq!(list.len(), 1);
        assert!(!list.is_empty());

        list.push_back(2);
        assert_eq!(list.len(), 2);
        assert!(!list.is_empty());
    }

    #[test]
    fn test_pop_front() {
        let mut list = DoublyLinkedList::new();
        assert_eq!(list.len(), 0);
        assert!(list.is_empty());

        list.push_back(1);
        list.push_back(2);
        list.push_back(3);
        assert_eq!(list.len(), 3);
        assert!(!list.is_empty());

        list.pop_front();
        assert_eq!(list.len(), 2);
        assert!(!list.is_empty());

        list.pop_front();
        assert_eq!(list.len(), 1);
        assert!(!list.is_empty());

        list.pop_front();
        assert_eq!(list.len(), 0);
        assert!(list.is_empty());
    }

    #[test]
    fn test_pop_at() {
        let mut list = DoublyLinkedList::new();
        assert_eq!(list.len(), 0);
        assert!(list.is_empty());

        list.push_front(1);
        assert_eq!(list.len(), 1);
        list.push_back(2);
        list.push_back(3);
        assert_eq!(list.len(), 3);
        assert!(!list.is_empty());

        list.pop_at(1);
        assert_eq!(list.len(), 2);
        assert!(!list.is_empty());

        list.pop_at(1);
        assert_eq!(list.len(), 1);
        assert!(!list.is_empty());

        list.pop_at(0);
        assert_eq!(list.len(), 0);
        assert!(list.is_empty());
    }

    #[test]
    fn test_pop_back() {
        let mut list = DoublyLinkedList::new();
        assert_eq!(list.len(), 0);
        assert!(list.is_empty());

        list.push_back(1);
        list.push_back(2);
        list.push_back(3);
        assert_eq!(list.len(), 3);
        assert!(!list.is_empty());

        list.pop_back();
        assert_eq!(list.len(), 2);
        assert!(!list.is_empty());

        list.pop_back();
        assert_eq!(list.len(), 1);
        assert!(!list.is_empty());

        list.pop_back();
        assert_eq!(list.len(), 0);
        assert!(list.is_empty());
    }
}
