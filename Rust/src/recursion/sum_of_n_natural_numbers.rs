pub fn sum_of_n_natural_numbers(n: i32) -> i32 {
    if n == 0 {
        0
    } else {
        n + sum_of_n_natural_numbers(n - 1)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_sum_of_n_natural_numbers() {
        assert_eq!(sum_of_n_natural_numbers(0), 0);
        assert_eq!(sum_of_n_natural_numbers(1), 1);
        assert_eq!(sum_of_n_natural_numbers(2), 3);
        assert_eq!(sum_of_n_natural_numbers(3), 6);
        assert_eq!(sum_of_n_natural_numbers(4), 10);
        assert_eq!(sum_of_n_natural_numbers(5), 15);
        assert_eq!(sum_of_n_natural_numbers(6), 21);
        assert_eq!(sum_of_n_natural_numbers(7), 28);
        assert_eq!(sum_of_n_natural_numbers(8), 36);
        assert_eq!(sum_of_n_natural_numbers(9), 45);
        assert_eq!(sum_of_n_natural_numbers(10), 55);
    }
}
