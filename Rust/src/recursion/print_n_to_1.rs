pub fn print_n_to_1(n: u32) {
    if n == 0 {
        return;
    }

    println!("{}", n);

    print_n_to_1(n - 1)
}
