package main.java.leetcode.january;

/**
 * <p>
 * Solves LeetCode challenge from January 5th 2025:
 * </p>
 *
 * <p>
 * <a href="https://leetcode.com/problems/shifting-letters-ii/description/?envType=daily-question&envId=2025-01-05">
 * January 5th 2025 Problem
 * </a>
 * </p>
 *
 * @author nbarata10
 */
public class JanuaryFifth {
    private static final Integer BEGIN_INDEX_ARRAY_INDEX = 0;
    private static final Integer END_INDEX_ARRAY_INDEX = 1;
    private static final Integer SHIFTING_DIRECTION_ARRAY_INDEX = 2;
    private static final Integer BACKWARDS_SHIFTING_NUMBER = -1;


    public static void main(String[] args) {
        final String input = "abc";
        final int[][] shiftsMatrix = new int[][]{
                {0, 1, 0},
                {1, 2, 1},
                {0, 2, 1}
        };


        final String afterShiftingString = shiftingLetters(input, shiftsMatrix);

        System.out.println("Result after shifting: " + afterShiftingString);
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        final char[] sAsChars = s.toCharArray(); //['a','b','c']
        final int[] shiftsPerCharacter = new int[sAsChars.length];


        for (final int[] shiftToPerform : shifts) {
            final int beginIndex = shiftToPerform[BEGIN_INDEX_ARRAY_INDEX];
            final int endIndex = shiftToPerform[END_INDEX_ARRAY_INDEX];

            int numberToShift = calculateNumberToShiftPerShiftToPerform(shiftToPerform);

            shiftsPerCharacter[beginIndex] = shiftsPerCharacter[beginIndex] + numberToShift;

            if (Boolean.TRUE.equals(areBeginningIndexAndEndIndexDifferent(shiftToPerform))) {
                shiftsPerCharacter[endIndex] = shiftsPerCharacter[endIndex] + numberToShift;

                if (Boolean.TRUE.equals(isMultipleIndexesShifting(shiftToPerform))) {
                    for (int j = beginIndex + 1; j < endIndex; j++) {
                        shiftsPerCharacter[j] += numberToShift;
                    }
                }
            }
        }

        for (int n = 0; n < sAsChars.length; n++) {
            final int shiftToPerformWithinAlphabet = calculateCorrectShiftToPerformWithinAlphabet(shiftsPerCharacter[n]);

            sAsChars[n] = (char) ('a' +
                    ((sAsChars[n] - 'a' + shiftToPerformWithinAlphabet) % 26));
        }


        return new String(sAsChars);
    }

    private static Boolean isBackwardsShifting(final int[] shiftToPerform) {
        return shiftToPerform[SHIFTING_DIRECTION_ARRAY_INDEX] == 0;
    }

    private static Boolean areBeginningIndexAndEndIndexDifferent(final int[] shiftToPerform) {
        return shiftToPerform[BEGIN_INDEX_ARRAY_INDEX] != shiftToPerform[END_INDEX_ARRAY_INDEX];
    }

    private static Boolean isMultipleIndexesShifting(final int[] shiftToPerform) {
        return shiftToPerform[BEGIN_INDEX_ARRAY_INDEX] + 1 != shiftToPerform[END_INDEX_ARRAY_INDEX];
    }

    private static int calculateNumberToShiftPerShiftToPerform(final int[] shiftToPerform) {
        return (Boolean.FALSE.equals(isBackwardsShifting(shiftToPerform))) ? shiftToPerform[SHIFTING_DIRECTION_ARRAY_INDEX] : BACKWARDS_SHIFTING_NUMBER;
    }

    private static int calculateCorrectShiftToPerformWithinAlphabet(int initiallyCalculatedShift) {
        int correctShiftToPerformWithinAlphabet = initiallyCalculatedShift % 26;

        return (correctShiftToPerformWithinAlphabet < 0) ? correctShiftToPerformWithinAlphabet + 26 : correctShiftToPerformWithinAlphabet;
    }
}
