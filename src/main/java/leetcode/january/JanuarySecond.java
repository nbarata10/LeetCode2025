package main.java.leetcode.january;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JanuarySecond {


    public static void main(String[] args) {
        final String[] words = new String[]{"aba", "bcb", "ece", "aa", "e"};
        final int[][] queries = new int[][]{{0, 2}, {1, 4}, {1, 1}};

        vowelStrings(words, queries);
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] Prefix = new int[n + 1];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < n; i++) {
            Prefix[i + 1] = Prefix[i];
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                Prefix[i + 1]++;
            }
        }

        int[] ANS = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ANS[i] = Prefix[queries[i][1] + 1] - Prefix[queries[i][0]];
        }
        return ANS;
    }
}
