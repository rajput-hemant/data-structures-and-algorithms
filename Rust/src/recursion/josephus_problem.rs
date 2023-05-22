pub fn josephus(n: i32, k: i32) -> i32 {
    if n == 1 {
        return 0;
    }

    /*
    when we call josephus(n - 1, k), it returns the position of the survivor,
    however, the position is relative to the smaller circle of size n - 1.
    So, we need to add k to it to get the position in the original circle.
    e.g.
    0 -> k
    1 -> k + 1
    2 -> k + 2
    ...
    n -> k + n

    but, if k + n > n - 1, we need to wrap around the circle.
    n -> (k + n) % n
    */

    (josephus(n - 1, k) + k) % n
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_josephus() {
        assert_eq!(josephus(5, 3), 3);
        assert_eq!(josephus(5, 2), 2);
        assert_eq!(josephus(7, 3), 3);
        assert_eq!(josephus(7, 2), 6);
    }
}
