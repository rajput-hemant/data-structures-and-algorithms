pub fn pallindrome_string(s: &str) -> bool {
    if s.len() <= 1 {
        true
    } else {
        let first = s.chars().next().unwrap();
        let last = s.chars().last().unwrap();

        if first != last {
            false
        } else {
            pallindrome_string(&s[1..s.len() - 1])
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_pallindrome_string() {
        assert!(pallindrome_string(""));
        assert!(pallindrome_string("a"));
        assert!(!pallindrome_string("ab"));
        assert!(pallindrome_string("aba"));
        assert!(pallindrome_string("abba"));
        assert!(!pallindrome_string("abbc"));
        assert!(pallindrome_string("abccba"));
        assert!(!pallindrome_string("abcdba"));
    }
}
