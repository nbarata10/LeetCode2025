package main.java.leetcode.january;

/**
 * <p>
 * Solves LeetCode challenge from January 5th 2025:
 * </p>
 *
 * <p>
 * <a href="https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/?envType=daily-question&envId=2025-01-08">
 * January 8th 2025 Problem
 * </a>
 * </p>
 *
 * @author nbarata10
 */
public class JanuaryEigth {
    public static void main(String[] args) {
        final String[] words = {"a","aba","ababa","aa"};
        final String[] words1 = {"pa","papa","ma","mama"};
        final String[] words2 = {"abab","ab"};

        final int answer = countPrefixSuffixPairs(words2);

        System.out.println("Number of Prefix And Sufix Pairs: " + answer);
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int numberOfPrefixSuffixPairs = 0;

        for(int i=0; i < words.length - 1; i++){
            for(int j=i+1; j < words.length; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    numberOfPrefixSuffixPairs++;
                }
            }
        }

        return numberOfPrefixSuffixPairs;
    }

    public static Boolean isPrefixAndSuffix(final String stringToEvaluate, final String completeString) {
        return completeString.startsWith(stringToEvaluate) && completeString.endsWith(stringToEvaluate);
    }
}
