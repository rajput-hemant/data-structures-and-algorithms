pub fn count_subsets(arr: &[i32], n: usize, sum: i32) -> i32 {
    if n == 0 {
        return if sum == 0 { 1 } else { 0 };
    }

    // do not include the last element + include the last element
    count_subsets(arr, n - 1, sum) + count_subsets(arr, n - 1, sum - arr[n - 1])
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_count_subsets() {
        assert_eq!(count_subsets(&[10, 20, 15], 3, 25), 1);
    }
}
