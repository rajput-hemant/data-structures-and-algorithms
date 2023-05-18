pub fn print_n_to_1(n: u32) {
    if n == 0 {
        return;
    }

    println!("{}", n);

    print_n_to_1(n - 1) // <- Tail recursion.
}

pub fn print_1_to_n(n: u32) {
    if n == 0 {
        return;
    }

    print_1_to_n(n - 1);

    println!("{}", n);
}

// Note: Tail recursion is faster than normal recursion because it avoids storing the stack frame. It occurs when the last operation of a function is the recursive call, eliminating the need for storing the stack frame.

#[cfg(test)] // Compiler configuration. Only compile the following module when running tests.Q
mod tests {
    // Module declaration.
    use super::*; // Import all items from parent module.

    #[test]
    fn test_print_n_to_1() {
        print_n_to_1(5);
    }

    #[test]
    fn test_print_1_to_n() {
        print_1_to_n(5);
    }
}
