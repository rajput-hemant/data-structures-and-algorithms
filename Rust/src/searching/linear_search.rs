/// Linear search algorithm
/// ### Arguments
/// * `arr` - A vector of items to search
/// * `item` - The item to search for
/// ### Returns
/// * `Option<usize>` - The index of the item if found, otherwise None
/// ### Example
/// ```
/// use rust::searching::linear_search::linear_search;
/// let arr = vec![1, 2, 3, 4, 5];
/// let item = 3;
/// let index = linear_search(arr, item);
/// assert_eq!(index, Some(2));
/// ```
/// ### Time Complexity
/// `O(n)`
/// ### Space Complexity
/// `O(1)`
pub fn linear_search<T: PartialOrd + Copy>(arr: Vec<T>, item: T) -> Option<usize> {
    for i in 0..arr.len() {
        if arr[i] == item {
            return Some(i);
        }
    }

    None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_linear_search() {
        assert_eq!(linear_search(vec![1, 2, 3, 4, 5], 3), Some(2));
        assert_eq!(linear_search(vec!['a', 'b', 'c', 'd', 'e'], 'c'), Some(2));
    }

    #[test]
    fn test_linear_search_not_found() {
        assert_eq!(linear_search(vec![1, 2, 3, 4, 5], 6), None);
    }
}
