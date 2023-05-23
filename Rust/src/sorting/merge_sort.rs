pub use super::SortOrder;

/// Merge sort algorithm.
///
/// # Arguments
/// * `arr` - A mutable reference to an array to be sorted.
/// * `order` - Sort order.
///
/// # Examples
/// ```
/// use rust::sorting::{merge_sort, SortOrder};
///
/// let mut arr = [1, 3, 2, 5, 4];
/// merge_sort(&mut arr, SortOrder::Asc);
/// assert_eq!(arr, [1, 2, 3, 4, 5]);
/// ```
///
/// # Time complexity
/// * O(n log n)
///
/// # Space complexity
/// * O(n)
pub fn merge_sort<T>(arr: &mut [T], order: SortOrder)
where
    T: PartialOrd + Clone,
{
    let len = arr.len();

    if len <= 1 {
        return;
    }

    // let mid = len / 2;
    let mid = len >> 1; // rights shift len by 1 bit, same as len / 2
    merge_sort(&mut arr[..mid], order);
    merge_sort(&mut arr[mid..], order);

    merge(arr, order);
}

fn merge<T>(arr: &mut [T], order: SortOrder)
where
    T: PartialOrd + Clone,
{
    let mid = arr.len() / 2;

    // split arr into two parts and copy them to left and right
    let left = arr[..mid].to_vec();
    let right = arr[mid..].to_vec();

    // i, j, k are indices of left, right and arr respectively
    let (mut i, mut j, mut k) = (0, 0, 0);

    // merge left and right into arr
    while i < left.len() && j < right.len() {
        // match the sort order and compare left[i] and right[j]
        if match order {
            SortOrder::Asc => left[i] <= right[j],
            SortOrder::Des => left[i] >= right[j],
        } {
            // assign left[i] to arr[k] if left[i] <= right[j]
            arr[k].clone_from(&left[i]);
            i += 1; // increment the index of left array
        } else {
            // assign right[j] to arr[k] if left[i] > right[j]
            arr[k].clone_from(&right[j]);
            j += 1; // increment the index of right array
        }
        k += 1; // increment the index of arr
    }

    // copy the remaining elements of left to arr
    while i < left.len() {
        arr[k].clone_from(&left[i]);
        i += 1;
        k += 1;
    }

    // copy the remaining elements of right to arr
    while j < right.len() {
        arr[k].clone_from(&right[j]);
        j += 1;
        k += 1;
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_merge_sort_asc() {
        let mut arr = [1, 3, 2, 5, 4];
        merge_sort(&mut arr, SortOrder::Asc);
        assert_eq!(arr, [1, 2, 3, 4, 5]);
    }

    #[test]
    fn test_merge_sort_des() {
        let mut arr = [1, 3, 2, 5, 4];
        merge_sort(&mut arr, SortOrder::Des);
        assert_eq!(arr, [5, 4, 3, 2, 1]);
    }
}
