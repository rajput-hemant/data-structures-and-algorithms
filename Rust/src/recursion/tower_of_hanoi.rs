pub fn tower_of_hanoi(n: i32, from: char, to: char, aux: char) {
    if n == 1 {
        println!("Move disk 1 from rod {} to rod {}", from, to);
        return;
    }

    tower_of_hanoi(n - 1, from, aux, to);

    println!("Move disk {} from rod {} to rod {}", n, from, to);

    tower_of_hanoi(n - 1, aux, to, from);
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_tower_of_hanoi() {
        tower_of_hanoi(3, 'A', 'C', 'B');
    }

    #[test]
    fn test_tower_of_hanoi_1() {
        tower_of_hanoi(10, 'A', 'C', 'B');
    }
}
