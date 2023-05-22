use super::SortOrder;

/// Insertion sort algorithm
/// ### Arguments
/// * `arr` - Vector of elements to be sorted
/// * `order` - Sort order
/// ### Returns
/// * `&mut Vec<T>` - Sorted vector
/// ### Examples
/// ```
/// use rust::sorting::{insertion_sort, SortOrder};
///
/// let mut arr = vec![5, 4, 3, 2, 1];
/// let sorted = insertion_sort(&mut arr, SortOrder::Asc);
/// assert_eq!(sorted, &[1, 2, 3, 4, 5]);
/// ```
/// ### Time Complexity
/// * Best case: O(n)
/// * Average case: O(n^2)
/// * Worst case: O(n^2)
/// ### Space Complexity
/// * O(1)
pub fn insertion_sort<T: PartialOrd + Copy>(arr: &mut Vec<T>, order: SortOrder) -> &mut Vec<T> {
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

    arr
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_insertion_sort_asc() {
        let mut arr = vec![5, 4, 3, 2, 1];
        let sorted = insertion_sort(&mut arr, SortOrder::Asc);
        assert_eq!(sorted, &[1, 2, 3, 4, 5]);
    }

    #[test]
    fn test_insertion_sort_des() {
        let mut arr = vec![1, 2, 3, 4, 5];
        let sorted = insertion_sort(&mut arr, SortOrder::Des);
        assert_eq!(sorted, &[5, 4, 3, 2, 1]);
    }
}
