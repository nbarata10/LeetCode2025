package main.java.leetcode.january;

import java.util.*;

/**
 * <p>
 * Solves LeetCode challenge from January 6th 2025:
 * </p>
 *
 * <p>
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/editorial/?envType=daily-question&envId=2025-01-06">
 * January 6th 2025 Problem
 * </a>
 * </p>
 *
 * @author nbarata10
 */
public class JanuarySixth {
    public static void main(String[] args) {
        final String boxes = "110";
        //final String boxes1 = "001011";

        minOperations(boxes);
    }

    private static int[] minOperations(final String boxes) {
        final int n = boxes.length();
        final char[] boxesAsCharArray = boxes.toCharArray();

        final int[] minimumOperations = new int[n];

        final Set<Integer> allIndexesWithOne = new HashSet<>();

        for(int i=0; i<n; i++){
            if('1' == boxesAsCharArray[i]) {
                allIndexesWithOne.add(i);
            }
        }

        for(int j=0; j<n; j++){
            for(final int indexWithOne : allIndexesWithOne) {
                minimumOperations[j] += Math.abs(indexWithOne-j);
            }
        }

        return minimumOperations;
    }
}
