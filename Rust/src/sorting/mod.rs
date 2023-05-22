pub enum SortOrder {
    Asc,
    Des,
}

pub mod bubble_sort;
pub mod insertion_sort;

pub use bubble_sort::bubble_sort;
pub use insertion_sort::insertion_sort;
