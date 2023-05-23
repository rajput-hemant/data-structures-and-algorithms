#[derive(Clone, Copy)]
pub enum SortOrder {
    Asc,
    Des,
}

pub mod bubble_sort;
pub mod heap_sort;
pub mod insertion_sort;
pub mod merge_sort;
pub mod quick_sort;
pub mod selection_sort;

pub use bubble_sort::bubble_sort;
pub use heap_sort::heap_sort;
pub use insertion_sort::insertion_sort;
pub use merge_sort::merge_sort;
pub use quick_sort::quick_sort;
pub use selection_sort::selection_sort;
