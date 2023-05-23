pub enum SortOrder {
    Asc,
    Des,
}

impl Clone for SortOrder {
    fn clone(&self) -> Self {
        match self {
            SortOrder::Asc => SortOrder::Asc,
            SortOrder::Des => SortOrder::Des,
        }
    }
}

impl Copy for SortOrder {}

pub mod bubble_sort;
pub mod insertion_sort;
pub mod merge_sort;
pub mod selection_sort;

pub use bubble_sort::bubble_sort;
pub use insertion_sort::insertion_sort;
pub use selection_sort::selection_sort;
