pub use super::SortOrder;

/// Heap sort algorithm.
///
/// # Arguments
/// * `arr` - A mutable slice of elements of type T.
/// * `order` - A value of type SortOrder.
///
/// # Examples
/// ```
/// use rust::sorting::{heap_sort, SortOrder};
///
/// let mut arr = [1, 3, 2, 5, 4];
/// heap_sort(&mut arr, SortOrder::Asc);
/// assert_eq!(arr, [1, 2, 3, 4, 5]);
///
/// ```
///
/// # Time complexity
/// * O(n log n)
///
/// # Space complexity
/// * O(1)
pub fn heap_sort<T: PartialOrd>(arr: &mut [T], order: SortOrder) {
    // build heap
    build_heap(arr, order);

    for i in (1..arr.len()).rev() {
        arr.swap(0, i);
        match order {
            SortOrder::Asc => max_heapify(arr, 0, i),
            SortOrder::Des => min_heapify(arr, 0, i),
        }
    }
}

fn build_heap<T: PartialOrd>(arr: &mut [T], order: SortOrder) {
    // bottom-most right-most internal node
    let bmrmin = arr.len() - 2 >> 1; // right shift by 1 (arr.len() - 2)

    for i in (0..=bmrmin).rev() {
        match order {
            SortOrder::Asc => max_heapify(arr, i, arr.len()),
            SortOrder::Des => min_heapify(arr, i, arr.len()),
        }
    }
}

fn max_heapify<T: PartialOrd>(arr: &mut [T], i: usize, n: usize) {
    let mut largest = i;
    let (l, r) = (2 * i + 1, 2 * i + 2);

    if l < n && arr[l] > arr[largest] {
        largest = l;
    }

    if r < n && arr[r] > arr[largest] {
        largest = r;
    }

    if largest != i {
        arr.swap(i, largest);
        max_heapify(arr, largest, n);
    }
}

fn min_heapify<T: PartialOrd>(arr: &mut [T], i: usize, n: usize) {
    let mut smallest = i;
    let (l, r) = (2 * i + 1, 2 * i + 2);

    if l < n && arr[l] < arr[smallest] {
        smallest = l;
    }

    if r < n && arr[r] < arr[smallest] {
        smallest = r;
    }

    if smallest != i {
        arr.swap(i, smallest);
        min_heapify(arr, smallest, n);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn heapmerge_sort_asc() {
        let mut arr = [1, 3, 2, 5, 4];
        heap_sort(&mut arr, SortOrder::Asc);
        assert_eq!(arr, [1, 2, 3, 4, 5]);
    }

    #[test]
    fn heapmerge_sort_des() {
        let mut arr = [1, 3, 2, 5, 4];
        heap_sort(&mut arr, SortOrder::Des);
        assert_eq!(arr, [5, 4, 3, 2, 1]);
    }
}
