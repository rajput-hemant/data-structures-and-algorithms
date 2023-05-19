pub fn rope_cutting(n: isize, a: isize, b: isize, c: isize) -> isize {
    if n == 0 {
        return 0;
    }

    if n < 0 {
        return -1;
    }

    let res = rope_cutting(n - a, a, b, c)
        .max(rope_cutting(n - b, a, b, c))
        .max(rope_cutting(n - c, a, b, c));

    if res < 0 {
        -1
    } else {
        res + 1
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_rope_cutting() {
        assert_eq!(rope_cutting(5, 2, 5, 1), 5);
        assert_eq!(rope_cutting(23, 12, 9, 11), 2);
        assert_eq!(rope_cutting(5, 4, 2, 6), -1);
        assert_eq!(rope_cutting(9, 2, 2, 2), -1);
    }
}
