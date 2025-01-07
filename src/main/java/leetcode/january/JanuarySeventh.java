package main.java.leetcode.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Solves LeetCode challenge from January 6th 2025:
 * </p>
 *
 * <p>
 * <a href="https://leetcode.com/problems/string-matching-in-an-array/description/?envType=daily-question&envId=2025-01-07">
 * January 7th 2025 Problem
 * </a>
 * </p>
 *
 * @author nbarata10
 */
public class JanuarySeventh {
    public static void main(String[] args) {
        final String[] words = {"mass","as","hero","superhero"};

        stringMatching(words);
    }

    public static List<String> stringMatching(final String[] words) {
        final List<String> substringsOfAnotherWords = new ArrayList<>();

        for(final String word : words) {
            if(Arrays.stream(words).anyMatch(s -> !s.equals(word) && s.contains(word))){
                substringsOfAnotherWords.add(word);
            }
        }

        return substringsOfAnotherWords;
    }
}
