package main.java.leetcode.january;

/**
 * <p>
 * Solves LeetCode challenge from January 5th 2025:
 * </p>
 *
 * <p>
 * <a href="https://leetcode.com/problems/counting-words-with-a-given-prefix/submissions/1503449521/?envType=daily-question&envId=2025-01-09">
 * January 9th 2025 Problem
 * </a>
 * </p>
 *
 * @author nbarata10
 */
public class JanuaryNinth {
    public static void main(String[] args) {
        final String[] words = new String[] {"pay","attention","practice","attend"};
        final String prefix = "at";

        final String[] words1 = new String[] {"leetcode","win","loops","success"};
        final String prefix1 = "code";

        final int numberOfPrefixes = prefixCount(words1, prefix1);

        System.out.println("Number of Prefixes: " + numberOfPrefixes);
    }

    public static int prefixCount(String[] words, String pref) {
        int prefixCount = 0;

        for(int i=0;  i<words.length; i++) {
            if(words[i].startsWith(pref)){
                prefixCount++;
            }
        }

        return prefixCount;
    }
}
