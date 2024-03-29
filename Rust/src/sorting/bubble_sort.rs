pub use super::SortOrder;

/// Bubble sort algorithm.
///
/// ### Arguments
/// * `arr` - A mutable reference to an array to be sorted.
/// * `order` - Sort order.
///
/// ### Examples
/// ```
/// use rust::sorting::{bubble_sort, SortOrder};
///
/// let mut arr = [1, 3, 2, 5, 4];
/// bubble_sort(&mut arr, SortOrder::Asc);
/// assert_eq!(arr, [1, 2, 3, 4, 5]);
///
/// let mut arr = [1, 3, 2, 5, 4];
/// bubble_sort(&mut arr, SortOrder::Des);
/// assert_eq!(arr, [5, 4, 3, 2, 1]);
/// ```
///
/// ### Time Complexity
/// * Worst-case - O(n^2)
/// * Best-case - O(n)
/// * Average-case - O(n^2)
///
/// ### Space Complexity
/// * O(1)
pub fn bubble_sort<T: PartialOrd>(arr: &mut [T], order: SortOrder) {
    for i in 0..arr.len() {
        for j in 0..arr.len() - 1 - i {
            match order {
                SortOrder::Asc => {
                    if arr[j] > arr[j + 1] {
                        arr.swap(j, j + 1);
                    }
                }

                SortOrder::Des => {
                    if arr[j] < arr[j + 1] {
                        arr.swap(j, j + 1);
                    }
                }
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_bubble_sort_asc() {
        let mut arr = [1, 3, 2, 5, 4];
        bubble_sort(&mut arr, SortOrder::Asc);
        assert_eq!(arr, [1, 2, 3, 4, 5]);
    }

    #[test]
    fn test_bubble_sort_des() {
        let mut arr = [1, 3, 2, 5, 4];
        bubble_sort(&mut arr, SortOrder::Des);
        assert_eq!(arr, [5, 4, 3, 2, 1]);
    }
}
