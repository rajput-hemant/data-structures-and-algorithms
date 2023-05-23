pub use super::SortOrder;

/// Selection sort algorithm.
///
/// # Arguments
/// * `arr` - A mutable reference to an array to be sorted.
/// * `order` - Sort order.
///
/// # Examples
/// ```
/// use rust::sorting::{selection_sort, SortOrder};
///
/// let mut arr = [5, 4, 3, 2, 1];
/// selection_sort(&mut arr, SortOrder::Asc);
/// assert_eq!(arr, [1, 2, 3, 4, 5]);
/// ```
///
/// # Time complexity
/// * O(n^2)
///
/// # Space complexity
/// * O(1)
pub fn selection_sort<T: PartialOrd>(arr: &mut [T], order: SortOrder) {
    for i in 0..arr.len() - 1 {
        let mut min = i;

        for j in i + 1..arr.len() {
            match order {
                SortOrder::Asc => {
                    if arr[j] < arr[min] {
                        min = j;
                    }
                }

                SortOrder::Des => {
                    if arr[j] > arr[min] {
                        min = j;
                    }
                }
            }
        }

        arr.swap(i, min);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_selection_sort_asc() {
        let mut arr = [5, 4, 3, 2, 1];
        selection_sort(&mut arr, SortOrder::Asc);
        assert_eq!(arr, [1, 2, 3, 4, 5]);
    }

    #[test]
    fn test_selection_sort_des() {
        let mut arr = [1, 2, 3, 4, 5];
        selection_sort(&mut arr, SortOrder::Des);
        assert_eq!(arr, [5, 4, 3, 2, 1]);
    }
}
