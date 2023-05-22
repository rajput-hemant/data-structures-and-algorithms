pub fn permute(s: &str) {
    helper(s, 0);
}

fn helper(s: &str, i: usize) {
    if i == s.len() - 1 {
        println!("{}", s);
        return;
    }
    for j in i..s.len() {
        let mut s = s.to_string().into_bytes();
        s.swap(i, j);
        let s = String::from_utf8(s).unwrap();
        helper(&s, i + 1);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_permute() {
        permute("abc");
        permute("pqrs");
    }
}
