package main.java.leetcode.january;

import java.util.*;
import java.util.function.Predicate;

public class JanuaryFourth {
    private static final Integer NUMBER_OF_SUBSEQUENCE_CHARACTERS = 3;

    public static void main(String[] args) {
        final String input = "aabca";

        final Integer ans = countPalindromicSubsequences(input);


        System.out.println("Answer: " + ans);
    }

    public static int countPalindromicSubsequences(String s) {
        int n = s.length();

        // Arrays to store prefix and suffix frequency counts
        int[][] prefixCount = new int[n][26]; // prefixCount[i][c] = occurrences of character 'a' + c before index i
        int[][] suffixCount = new int[n][26]; // suffixCount[i][c] = occurrences of character 'a' + c after index i

        // Build prefixCount: Calculate the frequency of each character before each position
        for (int i = 1; i < n; i++) {
            System.arraycopy(prefixCount[i - 1], 0, prefixCount[i], 0, 26); // Copy previous counts
            prefixCount[i][s.charAt(i - 1) - 'a']++; // Increment the count for the character at position i-1
        }

        // Build suffixCount: Calculate the frequency of each character after each position
        for (int i = n - 2; i >= 0; i--) {
            System.arraycopy(suffixCount[i + 1], 0, suffixCount[i], 0, 26); // Copy next counts
            suffixCount[i][s.charAt(i + 1) - 'a']++; // Increment the count for the character at position i+1
        }

        // Set to store unique palindromic subsequences
        Set<String> uniquePalindromes = new HashSet<>();



        // Iterate over each character as the middle character of the palindrome
        for (int i = 1; i < n - 1; i++) { // Middle character can't be at the first or last position
            char middle = s.charAt(i); // The middle character of the current palindrome

            // Check all possible outer characters (a to z)
            for (int c = 0; c < 26; c++) {
                if (prefixCount[i][c] > 0 && suffixCount[i][c] > 0) {
                    // If the character 'a' + c exists in both prefix and suffix, it's a valid outer character
                    char outer = (char) ('a' + c); // Convert index to character
                    String palindrome = "" + outer + middle + outer; // Form the palindrome
                    uniquePalindromes.add(palindrome); // Add to the set (ensures uniqueness)
                }
            }
        }

        // Return the total number of unique palindromic subsequences
        return uniquePalindromes.size();
    }
}
