/// Binary search algorithm
/// ### Arguments
/// * `arr` - A vector of items to search
/// * `item` - The item to search for
/// ### Returns
/// * `Option<usize>` - The index of the item if found, otherwise None
/// ### Example
/// ```
/// use rust::searching::binary_search::binary_search;
/// let arr = vec![1, 2, 3, 4, 5];
/// let item = 3;
/// let index = binary_search(arr, item);
/// assert_eq!(index, Some(2));
/// ```
/// ### Time Complexity
/// `O(log n)`
/// ### Space Complexity
/// `O(1)`
pub fn binary_search<T: PartialOrd + Copy>(arr: Vec<T>, item: T) -> Option<usize> {
    let (mut low, mut high) = (0, arr.len() - 1);

    while low <= high {
        let mid = (low + high) / 2;

        if arr[mid] == item {
            return Some(mid);
        } else if arr[mid] > item {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_binary_search() {
        assert_eq!(binary_search(vec![1, 2, 3, 4, 5], 3), Some(2));
        assert_eq!(binary_search(vec!['a', 'b', 'c', 'd', 'e'], 'c'), Some(2));
    }

    #[test]
    fn test_binary_search_not_found() {
        assert_eq!(binary_search(vec![1, 2, 3, 4, 5], 6), None);
    }
}
