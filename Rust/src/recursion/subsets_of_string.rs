pub fn subsets_of_string(s: &str) -> Vec<String> {
    let mut result = Vec::default();
    let mut current = String::default();
    let index = 0;

    helper(s, &mut current, &mut result, index);

    result
}

fn helper(s: &str, current: &mut String, result: &mut Vec<String>, index: usize) {
    // when index == s.len(), we have reached the end of the string
    // and we can add the current string to the result
    if index == s.len() {
        result.push(current.clone()); // copy the current string and add it to the result
        return;
    }

    // include the current character
    helper(s, current, result, index + 1);
    current.push(s.chars().nth(index).unwrap());

    // exclude the current character
    helper(s, current, result, index + 1);
    current.pop();
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_subsets_of_string_empty() {
        assert_eq!(subsets_of_string(""), vec!["".to_string()]);
    }

    #[test]
    fn test_subsets_of_string_one() {
        assert_eq!(
            subsets_of_string("a"),
            vec!["".to_string(), "a".to_string()]
        );
    }

    #[test]
    fn test_subsets_of_string() {
        assert_eq!(
            subsets_of_string("abc"),
            vec![
                "".to_string(),
                "c".to_string(),
                "b".to_string(),
                "bc".to_string(),
                "a".to_string(),
                "ac".to_string(),
                "ab".to_string(),
                "abc".to_string()
            ]
        );
    }
}
