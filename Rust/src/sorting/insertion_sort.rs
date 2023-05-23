use super::SortOrder;

/// Insertion sort algorithm
///
/// ### Arguments
/// * `arr` - A mutable reference to an array to be sorted
/// * `order` - Sort order
///
/// ### Examples
/// ```
/// use rust::sorting::{insertion_sort, SortOrder};
///
/// let mut arr = [5, 4, 3, 2, 1];
/// insertion_sort(&mut arr, SortOrder::Asc);
/// assert_eq!(arr, [1, 2, 3, 4, 5]);
/// ```
///
/// ### Time Complexity
/// * Best case: O(n)
/// * Average case: O(n^2)
/// * Worst case: O(n^2)
///
/// ### Space Complexity
/// * O(1)
pub fn insertion_sort<T: PartialOrd>(arr: &mut [T], order: SortOrder) {
    for i in 1..arr.len() {
        let mut j = i;

        match order {
            SortOrder::Asc => {
                while j > 0 && arr[j - 1] > arr[j] {
                    arr.swap(j - 1, j);
                    j -= 1;
                }
            }
            SortOrder::Des => {
                while j > 0 && arr[j - 1] < arr[j] {
                    arr.swap(j - 1, j);
                    j -= 1;
                }
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_insertion_sort_asc() {
        let mut arr = [5, 4, 3, 2, 1];
        insertion_sort(&mut arr, SortOrder::Asc);
        assert_eq!(arr, [1, 2, 3, 4, 5]);
    }

    #[test]
    fn test_insertion_sort_des() {
        let mut arr = [1, 2, 3, 4, 5];
        insertion_sort(&mut arr, SortOrder::Des);
        assert_eq!(arr, [5, 4, 3, 2, 1]);
    }
}
