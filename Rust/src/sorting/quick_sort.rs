pub use super::SortOrder;

/// Quick sort algorithm
///
/// # Arguments
/// * `arr` - A mutable reference to an array to be sorted.
/// * `order` - Sort order.
///
/// # Examples
/// ```
/// use rust::sorting::{quick_sort, SortOrder};
///
/// let mut arr = [1, 3, 2, 5, 4];
/// quick_sort(&mut arr, SortOrder::Asc);
/// assert_eq!(arr, [1, 2, 3, 4, 5]);
/// ```
///
/// # Time complexity
/// * O(n log n)
///
/// # Space complexity
/// * O(log n)
pub fn quick_sort<T: PartialOrd + Copy>(arr: &mut [T], order: SortOrder) {
    let len = arr.len();

    if len <= 1 {
        return;
    }

    let pivot = partition(arr, order);

    // recursive call to sort smaller elements than pivot
    quick_sort(&mut arr[..pivot], order);
    // recursive call to sort larger elements than pivot
    quick_sort(&mut arr[pivot + 1..], order);
}

// This function takes last element as pivot, places
// the pivot element at its correct position in sorted
// array, and places all smaller (smaller than pivot)
// to left of pivot and all greater elements to right
// of pivot
fn partition<T: PartialOrd + Copy>(arr: &mut [T], order: SortOrder) -> usize {
    let len = arr.len();
    let pivot_el = arr[len - 1];
    let mut i = 0; // index of smaller element

    // loop through all elements
    for j in 0..len - 1 {
        // match order and compare arr[j] and pivot_el
        if match order {
            SortOrder::Asc => arr[j] < pivot_el,
            SortOrder::Des => arr[j] > pivot_el,
        } {
            // if current element is smaller than the pivot
            // swap arr[i] and arr[j], this will move all
            // smaller elements to the left of pivot
            arr.swap(i, j);
            i += 1; // increment index of smaller element
        }
    }

    // after loop, swap pivot element with arr[i]
    arr.swap(i, len - 1);

    i
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn quick_sort_asc() {
        let mut arr = [1, 3, 2, 5, 4];
        quick_sort(&mut arr, SortOrder::Asc);
        assert_eq!(arr, [1, 2, 3, 4, 5]);
    }

    #[test]
    fn quick_sort_des() {
        let mut arr = [1, 3, 2, 5, 4];
        quick_sort(&mut arr, SortOrder::Des);
        assert_eq!(arr, [5, 4, 3, 2, 1]);
    }
}
