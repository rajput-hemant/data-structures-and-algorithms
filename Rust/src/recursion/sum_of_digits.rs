pub fn sum_of_digits(num: usize) -> usize {
    if num <= 9 {
        num
    } else {
        num % 10 + sum_of_digits(num / 10)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_sum_of_digits() {
        assert_eq!(sum_of_digits(0), 0);
        assert_eq!(sum_of_digits(1), 1);
        assert_eq!(sum_of_digits(10), 1);
        assert_eq!(sum_of_digits(11), 2);
        assert_eq!(sum_of_digits(12), 3);
        assert_eq!(sum_of_digits(123), 6);
        assert_eq!(sum_of_digits(1234), 10);
        assert_eq!(sum_of_digits(12345), 15);
        assert_eq!(sum_of_digits(123456), 21);
        assert_eq!(sum_of_digits(1234567), 28);
        assert_eq!(sum_of_digits(12345678), 36);
        assert_eq!(sum_of_digits(123456789), 45);
    }
}
