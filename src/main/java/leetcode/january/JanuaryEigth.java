package main.java.leetcode.january;

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
